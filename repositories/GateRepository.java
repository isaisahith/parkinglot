package repositories;
import java.util.*;
import exceptions.*;
import models.*;
public class GateRepository {
    private Map<Integer, Gate> gateMap;

    private static int id;

    public GateRepository() {
        this.gateMap = new HashMap<>();
        this.id = 0;
    }

    public Gate getGate(int id) throws GateNotFoundException {
        if(gateMap.containsKey(id)){
            return gateMap.get(id);
        }else{
            throw new GateNotFoundException();
        }
    }

    public Gate save(Gate gate){
        gateMap.put(id, gate);
        id++;
        return gate;
    }

    public Gate update(int id, Gate gate) throws GateNotFoundException {
        if(gateMap.containsKey(id)){
            gateMap.put(id, gate);
            return gate;
        }else{
            throw new GateNotFoundException();
        }
    }

    public void delete(int id) throws GateNotFoundException {
        if(gateMap.containsKey(id)){
            gateMap.remove(id);
        }else{
            throw new GateNotFoundException();
        }
    }
}