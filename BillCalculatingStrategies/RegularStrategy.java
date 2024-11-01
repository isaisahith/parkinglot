package BillCalculatingStrategies;

import models.Bill;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RegularStrategy implements BillCalculatingStrategy{


    @Override
    public int getBillAmount(Bill bill) {
        Date entryTime = bill.getTicket().getEntryTime();
        Date exitTime = bill.getExitDate();
        long timeDifferenceInMillis = entryTime.getTime() - exitTime.getTime();
        long timeDifferenceInHours = TimeUnit.MILLISECONDS.toHours(timeDifferenceInMillis);
        return (int) (timeDifferenceInHours*10)+10;
    }
}
