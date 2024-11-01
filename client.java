import models.ParkingLot;
import repositories.ParkingFloorRepository;
import repositories.ParkingLotRepository;
import repositories.ParkingSlotRepository;
import services.ParkingFloorService;
import services.ParkingLotService;
import services.ParkingSlotService;

public class client {
    public static void main(String[] args) {
        ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

        ParkingSlotService parkingSlotService = new ParkingSlotService(parkingSlotRepository);
        ParkingFloorService parkingFloorService = new ParkingFloorService(parkingFloorRepository, parkingSlotService);


        ParkingLotService parkingLotService = new ParkingLotService(parkingLotRepository,
                parkingFloorService);

        ParkingLot parkingLot = parkingLotService.create(1, "parkinglotGrand", "kjhaskjdhf",4,5,8);

        try{
            parkingLotService.printParkingLot(parkingLot);
        }catch (Exception e){
            e.printStackTrace();
        }

//        try{
//            System.out.println(parkingLotRepository.getParkingLot(0));
//        }catch (Exception e){
//            e.printStackTrace();
//        }





    }
}
