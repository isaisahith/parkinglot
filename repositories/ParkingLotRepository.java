package repositories;
import java.util.*;
import exceptions.*;
import models.*;
public class ParkingLotRepository {
    private Map<Integer, ParkingLot> parkingLotMap;

    private static int id;

    public ParkingLotRepository(Map<Integer, ParkingLot> parkingLotMap) {
        this.parkingLotMap = parkingLotMap;
        this.id = 0;
    }

    public ParkingLot getParkingLot(int id) throws ParkingLotNotFoundException {
        if(parkingLotMap.containsKey(id)){
            return parkingLotMap.get(id);
        }else{
            throw new ParkingLotNotFoundException();
        }
    }

    public ParkingLot save(ParkingLot parkingLot){
        parkingLotMap.put(id, parkingLot);
        id++;
        return parkingLot;
    }

    public ParkingLot update(int id, ParkingLot parkingLot) throws ParkingLotNotFoundException {
        if(parkingLotMap.containsKey(id)){
            parkingLotMap.put(id, parkingLot);
            return parkingLot;
        }else{
            throw new ParkingLotNotFoundException();
        }
    }

    public void delete(int id) throws ParkingLotNotFoundException {
        if(parkingLotMap.containsKey(id)){
            parkingLotMap.remove(id);
        }else{
            throw new ParkingLotNotFoundException();
        }
    }
}