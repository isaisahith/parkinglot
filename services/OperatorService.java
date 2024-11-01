package services;

import models.Gate;
import models.Operator;
import models.constants.GateType;
import repositories.GateRepository;
import repositories.OperatorRepository;

import java.util.List;

public class OperatorService {
    private OperatorRepository operatorRepository;
    public OperatorService(OperatorRepository operatorRepository){
        this.operatorRepository = operatorRepository;
    }

    public Operator addOperator(String name, String email){
        Operator newOperator = new Operator();
        newOperator.setName(name);
        newOperator.setEmail(email);
        operatorRepository.save(newOperator);
        return  newOperator;
    }

    public Operator getOperator(int id){
        return operatorRepository.getOperator(id);
    }


}
