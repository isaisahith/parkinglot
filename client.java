import BillCalculatingStrategies.BillCalculatingStrategy;
import BillCalculatingStrategies.RegularStrategy;
import controllers.BillController;
import controllers.ParkingLotController;
import controllers.TicketController;
import dto.TicketReponseDto;
import dto.TicketRequestDto;
import models.*;
import models.constants.GateType;
import models.constants.ParkingSpotStatus;
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
        BillCalculatingStrategy billCalculatingStrategy = new RegularStrategy();
        BillRepository billRepository = new BillRepository();
        BillService billService = new BillService(billRepository, billCalculatingStrategy);
        BillController billController = new BillController(billService);

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
                System.out.print("Enter 1 to issue ticket and 2 to generate the bill :");
                int instruction = scanner.nextInt();
                if(instruction == 1){
                    parkingLotController.printParkingLot(0);
                    System.out.println("Enter vehicle number: ");
                    Scanner sc = new Scanner(System.in);
                    String vehicleNumber = sc.nextLine();
                    System.out.println("Enter '2' for Two wheeler '4' for four wheeler");
                    int vType = Integer.parseInt(sc.nextLine());
                    VehicleType vehicleType;
                    if(vType == 2){
                        vehicleType = VehicleType.TWO_WHEELER;
                    }else{
                        vehicleType = VehicleType.FOUR_WHEELER;
                    }
                    Scanner sc1 = new Scanner(System.in);

                    System.out.println("Enter owner name: ");
                    String owner = sc1.nextLine();

                    TicketRequestDto ticketRequestDto1 = new TicketRequestDto(vehicleType,
                            vehicleNumber, owner,0,0);

                    TicketReponseDto ticketResposeDto1 = ticketController.issueTicket(ticketRequestDto1);

                    if(ticketResposeDto1.getResponseStatus().equals(ResponseStatus.FAILURE)){
                        System.out.println("Ticket is not issued");
                    }else{
                        System.out.println("-----------------------------------------------------------------------------");
                        Ticket ticket = ticketResposeDto1.getTicket();
                        System.out.println("Ticket Id: "+ticket.getId());
                        System.out.println("Slot Number: +"+ticket.getParkingSlot().getParkingSlotNumber());
                        System.out.println("VehicleNumber: "+ticket.getVehicle().getVehicleNumber());
                        System.out.println("EntryTime: "+ticket.getEntryTime());
                        System.out.println("Operator: "+ticket.getOperator().getName());
                        System.out.println("Entry gate: "+ticket.getEntryDate().getId());
                        System.out.println("Floor number: "+ticket.getParkingSlot().getParkingFloorNumber().getFloorNumber());
                        System.out.println("-----------------------------------------------------------------------------");
                    }

//                    System.out.println("Press any key to issue new ticket");
//                    String str = scanner.nextLine();

                }else{
                    System.out.println("Enter the ticket Id to generate the bill: ");
                    int ticketNumber = scanner.nextInt();

                    Ticket ticket = ticketRepository.getTicket(ticketNumber);
                    Bill bill = billController.getBill(ticket);
                    System.out.println("Ticket Id: "+ticket.getId());
                    System.out.println("Slot Number: +"+ticket.getParkingSlot().getParkingSlotNumber());
                    System.out.println("VehicleNumber: "+ticket.getVehicle().getVehicleNumber());
                    System.out.println("EntryTime: "+ticket.getEntryTime());
                    System.out.println("ExitTime: "+bill.getExitDate());
                    System.out.println("Amount: "+bill.getAmount());
                    System.out.println("Press any key once the payment is done");
                    Scanner sc = new Scanner(System.in);
                    String s = sc.nextLine();
                    ticket.getParkingSlot().setParkingSpotStatus(ParkingSpotStatus.EMPTY);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }








    }
}
