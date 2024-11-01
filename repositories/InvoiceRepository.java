package repositories;
import java.util.*;
import exceptions.*;
import models.Invoice;
import models.Ticket;

public class InvoiceRepository {
    private Map<Integer, Invoice> invoiceMap;

    private static int id;

    public InvoiceRepository() {
        this.invoiceMap = new HashMap<>();
        this.id = 0;
    }

    public Invoice getInvoice(int id) throws InvoiceNotFoundException {
        if(invoiceMap.containsKey(id)){
            return invoiceMap.get(id);
        }else{
            throw new InvoiceNotFoundException();
        }
    }

    public Invoice save(Invoice invoice){
        invoiceMap.put(id, invoice);
        invoice.setId(id);
        id++;
        return invoice;
    }

    public Invoice update(int id, Invoice invoice) throws InvoiceNotFoundException {
        if(invoiceMap.containsKey(id)){
            invoiceMap.put(id, invoice);
            return invoice;
        }else{
            throw new InvoiceNotFoundException();
        }
    }

    public void delete(int id) throws InvoiceNotFoundException {
        if(invoiceMap.containsKey(id)){
            invoiceMap.remove(id);
        }else{
            throw new InvoiceNotFoundException();
        }
    }
}