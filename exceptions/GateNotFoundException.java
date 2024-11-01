package exceptions;

public class GateNotFoundException extends RuntimeException{
    public GateNotFoundException(){
        super("Gate Not Found");
    }
}
