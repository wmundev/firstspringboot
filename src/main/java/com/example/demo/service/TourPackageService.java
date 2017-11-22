package com.example.demo.service;


import com.example.demo.Repository.TourPackageRepository;
import com.example.demo.domain.Tour;
import com.example.demo.domain.TourPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourPackageService {
    private TourPackageRepository tourPackageRepository;
    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    public TourPackage createTourPackage(String code, String name){
        if((!tourPackageRepository.exists(code))){
            tourPackageRepository.save( new TourPackage(code, name));
        }
        return null;
    }
    public Iterable<TourPackage> lookup() {
        return tourPackageRepository.findAll();
    }
    public long total(){
        return tourPackageRepository.count();
    }

}
