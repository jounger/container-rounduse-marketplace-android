package com.example.container_rounduse_marketplace_android.models;

public class Inbound extends Supply {
    private String emptyTime;

    private String pickupTime;

    private String returnStation;

    private BillOfLading billOfLading;

    public String getEmptyTime() {
        return emptyTime;
    }

    public void setEmptyTime(String emptyTime) {
        this.emptyTime = emptyTime;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getReturnStation() {
        return returnStation;
    }

    public void setReturnStation(String returnStation) {
        this.returnStation = returnStation;
    }

    public BillOfLading getBillOfLading() {
        return billOfLading;
    }

    public void setBillOfLading(BillOfLading billOfLading) {
        this.billOfLading = billOfLading;
    }

    @Override
    public String toString() {
        return "Inbound{" +
                "emptyTime='" + emptyTime + '\'' +
                ", pickupTime='" + pickupTime + '\'' +
                ", returnStation='" + returnStation + '\'' +
                ", billOfLading=" + billOfLading +
                '}';
    }
}
