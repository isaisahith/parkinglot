package models;


import java.util.Date;

public class Invoice {
    private int id;
    private Payment payment;
    private Ticket ticket;
    private Date exitTime;
    private double amount;

    public Ticket getTicket() {
        return ticket;
    }

    public int getId() {
        return id;
    }

    public Payment getPayment() {
        return payment;
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

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }
}