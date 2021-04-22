package com.sinapps.services;

/**
 Geolocation service to manage distance between positions
 */
public interface GeolocationService {

    Long getDistanceLong(double latitude, double longitude, double latitudeParking, double longitudeParking);
}
