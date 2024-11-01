package BillCalculatingStrategies;

import models.Bill;

public interface BillCalculatingStrategy {
    int getBillAmount(Bill bill);
}
