package models;

import java.util.*;

import models.*;


public class ParkingLot {
    private int id;
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private List<Operator> operators;

    public List<Operator> getOperators() {
        return operators;
    }

    public void setOperators(List<Operator> operators) {
        this.operators = operators;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public String getAddress() {
        return address;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }
}