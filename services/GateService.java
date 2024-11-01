package services;

import models.Gate;
import models.Operator;
import models.constants.GateType;
import repositories.GateRepository;

import java.util.List;

public class GateService {
    private GateRepository gateRepository;
    public GateService(GateRepository gateRepository){
        this.gateRepository = gateRepository;
    }

    public Gate addgate(GateType gateType, Operator operator){
        Gate gate = new Gate(gateType, operator);
        gateRepository.save(gate);
        return gate;
    }

    public Gate getGate(int id){
        return gateRepository.getGate(id);
    }


}
