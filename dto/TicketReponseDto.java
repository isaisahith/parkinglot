package dto;

import models.Ticket;
import models.constants.ResponseStatus;

public class TicketReponseDto {
    private Ticket ticket;
    private ResponseStatus responseStatus;

    public Ticket getTicket() {
        return ticket;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
