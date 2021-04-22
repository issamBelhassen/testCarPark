package com.sinapps;

import com.sinapps.controllers.CarParkController;
import com.sinapps.models.CarPark;
import com.sinapps.repositories.CarParkRepository;
import com.sinapps.services.GeolocationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CarParkControllerTest {

    /**
     * Create a mock
     */
    @Mock
    private GeolocationService geolocationService;

    @Mock
    CarParkRepository repository;

    /**
     * Inject mock
     */
    @InjectMocks
    private CarParkController carParkController;

    @Test
    @DisplayName("Test fetch nearby park cars")
    void testFindById() {

        List<CarPark> CarParks = new ArrayList<>();
        CarPark polygoneCarPark = new CarPark("polygoneParking",500,230, 43.6636073,7.1278413);
        CarPark champsElyseesCarPark = new CarPark("champsElyseesParking",800,400, 48.8707573,2.3053312);

        CarParks.add(polygoneCarPark);
        CarParks.add(champsElyseesCarPark);

        when(geolocationService.getDistanceLong(43.6636073,7.1278413,43.67097,7.17606)).thenReturn(5L);
        when(geolocationService.getDistanceLong(43.6636073,7.1278413,48.8707573,2.3053312)).thenReturn(1235L);
        when(repository.findAll()).thenReturn(CarParks);

        List<CarPark> nearbyCarParks = carParkController.fetchNearbyCarParks(43.6636073, 7.1278413);

        assertNotNull(nearbyCarParks);
        assertThat(nearbyCarParks).extracting(CarPark::getName).containsOnly("polygoneParking");
    }
}
