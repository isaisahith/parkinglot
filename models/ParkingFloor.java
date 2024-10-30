package models;

import java.util.*;

public class ParkingFloor {
    private int id;
    private int floorNumber;
    private List<ParkingSlot> parkingSlots;

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}