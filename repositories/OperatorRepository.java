package repositories;
import java.util.*;
import exceptions.*;
import models.*;
public class OperatorRepository {
    private Map<Integer, Operator> operatorMap;

    private static int id;

    public OperatorRepository() {
        this.operatorMap = new HashMap<>();
        this.id = 0;
    }

    public Operator getOperator(int id) throws OperatorNotFoundException {
        if(operatorMap.containsKey(id)){
            return operatorMap.get(id);
        }else{
            throw new OperatorNotFoundException();
        }
    }

    public Operator save(Operator operator){
        operatorMap.put(id, operator);
        id++;
        return operator;
    }

    public Operator update(int id, Operator operator) throws OperatorNotFoundException {
        if(operatorMap.containsKey(id)){
            operatorMap.put(id, operator);
            return operator;
        }else{
            throw new OperatorNotFoundException();
        }
    }

    public void delete(int id) throws GateNotFoundException {
        if(operatorMap.containsKey(id)){
            operatorMap.remove(id);
        }else{
            throw new OperatorNotFoundException();
        }
    }
}