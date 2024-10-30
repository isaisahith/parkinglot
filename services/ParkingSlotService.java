package services;

import models.ParkingSlot;
import models.constants.ParkingSpotStatus;
import models.constants.ParkingSpotType;
import repositories.ParkingSlotRepository;

public class ParkingSlotService {

    private ParkingSlotRepository parkingSlotRepository;

    public ParkingSlotService(ParkingSlotRepository parkingSlotRepository) {
        this.parkingSlotRepository = parkingSlotRepository;
    }

    public ParkingSlot createParkingSlot(int id, ParkingSpotType parkingSpotType) {
        ParkingSlot parkingSlot = new ParkingSlot();
        parkingSlot.setParkingSlotNumber(id);
        parkingSlot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
        parkingSlot.setParkingSpotType(parkingSpotType);
        parkingSlotRepository.save(parkingSlot);
        return parkingSlot;
    }
}
