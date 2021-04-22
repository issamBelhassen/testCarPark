package com.sinapps.implimentations;

import com.sinapps.services.GeolocationService;
import org.apache.lucene.util.SloppyMath;
import org.springframework.stereotype.Service;

/**
 Implementation Geolocation service
 */

@Service
public class GeolocationServiceImpl implements GeolocationService {

    @Override
    public Long getDistanceLong(double latitude, double longitude, double latitudePark, double longitudePark) {

        return distance(latitude, longitude, latitudePark, longitudePark);
    }

    private static long distance(double lat1, double lon1, double lat2, double lon2) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        } else {
            return Math.round(SloppyMath.haversinMeters(lat1, lon1, lat2, lon2) / 1000);
        }
    }
}
