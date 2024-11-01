package controllers;
import models.Gate;
import models.ParkingLot;
import services.ParkingLotService;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotController {
    private ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public ParkingLot create(int id, String name, String address, int noOfFloors){
        List<Gate> gates = new ArrayList<Gate>();
        this.parkingLotService = parkingLotService;

        ParkingLot parkingLot = parkingLotService.create(id, name, address, noOfFloors, gates);

        return parkingLot;
    }

    public void printParkingLot(int id){
        try{
            parkingLotService.printParkingLot(id);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
