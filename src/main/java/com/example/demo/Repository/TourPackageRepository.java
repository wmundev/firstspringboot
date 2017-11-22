package com.example.demo.Repository;

import com.example.demo.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TourPackageRepository extends CrudRepository<TourPackage, String>{
    TourPackage findByName(@Param("name")String name);

}
