package com.example.container_rounduse_marketplace_android.models;

public class ContainerType {
    private Long id;

    private String name;

    private String description;

    private Double tareWeight;

    private Double grossWeight;

    private Double cubicCapacity;

    private Double internalLength;

    private Double internalWidth;

    private Double internalHeight;

    private Double doorOpeningWidth;

    private Double doorOpeningHeight;

    private String unitOfMeasurement;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTareWeight() {
        return tareWeight;
    }

    public void setTareWeight(Double tareWeight) {
        this.tareWeight = tareWeight;
    }

    public Double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public Double getCubicCapacity() {
        return cubicCapacity;
    }

    public void setCubicCapacity(Double cubicCapacity) {
        this.cubicCapacity = cubicCapacity;
    }

    public Double getInternalLength() {
        return internalLength;
    }

    public void setInternalLength(Double internalLength) {
        this.internalLength = internalLength;
    }

    public Double getInternalWidth() {
        return internalWidth;
    }

    public void setInternalWidth(Double internalWidth) {
        this.internalWidth = internalWidth;
    }

    public Double getInternalHeight() {
        return internalHeight;
    }

    public void setInternalHeight(Double internalHeight) {
        this.internalHeight = internalHeight;
    }

    public Double getDoorOpeningWidth() {
        return doorOpeningWidth;
    }

    public void setDoorOpeningWidth(Double doorOpeningWidth) {
        this.doorOpeningWidth = doorOpeningWidth;
    }

    public Double getDoorOpeningHeight() {
        return doorOpeningHeight;
    }

    public void setDoorOpeningHeight(Double doorOpeningHeight) {
        this.doorOpeningHeight = doorOpeningHeight;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }
}
