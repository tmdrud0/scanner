package automata;

import java.util.ArrayList;
import java.util.List;

public class AutomataSet implements Automata{
    List<Automata> automatas;
    public AutomataSet(){
        automatas = new ArrayList<>();
    }
    @Override
    public Token getToken(String inputString) {
        for(Automata automata : automatas){
            Token tempToken = automata.getToken(inputString);
            if(tempToken!=Token.NULL)  return tempToken;
        }
        return Token.NULL;
    }
    public void addAutomata(Automata automata){
        automatas.add(automata);

    }
}