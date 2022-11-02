import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import automata.Automata;
import automata.DFA;
import automata.IdentifierGenerator;
import automata.NoIdTokenManager;
import automata.State;
import automata.StateImpl;

public abstract class WordDFAGenarator {

    private ArrayList<Character> notEndCharacter;
    public WordDFAGenarator(){
        notEndCharacter = getNotEndAlphabet();
    }

    abstract public ArrayList<Character> getNotEndAlphabet();
    
    public Automata buildAutomata(String goalString, int tokenNum) {
        DFA resultAutomata = new DFA(new NoIdTokenManager(tokenNum));
        List<State> states = new ArrayList<>(goalString.length()+1);
        for (int i = 0; i < goalString.length()+1; i++)  states.add(new StateImpl());
        IdentifierGenerator ig = new IdentifierGenerator();
        resultAutomata.setStartState(states.get(0));

        for(int i=1;i<states.size();i++){
            states.get(i-1)
            .addTransition(
                ig.makeHasIdentifier(
                    new ArrayList<Character>(Arrays.asList(goalString.charAt(i-1)))), states.get(i));
        }

        states.get(goalString.length())
        .addTransition(ig.makeNotHasIdentifier(notEndCharacter), State.OK);
        return resultAutomata;
    }
    
}