package exceptions;

public class OperatorNotFoundException extends RuntimeException{
    public OperatorNotFoundException(){
        super("Operator not found");
    }
}
