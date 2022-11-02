package automata;

import java.util.HashMap;
import java.util.Map;

public class IdTokenManager extends TokenManager{
    Map<String,Integer> idMap;
    public IdTokenManager(int tNum){
        super(tNum);
        idMap = new HashMap<>();
    }
    @Override
    int getId(String input){
        if(!idMap.containsKey(input))   idMap.put(input, idMap.size());
        return idMap.get(input);
    }
}