package services;

import BillCalculatingStrategies.BillCalculatingStrategy;
import models.Bill;
import models.Ticket;
import repositories.BillRepository;

import java.util.Date;

public class BillService {
    private BillRepository billRepository;
    private BillCalculatingStrategy billCalculatingStrategy;

    public BillService(BillRepository billRepository, BillCalculatingStrategy billCalculatingStrategy) {
        this.billRepository = billRepository;
        this.billCalculatingStrategy = billCalculatingStrategy;
    }

    public Bill generateBill(Ticket ticket){
        Bill bill = new Bill();
        bill.setTicket(ticket);
        bill.setExitDate(new Date());
        bill.setParkingSlot(ticket.getParkingSlot());
        bill.setVehicle(ticket.getVehicle());
        int billAmount = billCalculatingStrategy.getBillAmount(bill);
        bill.setAmount(billAmount);
        bill.setAmountTobepaid(billAmount);
        return bill;
    }
}
