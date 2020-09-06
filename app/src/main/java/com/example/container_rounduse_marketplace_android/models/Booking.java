package com.example.container_rounduse_marketplace_android.models;

public class Booking {
    private Long id;

    private Port portOfLoading;

    private String number;

    private Integer unit;

    private String cutOffTime;

    private Boolean isFcl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Port getPortOfLoading() {
        return portOfLoading;
    }

    public void setPortOfLoading(Port portOfLoading) {
        this.portOfLoading = portOfLoading;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public String getCutOffTime() {
        return cutOffTime;
    }

    public void setCutOffTime(String cutOffTime) {
        this.cutOffTime = cutOffTime;
    }

    public Boolean getFcl() {
        return isFcl;
    }

    public void setFcl(Boolean fcl) {
        isFcl = fcl;
    }
}
