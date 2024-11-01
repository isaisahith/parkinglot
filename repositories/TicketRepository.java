package repositories;
import java.util.*;
import exceptions.*;
import models.Ticket;

public class TicketRepository {
    private Map<Integer, Ticket> ticketMap;

    private static int id;

    public TicketRepository() {
        this.ticketMap = new HashMap<>();
        this.id = 0;
    }

    public Ticket getTicket(int id) throws TicketNotFoundException {
        if(ticketMap.containsKey(id)){
            return ticketMap.get(id);
        }else{
            throw new TicketNotFoundException();
        }
    }

    public Ticket save(Ticket ticket){
        ticketMap.put(id, ticket);
        ticket.setId(id);
        id++;
        return ticket;
    }

    public Ticket update(int id, Ticket ticket) throws TicketNotFoundException {
        if(ticketMap.containsKey(id)){
            ticketMap.put(id, ticket);
            return ticket;
        }else{
            throw new TicketNotFoundException();
        }
    }

    public void delete(int id) throws TicketNotFoundException {
        if(ticketMap.containsKey(id)){
            ticketMap.remove(id);
        }else{
            throw new TicketNotFoundException();
        }
    }
}