package com.sinapps;

import com.sinapps.models.CarPark;
import com.sinapps.repositories.CarParkRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarParkTest {

    @Autowired
    CarParkRepository repository;

    CarPark cap3000;

    @Before
    public void setUp() {
        cap3000 = new CarPark("cap3000Parking",800,400, 48.8707573,2.3053312);
        repository.save(cap3000);
    }

    @Test
    public void setsIdOnSave() {
        assertNotNull(cap3000.getId());
    }

    @Test
    public void findByName() {
        List<CarPark> CarParks = repository.findByName("cap3000Parking");
        assertThat(CarParks).extracting(CarPark::getName).containsOnly("cap3000Parking");
    }
    @After
    public void cleanDB(){
        repository.delete(cap3000);
    }
}
