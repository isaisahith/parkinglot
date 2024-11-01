package models;

import java.util.Date;

public class Bill {
    private int id;
    private Date exitDate;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private Ticket ticket;
    private int amount;
    private Gate exitGate;


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public int getId() {
        return id;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }
}
