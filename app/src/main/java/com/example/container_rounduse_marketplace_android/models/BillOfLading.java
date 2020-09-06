package com.example.container_rounduse_marketplace_android.models;

import java.util.HashSet;
import java.util.Set;

public class BillOfLading {
    private Long id;

    private Port portOfDelivery;

    private String number;

    private String freeTime;

    private Integer unit;

    private Set<Container> containers = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Port getPortOfDelivery() {
        return portOfDelivery;
    }

    public void setPortOfDelivery(Port portOfDelivery) {
        this.portOfDelivery = portOfDelivery;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(String freeTime) {
        this.freeTime = freeTime;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Set<Container> getContainers() {
        return containers;
    }

    public void setContainers(Set<Container> containers) {
        this.containers = containers;
    }

    @Override
    public String toString() {
        return "BillOfLading{" +
                "id=" + id +
                ", portOfDelivery=" + portOfDelivery +
                ", number='" + number + '\'' +
                ", freeTime='" + freeTime + '\'' +
                ", unit=" + unit +
                ", containers=" + containers +
                '}';
    }
}
