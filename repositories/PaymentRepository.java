package repositories;
import java.util.*;
import exceptions.*;
import models.Payment;
import models.Ticket;

public class PaymentRepository {
    private Map<Integer, Payment> paymentMap;

    private static int id;

    public PaymentRepository() {
        this.paymentMap = new HashMap<>();
        this.id = 0;
    }

    public Payment getPayment(int id) throws PaymentNotFoundException {
        if(paymentMap.containsKey(id)){
            return paymentMap.get(id);
        }else{
            throw new PaymentNotFoundException();
        }
    }

    public Payment save(Payment payment){
        paymentMap.put(id, payment);
        payment.setId(id);
        id++;
        return payment;
    }

    public Payment update(int id, Payment payment) throws PaymentNotFoundException {
        if(paymentMap.containsKey(id)){
            paymentMap.put(id, payment);
            return payment;
        }else{
            throw new PaymentNotFoundException();
        }
    }

    public void delete(int id) throws PaymentNotFoundException {
        if(paymentMap.containsKey(id)){
            paymentMap.remove(id);
        }else{
            throw new PaymentNotFoundException();
        }
    }
}