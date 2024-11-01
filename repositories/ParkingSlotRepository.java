package repositories;

import models.ParkingSlot;
import  java.util.*;
import exceptions.*;


public class ParkingSlotRepository {
    private Map<Integer, ParkingSlot> parkingslotMap;

    private static int id;

    public ParkingSlotRepository() {
        this.parkingslotMap = new HashMap<>();
        this.id = 0;
    }

    public ParkingSlot getParkingSlot(int id) throws ParkingSlotNotFoundException {
        if(parkingslotMap.containsKey(id)){
            return parkingslotMap.get(id);
        }else{
            throw new ParkingSlotNotFoundException("Parking slot not found");
        }
    }

    public ParkingSlot save(ParkingSlot parkingSlot){
        parkingslotMap.put(id, parkingSlot);
        id++;
        return parkingSlot;
    }

    public ParkingSlot update(int id, ParkingSlot parkingSlot) throws ParkingSlotNotFoundException {
        if(parkingslotMap.containsKey(id)){
            parkingslotMap.put(id, parkingSlot);
            return parkingSlot;
        }else{
            throw new ParkingSlotNotFoundException("Parking slot not found");
        }
    }

    public void deleteParkingSlot(int id) throws ParkingSlotNotFoundException {
        if(parkingslotMap.containsKey(id)){
            parkingslotMap.remove(id);
        }else{
            throw new ParkingSlotNotFoundException("Parking slot not found");
        }
    }
}