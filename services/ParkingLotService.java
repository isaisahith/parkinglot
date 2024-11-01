package services;

import exceptions.ParkingLotNotFoundException;
import models.Gate;
import models.ParkingFloor;
import models.ParkingLot;
import models.constants.VehicleType;
import repositories.ParkingFloorRepository;
import repositories.ParkingLotRepository;
import repositories.ParkingSlotRepository;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotService {


    private ParkingLotRepository parkingLotRepository;


    private ParkingFloorService parkingFloorService;



    public ParkingLotService(ParkingLotRepository parkingLotRepository,ParkingFloorService parkingFloorService
    ) {


        this.parkingLotRepository = parkingLotRepository;

        this.parkingFloorService = parkingFloorService;


    }

    public ParkingLot create(int id, String name, String address,int noOfFloors, List<Gate> gates) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(id);
        parkingLot.setName(name);
        parkingLot.setAddress(address);
        parkingLot.setGates(gates);
        List<ParkingFloor> parkingFloorList = new ArrayList<>();
        int count=0;
        for(int i=0; i<noOfFloors/2; i++) {
            count++;
            ParkingFloor floor = parkingFloorService.createParkingFloor(i, 10, VehicleType.TWO_WHEELER);
            parkingFloorList.add(floor);
        }

        for(int i=0; i<noOfFloors-count;i++){
            ParkingFloor floor = parkingFloorService.createParkingFloor(noOfFloors-1, 10, VehicleType.FOUR_WHEELER);
            parkingFloorList.add(floor);
        }




        parkingLot.setParkingFloors(parkingFloorList);

        parkingLotRepository.save(parkingLot);




        return parkingLot;
    }


    public void printParkingLot(int id) throws ParkingLotNotFoundException {

        if(parkingLotRepository.getParkingLot(id)==null){
            throw new ParkingLotNotFoundException();
        }
        ParkingLot parkingLot = parkingLotRepository.getParkingLot(id);
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();

        for(ParkingFloor floor : parkingFloors) {
            parkingFloorService.printParkingFloor(floor);
            System.out.println();
        }

    }






}
