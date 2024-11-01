package repositories;
import java.util.*;
import exceptions.*;
import models.Bill;
import models.Ticket;

public class BillRepository {
    private Map<Integer, Bill> billMap;

    private static int id;

    public BillRepository() {
        this.billMap = new HashMap<>();
        this.id = 0;
    }

    public Bill getBill(int id) throws BillNotFoundException {
        if(billMap.containsKey(id)){
            return billMap.get(id);
        }else{
            throw new BillNotFoundException();
        }
    }

    public Bill save(Bill bill){
        billMap.put(id, bill);
        bill.setId(id);
        id++;
        return bill;
    }

    public Bill update(int id, Bill bill) throws BillNotFoundException {
        if(billMap.containsKey(id)){
            billMap.put(id, bill);
            return bill;
        }else{
            throw new BillNotFoundException();
        }
    }

    public void delete(int id) throws BillNotFoundException {
        if(billMap.containsKey(id)){
            billMap.remove(id);
        }else{
            throw new BillNotFoundException();
        }
    }
}