import BillCalculatingStrategies.BillCalculatingStrategy;
import BillCalculatingStrategies.RegularStrategy;
import controllers.BillController;
import controllers.ParkingLotController;
import controllers.TicketController;
import dto.BillRequestDto;
import dto.BillResponseDto;
import dto.TicketReponseDto;
import dto.TicketRequestDto;
import models.*;
import models.constants.*;
import repositories.*;
import services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();
        OperatorRepository operatorRepository = new OperatorRepository();
        PaymentRepository paymentRepository = new PaymentRepository();
        InvoiceRepository invoiceRepository = new InvoiceRepository();



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
        BillController billController = new BillController(billService, ticketRepository);

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

                    BillRequestDto billRequestDto = new BillRequestDto();
                    billRequestDto.setTicketId(ticketNumber);
                    BillResponseDto billResponseDto = billController.getBill(billRequestDto);
                    if(billResponseDto.getStatus().equals(ResponseStatus.SUCCESS)){
                        Bill bill = billResponseDto.getBill();
                        if(bill.getAmountTobepaid()==0){
                            System.out.println("Total amount is already paid!!");
                            continue;
                        }
                        Ticket ticket = bill.getTicket();
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.println("Ticket Id: "+ticket.getId());
                        System.out.println("Slot Number: +"+ticket.getParkingSlot().getParkingSlotNumber());
                        System.out.println("VehicleNumber: "+ticket.getVehicle().getVehicleNumber());
                        System.out.println("EntryTime: "+ticket.getEntryTime());
                        System.out.println("ExitTime: "+bill.getExitDate());
                        System.out.println("Total bill amount: "+bill.getAmount());
                        System.out.println("Total amount to be paid: "+bill.getAmountTobepaid());
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.println("Enter number of payments: ");
                        Scanner sc = new Scanner(System.in);
                        int noOfPayments= sc.nextInt();
                        Invoice invoice;
                        List<Payment> paymentList;
                        if(bill.getInvoice()!=null){
                            invoice = bill.getInvoice();
                            paymentList = invoice.getPayments();
                        }else{
                            invoice = new Invoice();
                            paymentList = new ArrayList<>();
                        }
                        invoice.setAmount(bill.getAmount());
                        invoice.setExitTime(bill.getExitDate());
                        invoice.setTicket(bill.getTicket());

                        int amountToBePaid = 0;
                        for(int i=0;i<noOfPayments;i++){
                            System.out.println("Enter '0' for Cash and '1' for online and '2 for Coupon':");
                            Scanner s2 = new Scanner(System.in);
                            int option = s2.nextInt();
                            Payment payment = new Payment();
                            payment.setAmount(bill.getAmount());
                            payment.setDate(bill.getExitDate());

                            if(option == 0){
                                payment.setPaymentType(PaymentType.CASH);
                            }else if(option == 1){
                                payment.setPaymentType(PaymentType.ONLINE);
                            }else if(option == 2){
                                payment.setPaymentType(PaymentType.COUPON);
                            }else{
                                System.out.println("Invalid option, try again");
                                continue;
                            }

                            System.out.println("Enter the amount for this payment:");
                            int amt = s2.nextInt();
                            amountToBePaid+= amt;
                            payment.setAmount(amt);
                            payment.setId(paymentRepository.save(payment).getId());
                            paymentList.add(payment);
                            bill.setAmountTobepaid(bill.getAmountTobepaid()-amt);

                        }

                        if(bill.getAmountTobepaid()==0){
                            System.out.println("Total amount is paid, Invoice is generated");
                            ticket.getParkingSlot().setParkingSpotStatus(ParkingSpotStatus.EMPTY);
                            System.out.println("----------------------------------------------------");
                            System.out.println("Total amount paid: "+bill.getAmount());
                            System.out.println("Total number of payments: "+paymentList.size());
                            for(Payment payment : paymentList){
                                System.out.println("----");
                                System.out.println("Payment id: "+payment.getId());
                                System.out.println("Amount paid: "+payment.getAmount());
                                System.out.println("Payment mode: "+payment.getPaymentType());

                            }

                        }else{
                            System.out.println("Total amount is not paid");

                        }

                        invoice.setPayments(paymentList);
                        invoice.setId(invoiceRepository.save(invoice).getId());
                        bill.setInvoice(invoice);

                    }else{
                        System.out.println("Something went wrong");
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }








    }
}
