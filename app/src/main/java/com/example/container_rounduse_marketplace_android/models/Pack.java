package com.example.container_rounduse_marketplace_android.models;

public class Pack {

    private String packingStation, portOfLoading, packingTime, cutOffTime;
    private String status;
    private int Hinh;

    public Pack(String packingStation, String portOfLoading, String packingTime, String cutOffTime, String status, int hinh) {
        this.packingStation = packingStation;
        this.portOfLoading = portOfLoading;
        this.packingTime = packingTime;
        this.cutOffTime = cutOffTime;
        this.status = status;
        Hinh = hinh;
    }

    public String getPackingStation() {
        return packingStation;
    }

    public String getPortOfLoading() {
        return portOfLoading;
    }

    public String getPackingTime() {
        return packingTime;
    }

    public String getCutOffTime() {
        return cutOffTime;
    }

    public String getStatus() {
        return status;
    }

    public int getHinh() {
        return Hinh;
    }

    @Override
    public String toString() {
        return "Pack{" +
                "packingStation='" + packingStation + '\'' +
                ", portOfLoading='" + portOfLoading + '\'' +
                ", packingTime='" + packingTime + '\'' +
                ", cutOffTime='" + cutOffTime + '\'' +
                ", status='" + status + '\'' +
                ", Hinh=" + Hinh +
                '}';
    }
}
