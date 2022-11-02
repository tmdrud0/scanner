import java.util.ArrayList;

import automata.Token;
import javafx.util.Pair;

public class WhiteDFABuilder extends WordDFABuilder{

    @Override
    public WordDFAGenarator getGenarator() {
        return new WordDFAGenarator() {
            @Override
            public ArrayList<Character> getNotEndAlphabet() {
                return new ArrayList<>();
            }
        };
    }

    @Override
    public ArrayList<Pair<String, Integer>> getTokens() {
        ArrayList<Pair<String,Integer>> tokens = new ArrayList<>();
        
        tokens.add(new Pair<String,Integer>(" ", Token.WHITE_NUM));
        tokens.add(new Pair<String,Integer>("\n" , Token.WHITE_NUM));
        tokens.add(new Pair<String,Integer>("\r" , Token.WHITE_NUM));

        return tokens;
    }
}