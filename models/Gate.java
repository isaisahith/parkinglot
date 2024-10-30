package models;
import models.constants.*;
public class Gate {
    private int id;
    private GateType gateType;
    private Operator operator;


    public int getId() {
        return id;
    }

    public GateType getGateType() {
        return gateType;
    }

    public Operator getOperator() {
        return operator;
    }
}