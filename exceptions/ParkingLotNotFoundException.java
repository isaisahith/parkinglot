package exceptions;

public class ParkingLotNotFoundException extends Exception {
    public ParkingLotNotFoundException() {
        super("Parking lot not found");
    }
}