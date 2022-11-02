import java.util.ArrayList;
import javafx.util.Pair;

public class SymbolDFABuilder extends WordDFABuilder{
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
        ArrayList<Pair<String, Integer>> tokens= new ArrayList<>();

        tokens.add(new Pair<String,Integer>("==", 19));
        tokens.add(new Pair<String,Integer>("!=", 20));
        tokens.add(new Pair<String,Integer>("<", 21));
        tokens.add(new Pair<String,Integer>(">", 22));
        tokens.add(new Pair<String,Integer>("<=", 23));
        tokens.add(new Pair<String,Integer>(">=", 24));
        tokens.add(new Pair<String,Integer>("[", 30));
        tokens.add(new Pair<String,Integer>("]", 31));
        tokens.add(new Pair<String,Integer>("{", 32));
        tokens.add(new Pair<String,Integer>("}", 33));
        tokens.add(new Pair<String,Integer>("(", 34));
        tokens.add(new Pair<String,Integer>(")", 35));
        tokens.add(new Pair<String,Integer>(",", 36));
        tokens.add(new Pair<String,Integer>(";", 37));
        tokens.add(new Pair<String,Integer>("‘", 38));
        tokens.add(new Pair<String,Integer>("’", 39));
        tokens.add(new Pair<String,Integer>("+", 10));
        tokens.add(new Pair<String,Integer>("-", 11));
        tokens.add(new Pair<String,Integer>("*", 12));
        tokens.add(new Pair<String,Integer>("/", 13));
        tokens.add(new Pair<String,Integer>("%", 14));
        tokens.add(new Pair<String,Integer>("=", 15));
        tokens.add(new Pair<String,Integer>("!", 16));
        tokens.add(new Pair<String,Integer>("&&", 17));
        tokens.add(new Pair<String,Integer>("||", 18));

        return tokens;
    }
}