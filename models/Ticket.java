package models;

import java.util.Date;

public class Ticket {
    private int id;
    private Vehicle vehicle;
    private  ParkingSlot parkingSlot;
    private Gate entryDate;
    private Date entryTime;
    private Operator operator;

    public Operator getOperator() {
        return operator;
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public Gate getEntryDate() {
        return entryDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setEntryDate(Gate entryDate) {
        this.entryDate = entryDate;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }
}