package exceptions;

public class NoAvailableSlotsException extends RuntimeException {
    public NoAvailableSlotsException() {
        super("No slots available");
    }
}
