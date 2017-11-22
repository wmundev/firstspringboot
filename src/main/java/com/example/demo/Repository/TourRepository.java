package com.example.demo.Repository;

import com.example.demo.domain.Tour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.beans.annotation.AnnotationBeanUtils;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TourRepository extends CrudRepository<Tour, Integer> {
    List<Tour> findByTourPackageCode(@Param("code") String code);



}
