package com.sinapps.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarPark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int total;
    private int libre;
    private double latitude;
    private double longitude;

    public CarPark() {
    }

    public CarPark(String name, int total, int libre, double latitude, double longitude) {
        this.name = name;
        this.total = total;
        this.libre = libre;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getLibre() {
        return libre;
    }

    public void setLibre(int libre) {
        this.libre = libre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "carPark{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", total=" + total +
                ", libre=" + libre +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
