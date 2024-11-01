package controllers;

import models.Bill;
import models.Ticket;
import services.BillService;

public class BillController {
    private BillService billService;
    public BillController(BillService billService) {
        this.billService = billService;
    }

    public Bill getBill(Ticket ticket){
        return billService.generateBill(ticket);
    }
}
