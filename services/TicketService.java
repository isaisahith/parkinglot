package services;

import dto.TicketRequestDto;
import models.*;
import models.constants.ParkingSpotStatus;
import repositories.ParkingSlotRepository;
import repositories.TicketRepository;

import java.util.Date;

public class TicketService {
    private TicketRepository ticketRepository;
    private ParkingSlotService parkingSlotService;

    public TicketService(TicketRepository ticketRepository,ParkingSlotService parkingSlotService) {
        this.ticketRepository = ticketRepository;
        this.parkingSlotService = parkingSlotService;
    }
    public Ticket issueTicket(Gate gate, Operator operator, Vehicle vehicle) {
        Ticket ticket1 = new Ticket();
        ticket1.setEntryTime(new Date());
        ticket1.setOperator(operator);
        ticket1.setEntryDate(gate);
        ticket1.setVehicle(vehicle);

        ParkingSlot parkingSlot = parkingSlotService.assignSlot(vehicle);
        parkingSlot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        ticket1.setParkingSlot(parkingSlot);
        return ticketRepository.save(ticket1);




    }
}
