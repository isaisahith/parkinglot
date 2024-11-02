package controllers;

import dto.BillRequestDto;
import dto.BillResponseDto;
import models.Bill;
import models.Ticket;
import models.constants.ResponseStatus;
import repositories.TicketRepository;
import services.BillService;

public class BillController {
    private BillService billService;
    private TicketRepository ticketRepository;
    public BillController(BillService billService, TicketRepository ticketRepository) {
        this.billService = billService;
        this.ticketRepository = ticketRepository;
    }


    public BillResponseDto getBill(BillRequestDto billRequestDto){
        Ticket ticket = ticketRepository.getTicket(billRequestDto.getTicketId());
        Bill bill;
        BillResponseDto billResponseDto = new BillResponseDto();
        if(ticket.getBill()!=null){
            bill= ticket.getBill();
            billResponseDto.setBill(bill);
            billResponseDto.setStatus(ResponseStatus.SUCCESS);
            return billResponseDto;
        }


        try{
            bill = billService.generateBill(ticket);
            billResponseDto.setBill(bill);
            billResponseDto.setStatus(ResponseStatus.SUCCESS);
            ticket.setBill(bill);
        }catch (Exception e){
            billResponseDto.setStatus(ResponseStatus.FAILURE);
        }
        return billResponseDto;
    }
}
