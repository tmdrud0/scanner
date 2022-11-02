package automata;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class StateImpl implements State{

    List<Pair<Identifier,State>> transitions;
    public StateImpl (){
        transitions = new ArrayList<>();
    }

    @Override
    public State getNextState(char input) {
        for(Pair<Identifier,State> pair : transitions)
            if(pair.getKey().isRight(input)) return pair.getValue();
        return State.NULL;
    }

    @Override
    public void addTransition(Identifier identifier, State goalState) {
        transitions.add(new Pair<>(identifier,goalState));
    }
}