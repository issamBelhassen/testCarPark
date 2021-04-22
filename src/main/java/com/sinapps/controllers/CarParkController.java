package com.sinapps.controllers;

import com.sinapps.models.CarPark;
import com.sinapps.repositories.CarParkRepository;
import com.sinapps.services.GeolocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CarParkController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarParkController.class);

    @Autowired
    CarParkRepository carParkRepository;

    @Autowired
    GeolocationService geolocationService;

    @GetMapping("/parks")
    public List<CarPark> findAll() {
        LOGGER.debug("Getting all car parks");
        return  (List<CarPark>) carParkRepository.findAll();
    }

    @GetMapping("/parks/{latitude}/{longitude}")
    public List<CarPark> fetchNearbyCarParks(@PathVariable double latitude, @PathVariable double longitude) {
        List<CarPark> CarParks = (List<CarPark>) carParkRepository.findAll();
        List<CarPark> nearbyCarParks = new ArrayList<>();

        for (CarPark carPark : CarParks) {
            long distance = geolocationService.getDistanceLong(latitude, longitude, carPark.getLatitude(), carPark.getLongitude());
            if (distance < 5) {
                nearbyCarParks.add(carPark);
            }
        }

        return nearbyCarParks;
    }

    @GetMapping("/park/{id}")
    public Optional<CarPark> findById(@PathVariable Long id) {
        LOGGER.debug("Getting car park={}", id);
        return carParkRepository.findById(id);
    }

    @RequestMapping(value = "/park", method = RequestMethod.POST)
    public ResponseEntity createCarPark(@RequestBody CarPark carPark) throws IOException {

        try {
            carParkRepository.save(carPark);
        } catch (DataIntegrityViolationException e) {
            LOGGER.warn("Exception occurred when trying to save the car park", e);

            return new ResponseEntity("car park create not done ", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity("car park create is done ", HttpStatus.CREATED);
    }
}
