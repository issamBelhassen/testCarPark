package com.sinapps;

import com.sinapps.services.GeolocationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GeolocationServiceTest {

    @Autowired
    GeolocationService geolocationService;

    @Test
    @DisplayName("Test calcul distance")
    void testCalculDistance() {
        assertEquals(new Long(0), geolocationService.getDistanceLong(43.6636073,7.1278413,43.6636073,7.1278413));
        assertEquals(new Long(4), geolocationService.getDistanceLong(43.6636073,7.1278413,43.67097,7.17606));
    }
}
