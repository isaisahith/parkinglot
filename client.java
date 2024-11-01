import controllers.ParkingLotController;
import controllers.TicketController;
import dto.TicketReponseDto;
import dto.TicketRequestDto;
import models.Gate;
import models.Operator;
import models.ParkingLot;
import models.Ticket;
import models.constants.GateType;
import models.constants.ResponseStatus;
import models.constants.VehicleType;
import repositories.*;
import services.*;

public class client {
    public static void main(String[] args) {
        ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();
        OperatorRepository operatorRepository = new OperatorRepository();



        GateService gateService = new GateService(gateRepository);
        OperatorService operatorService = new OperatorService(operatorRepository);

        Operator operator1 = operatorService.addOperator("John", "john@g.com");
        Operator operator2 = operatorService.addOperator("Susan", "susan@g.com");


        Gate gate1 = gateService.addgate(GateType.ENTRY, operator1);
        Gate gate2 = gateService.addgate(GateType.EXIT, operator2);


        ParkingSlotService parkingSlotService = new ParkingSlotService(parkingSlotRepository);
        ParkingFloorService parkingFloorService = new ParkingFloorService(parkingFloorRepository, parkingSlotService);
        TicketService ticketService = new TicketService(ticketRepository, parkingSlotService);
        TicketController ticketController = new TicketController(ticketService, gateRepository, operatorRepository);


        ParkingLotService parkingLotService = new ParkingLotService(parkingLotRepository,
                parkingFloorService);

       // ParkingLot parkingLot = parkingLotService.create(1, "parkinglotGrand", "kjhaskjdhf",4,5,8);
        ParkingLotController parkingLotController = new ParkingLotController(parkingLotService);

        ParkingLot parkingLot =  parkingLotController.create(1, "GrandParkingLot","Address2", 5);

        try{
            parkingLotController.printParkingLot(0);
            TicketRequestDto ticketRequestDto = new TicketRequestDto(VehicleType.TWO_WHEELER,
                    "AP001", "Sai",0,0);

            TicketReponseDto ticketResposeDto = ticketController.issueTicket(ticketRequestDto);

            if(ticketResposeDto.getResponseStatus().equals(ResponseStatus.FAILURE)){
                System.out.println("Ticket is not issued");
            }else{
                Ticket ticket = ticketResposeDto.getTicket();
                System.out.println(ticket.getParkingSlot().getParkingSlotNumber());
            }
            parkingLotController.printParkingLot(0);

        }catch (Exception e){
            e.printStackTrace();
        }








    }
}
