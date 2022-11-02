import java.util.ArrayList;

import automata.Automata;
import automata.AutomataBuilder;
import automata.AutomataSet;
import javafx.util.Pair;

public abstract class WordDFABuilder implements AutomataBuilder{

    ArrayList<Pair<String,Integer>> tokens;
    WordDFAGenarator genarator;
    public WordDFABuilder(){
        genarator = getGenarator();
        tokens = getTokens();

    }
    abstract WordDFAGenarator getGenarator();
    abstract ArrayList<Pair<String,Integer>> getTokens();
    @Override
    public Automata buildAutomata() {
        AutomataSet resultAutomata = new AutomataSet();
        tokens.stream()
        .map((item)->genarator.buildAutomata(item.getKey(), item.getValue()))
        .forEach((automata)->resultAutomata.addAutomata(automata));
        
        return resultAutomata;
    }
    
}