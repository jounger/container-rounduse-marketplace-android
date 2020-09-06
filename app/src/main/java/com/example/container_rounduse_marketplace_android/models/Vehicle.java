package com.example.container_rounduse_marketplace_android.models;

public class Vehicle {
    private Long id;

    private String licensePlate;

    private Integer numberOfAxles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getNumberOfAxles() {
        return numberOfAxles;
    }

    public void setNumberOfAxles(Integer numberOfAxles) {
        this.numberOfAxles = numberOfAxles;
    }
}
