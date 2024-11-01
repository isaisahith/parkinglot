package models;
import models.constants.*;
public class Gate {
    private int id;
    private GateType gateType;
    private Operator operator;

    public Gate(GateType gateType, Operator operator) {
        this.gateType = gateType;
        this.operator = operator;
    }


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