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

import java.util.Scanner;

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
            //parkingLotController.printParkingLot(0);
//            TicketRequestDto ticketRequestDto = new TicketRequestDto(VehicleType.FOUR_WHEELER,
//                    "AP001", "Sai",0,0);
//
//            TicketReponseDto ticketResposeDto = ticketController.issueTicket(ticketRequestDto);
//
//            if(ticketResposeDto.getResponseStatus().equals(ResponseStatus.FAILURE)){
//                System.out.println("Ticket is not issued");
//            }else{
//                System.out.println("-----------------------------------------------------------------------------");
//                Ticket ticket = ticketResposeDto.getTicket();
//                System.out.println("Slot Number: +"+ticket.getParkingSlot().getParkingSlotNumber());
//                System.out.println("VehicleNumber: "+ticket.getVehicle().getVehicleNumber());
//                System.out.println("EntryTime: "+ticket.getEntryTime());
//                System.out.println("Operator: "+ticket.getOperator().getName());
//                System.out.println("Entry gate: "+ticket.getEntryDate().getId());
//                System.out.println("-----------------------------------------------------------------------------");
//            }
            //parkingLotController.printParkingLot(0);

            Scanner scanner = new Scanner(System.in);

            while(true){
                parkingLotController.printParkingLot(0);
                System.out.println("Enter vehicle number: ");
                String vehicleNumber = scanner.nextLine();
                System.out.println("Enter '2' for Two wheeler '4' for four wheeler");
                int vType = Integer.parseInt(scanner.nextLine());
                VehicleType vehicleType;
                if(vType == 2){
                    vehicleType = VehicleType.TWO_WHEELER;
                }else{
                    vehicleType = VehicleType.FOUR_WHEELER;
                }
                System.out.println("Enter owner name: ");
                String owner = scanner.nextLine();

                TicketRequestDto ticketRequestDto1 = new TicketRequestDto(vehicleType,
                        vehicleNumber, owner,0,0);

                TicketReponseDto ticketResposeDto1 = ticketController.issueTicket(ticketRequestDto1);

                if(ticketResposeDto1.getResponseStatus().equals(ResponseStatus.FAILURE)){
                    System.out.println("Ticket is not issued");
                }else{
                    System.out.println("-----------------------------------------------------------------------------");
                    Ticket ticket = ticketResposeDto1.getTicket();
                    System.out.println("Slot Number: +"+ticket.getParkingSlot().getParkingSlotNumber());
                    System.out.println("VehicleNumber: "+ticket.getVehicle().getVehicleNumber());
                    System.out.println("EntryTime: "+ticket.getEntryTime());
                    System.out.println("Operator: "+ticket.getOperator().getName());
                    System.out.println("Entry gate: "+ticket.getEntryDate().getId());
                    System.out.println("-----------------------------------------------------------------------------");
                }

                System.out.println("Press any key to issue new ticket");
                String str = scanner.nextLine();

            }

        }catch (Exception e){
            e.printStackTrace();
        }








    }
}
