package models;

import models.constants.*;

public class ParkingSlot {

    private int parkingSlotNumber;
    private ParkingSpotStatus parkingSpotStatus;
    private  ParkingSpotType parkingSpotType;

    public int getParkingSlotNumber() {
        return parkingSlotNumber;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return this.parkingSpotStatus;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSlotNumber(int parkingSlotNumber) {
        this.parkingSlotNumber = parkingSlotNumber;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }
}