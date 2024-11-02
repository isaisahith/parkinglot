package dto;

import models.Bill;
import models.constants.ResponseStatus;

public class BillResponseDto {
    private Bill bill;
    private ResponseStatus status;

    public Bill getBill() {
        return bill;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
