package services;

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

    public ParkingSlot createParkingSlot(int id, ParkingSpotType parkingSpotType, VehicleType vehicleType) {
        ParkingSlot parkingSlot = new ParkingSlot();
        parkingSlot.setParkingSlotNumber(id);
        parkingSlot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
        parkingSlot.setParkingSpotType(parkingSpotType);
        parkingSlot.setVehicleType(vehicleType);

        parkingSlotRepository.save(parkingSlot);
        return parkingSlot;
    }

    public void printParkingSlot(ParkingSlot parkingSlot){
        System.out.print(parkingSlot.getParkingSlotNumber()+ "-" + parkingSlot.getParkingSpotStatus().toString().charAt(0)+" "+ parkingSlot.getVehicleType().toString().charAt(0)+" | ");

    }
}
