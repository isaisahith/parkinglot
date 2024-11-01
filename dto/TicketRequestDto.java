package dto;

import models.Gate;
import models.Operator;
import models.constants.VehicleType;

public class TicketRequestDto {
    private VehicleType vehicleType;
    private String vehcileNuber;
    private String ownername;
    private int gateid;
    private int operatorId;


    public TicketRequestDto(VehicleType vehicleType, String vehcileNuber, String ownername, int gateid, int operatorId) {
        this.vehicleType = vehicleType;
        this.vehcileNuber = vehcileNuber;
        this.ownername = ownername;
        this.gateid = gateid;
        this.operatorId = operatorId;

    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }


    public int getGateid() {
        return gateid;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public String getOwnername() {
        return ownername;
    }

    public String getVehcileNuber() {
        return vehcileNuber;
    }


}
