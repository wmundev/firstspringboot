package com.example.demo.service;

import com.example.demo.Repository.TourPackageRepository;
import com.example.demo.Repository.TourRepository;
import com.example.demo.domain.Difficulty;
import com.example.demo.domain.Region;
import com.example.demo.domain.Tour;
import com.example.demo.domain.TourPackage;
import org.omg.SendingContext.RunTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {
    private TourPackageRepository tourPackageRepository;
    private TourRepository tourRepository;

    @Autowired
    public TourService(TourPackageRepository tourPackageRepository, TourRepository tourRepository) {
        this.tourPackageRepository = tourPackageRepository;
        this.tourRepository = tourRepository;
    }

    public Tour createTour(String title, String description, String blurb, Integer price, String duration, String bullets,
                           String keywords, String tourPackageName, Difficulty difficulty, Region region){
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName);
        if(tourPackage == null){
            throw new RuntimeException("tour package does not exist" + tourPackageName);
        }
        return tourRepository.save( new Tour(title, description, blurb, price, duration, bullets, keywords, tourPackage, difficulty, region));
    }
    public Iterable<Tour> lookup(){
        return tourRepository.findAll();
    }
    public long total(){
        return tourRepository.count();
    }

}
