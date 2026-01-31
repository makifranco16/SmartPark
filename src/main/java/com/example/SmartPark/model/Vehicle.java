package com.example.SmartPark.model;

public class Vehicle {
    private String licensePlate;
    private String type;
    private String ownerName;
    private String parkedLotId;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getParkedLotId() {
        return parkedLotId;
    }

    public void setParkedLotId(String parkedLotId) {
        this.parkedLotId = parkedLotId;
    }
}
