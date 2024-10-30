package services;
import  java.util.*;
import models.ParkingFloor;
import models.ParkingSlot;
import models.constants.ParkingSpotType;
import repositories.ParkingFloorRepository;

public class ParkingFloorService {

    private ParkingFloorRepository parkingFloorRepository;
    private ParkingSlotService parkingSlotService;

    public ParkingFloorService(ParkingFloorRepository parkingFloorRepository, ParkingSlotService parkingSlotService) {
        this.parkingSlotService = parkingSlotService;
        this.parkingFloorRepository = parkingFloorRepository;
    }

    public ParkingFloor createParkingFloor(int floorNumber, int noOfSlots, int id) {

        ParkingFloor parkingFloor = new ParkingFloor();
        parkingFloor.setFloorNumber(floorNumber);
        parkingFloor.setId(id);
        List<ParkingSlot> parkingSlots = new ArrayList<ParkingSlot>();

        for(int i=0; i<noOfSlots; i++) {
            parkingSlots.add(parkingSlotService.createParkingSlot(floorNumber*100+1, ParkingSpotType.NORMAL));
        }

        parkingFloor.setParkingSlots(parkingSlots);

        return parkingFloor;

    }
}
