package controllers;

import dto.TicketReponseDto;
import dto.TicketRequestDto;
import models.Gate;
import models.Operator;
import models.Ticket;
import models.Vehicle;
import models.constants.ResponseStatus;
import repositories.GateRepository;
import repositories.OperatorRepository;
import services.TicketService;

public class TicketController {
    private TicketService ticketService;
    private OperatorRepository operatorRepository;
    private GateRepository gateRepository;

    public TicketController(TicketService ticketService, GateRepository gateRepository, OperatorRepository operatorRepository) {
        this.ticketService = ticketService;
        this.gateRepository = gateRepository;
        this.operatorRepository = operatorRepository;
    }

    public TicketReponseDto issueTicket(TicketRequestDto requestDto) {

        TicketReponseDto resposeDto = new TicketReponseDto();

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber(requestDto.getVehcileNuber());
        vehicle.setVehicleType(requestDto.getVehicleType());

        Gate gate = gateRepository.getGate(requestDto.getGateid());
        Operator operator = operatorRepository.getOperator(requestDto.getOperatorId());



        try{
            Ticket ticket = ticketService.issueTicket(gate, operator, vehicle);
            resposeDto.setTicket(ticket);
            resposeDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            resposeDto.setTicket(null);
            resposeDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return resposeDto;
    }
}
