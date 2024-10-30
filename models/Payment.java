package models;
import models.*;
import models.constants.*;

import java.util.Date;


public class Payment {
    private int id;
    private Ticket ticket;
    private Date date;
    private int amount;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;
    private Gate exitGate;
    private Operator operator;


    public int getId() {
        return id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Date getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Operator getOperator() {
        return operator;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }
}
