package services;

import models.ParkingFloor;
import models.ParkingSlot;
import models.Vehicle;
import models.constants.ParkingSpotStatus;
import models.constants.ParkingSpotType;
import models.constants.VehicleType;
import repositories.ParkingSlotRepository;

public class ParkingSlotService {

    private ParkingSlotRepository parkingSlotRepository;

    public ParkingSlotService(ParkingSlotRepository parkingSlotRepository) {
        this.parkingSlotRepository = parkingSlotRepository;
    }

    public ParkingSlot createParkingSlot(int id, ParkingSpotType parkingSpotType, VehicleType vehicleType, ParkingFloor parkingFloor) {
        ParkingSlot parkingSlot = new ParkingSlot();
        parkingSlot.setParkingSlotNumber(id);
        parkingSlot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
        parkingSlot.setParkingSpotType(parkingSpotType);
        parkingSlot.setVehicleType(vehicleType);
        parkingSlot.setParkingFloorNumber(parkingFloor);


        parkingSlotRepository.save(parkingSlot);
        return parkingSlot;
    }

    public void printParkingSlot(ParkingSlot parkingSlot){
        System.out.print(parkingSlot.getParkingSlotNumber()+ "-" + parkingSlot.getParkingSpotStatus().toString().charAt(0)+" "+ parkingSlot.getVehicleType().toString().charAt(0)+" | ");

    }

    public ParkingSlot assignSlot(Vehicle vehicle){

        for(ParkingSlot parkingSlot: parkingSlotRepository.getParkingslotMap().values()){
            if(parkingSlot.getVehicleType().equals(vehicle.getVehicleType())&& parkingSlot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY)){
                return parkingSlot;
            }
        }

        return null;
    }
}
