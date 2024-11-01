package models;

import models.constants.*;

public class ParkingSlot {

    private int parkingSlotNumber;
    private ParkingSpotStatus parkingSpotStatus;
    private  ParkingSpotType parkingSpotType;
    private VehicleType vehicleType;
    private ParkingFloor parkingFloorNumber;

    public ParkingFloor getParkingFloorNumber() {
        return parkingFloorNumber;
    }

    public void setParkingFloorNumber(ParkingFloor parkingFloorNumber) {
        this.parkingFloorNumber = parkingFloorNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

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