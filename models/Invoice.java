package models;


import java.util.Date;
import java.util.List;

public class Invoice {
    private int id;
    private List<Payment> payments;
    private Ticket ticket;
    private Date exitTime;
    private double amount;

    public Ticket getTicket() {
        return ticket;
    }

    public int getId() {
        return id;
    }



    public Date getExitTime() {
        return exitTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }



    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}