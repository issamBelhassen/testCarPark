package com.sinapps;

import com.sinapps.models.CarPark;
import com.sinapps.repositories.CarParkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    CarParkRepository carParkRepository;

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("StartApplication...");

        List<CarPark> carParksToSave = new ArrayList<>();
        CarPark polygoneCarPark = new CarPark("polygoneCarPark",500,230, 43.6636073,7.1278413);
        CarPark champsElyseesCarPark = new CarPark("champsElyseesCarPark",800,400, 48.8707573,2.3053312);

        carParksToSave.add(polygoneCarPark);
        carParksToSave.add(champsElyseesCarPark);

        for(CarPark carPark : carParksToSave) {
            if(carParkRepository.findByName(carPark.getName()).isEmpty()){
                carParkRepository.save(carPark);
            }
        }
    }
}
