package services;
import  java.util.*;
import models.ParkingFloor;
import models.ParkingSlot;
import models.constants.ParkingSpotType;
import models.constants.VehicleType;
import repositories.ParkingFloorRepository;

public class ParkingFloorService {

    private ParkingFloorRepository parkingFloorRepository;
    private ParkingSlotService parkingSlotService;
    private static int id = 000;
    public ParkingFloorService(ParkingFloorRepository parkingFloorRepository, ParkingSlotService parkingSlotService) {
        this.parkingSlotService = parkingSlotService;
        this.parkingFloorRepository = parkingFloorRepository;
    }

    public ParkingFloor createParkingFloor(int floorNumber, int noOfSlots, VehicleType vehicleType) {
        id++;
        ParkingFloor parkingFloor = new ParkingFloor();
        parkingFloor.setFloorNumber(floorNumber);
        parkingFloor.setId(id);
        List<ParkingSlot> parkingSlots = new ArrayList<ParkingSlot>();

        for(int i=0; i<noOfSlots; i++) {
            parkingSlots.add(parkingSlotService.createParkingSlot(id*100+floorNumber, ParkingSpotType.NORMAL, vehicleType));
        }

        parkingFloor.setParkingSlots(parkingSlots);

        return parkingFloor;

    }

    public void printParkingFloor(ParkingFloor parkingFloor) {

        List<ParkingSlot> parkingSlots = parkingFloor.getParkingSlots();
        for(ParkingSlot parkingSlot : parkingSlots) {
            parkingSlotService.printParkingSlot(parkingSlot);

        }

    }
}
