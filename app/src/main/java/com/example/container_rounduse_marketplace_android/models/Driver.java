package com.example.container_rounduse_marketplace_android.models;

public class Driver extends User {

    private String fullname;
    private String driverLicense;
    private GeoLocation location;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public GeoLocation getLocation() {
        return location;
    }

    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "fullname='" + fullname + '\'' +
                ", driverLicense='" + driverLicense + '\'' +
                ", location=" + location +
                '}';
    }
}
