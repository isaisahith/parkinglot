package repositories;
import models.ParkingFloor;
import java.util.*;
import exceptions.*;
public class ParkingFloorRepository {
    private Map<Integer, ParkingFloor> parkingsFloorMap;

    private static int id;

    public ParkingFloorRepository(Map<Integer, ParkingFloor> parkingsFloorMap) {
        this.parkingsFloorMap = parkingsFloorMap;
        this.id = 0;
    }

    public ParkingFloor getParkingFloor(int id) throws ParkingFoorNotFoundException {
        if(parkingsFloorMap.containsKey(id)){
            return parkingsFloorMap.get(id);
        }else{
            throw new ParkingFoorNotFoundException("Parking Floor not found");
        }
    }

    public ParkingFloor save(ParkingFloor parkingFloor){
        parkingsFloorMap.put(id, parkingFloor);
        id++;
        return parkingFloor;
    }

    public ParkingFloor update(int id, ParkingFloor parkingFloor) throws ParkingFoorNotFoundException {
        if(parkingsFloorMap.containsKey(id)){
            parkingsFloorMap.put(id, parkingFloor);
            return parkingFloor;
        }else{
            throw new ParkingFoorNotFoundException("Parking Floor not found");
        }
    }

    public void delete(int id) throws ParkingFoorNotFoundException {
        if(parkingsFloorMap.containsKey(id)){
            parkingsFloorMap.remove(id);
        }else{
            throw new ParkingFoorNotFoundException("Parking Floor not found");
        }
    }
}