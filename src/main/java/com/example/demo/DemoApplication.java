package com.example.demo;

import com.example.demo.domain.Difficulty;
import com.example.demo.domain.Region;
import com.example.demo.domain.TourPackage;
import com.example.demo.service.TourPackageService;
import com.example.demo.service.TourService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

import static com.example.demo.DemoApplication.TourFromFile.importTours;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	private TourPackageService tourPackageService;
	private TourService tourService;

	@Autowired
    public DemoApplication(TourPackageService tourPackageService, TourService tourService) {
        this.tourPackageService = tourPackageService;
        this.tourService = tourService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        //Create the default tour packages
        tourPackageService.createTourPackage("BC", "Backpack Cal");
        tourPackageService.createTourPackage("CC", "California Calm");
        tourPackageService.createTourPackage("CH", "California Hot springs");
        tourPackageService.createTourPackage("CY", "Cycle California");
        tourPackageService.createTourPackage("DS", "From Desert to Sea");
        tourPackageService.createTourPackage("KC", "Kids California");
        tourPackageService.createTourPackage("NW", "Nature Watch");
        tourPackageService.createTourPackage("SC", "Snowboard Cali");
        tourPackageService.createTourPackage("TC", "Taste of California");
        tourPackageService.lookup().forEach(tourPackage -> System.out.println(tourPackage));

        //Persist the Tours to the database
        importTours().forEach(t-> tourService.createTour(
                t.title,
                t.description,
                t.blurb,
                Integer.parseInt(t.price),
                t.length,
                t.bullets,
                t.keywords,
                t.packageType,
                Difficulty.valueOf(t.difficulty),
                Region.findByLabel(t.region)));
        System.out.println("Number of tours =" + tourService.total());
    }



    /**
     * Helper class to import the records in the ExploreCalifornia.json
     */
    static class TourFromFile {
        //attributes as listed in the .json file
        private String packageType, title, description, blurb, price, length, bullets, keywords,  difficulty, region;

        /**
         * Open the ExploreCalifornia.json, unmarshal every entry into a TourFromFile Object.
         *
         * @return a List of TourFromFile objects.
         * @throws IOException if ObjectMapper unable to open file.
         */
        static List<TourFromFile> importTours() throws IOException {
            return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).
                    readValue(TourFromFile.class.getResourceAsStream("/ExploreCalifornia.json"),new TypeReference<List<TourFromFile>>(){});
        }
    }
}
