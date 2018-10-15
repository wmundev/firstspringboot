package com.example.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.example.demo.Repository.TourPackageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TourPackageTest {

  @Autowired
  private TourPackageRepository tourPackageRepository;

  @Test
  public void testTourPackageRepository() {
    assertNotNull(tourPackageRepository.findByName("Backpack Cal"));
    assertNull(tourPackageRepository.findByName("definitely does not exist"));

  }

}
