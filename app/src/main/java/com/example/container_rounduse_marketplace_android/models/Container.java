package com.example.container_rounduse_marketplace_android.models;

public class Container {
    private Long id;

    private Driver driver;

    private ContainerSemiTrailer trailer;

    private ContainerTractor tractor;

    private String number;

    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public ContainerSemiTrailer getTrailer() {
        return trailer;
    }

    public void setTrailer(ContainerSemiTrailer trailer) {
        this.trailer = trailer;
    }

    public ContainerTractor getTractor() {
        return tractor;
    }

    public void setTractor(ContainerTractor tractor) {
        this.tractor = tractor;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
