package com.example.container_rounduse_marketplace_android.models;

public class Outbound {
    private String status;

    private Booking booking;

    private String goodsDescription;

    private String packingTime;

    private String deliveryTime;

    private String packingStation;

    private Double grossWeight;

    private String unitOfMeasurement;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public String getPackingTime() {
        return packingTime;
    }

    public void setPackingTime(String packingTime) {
        this.packingTime = packingTime;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getPackingStation() {
        return packingStation;
    }

    public void setPackingStation(String packingStation) {
        this.packingStation = packingStation;
    }

    public Double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }
}
