import java.util.ArrayList;
import javafx.util.Pair;

public class ReservedDFABuilder extends WordDFABuilder{
    @Override
    public WordDFAGenarator getGenarator() {
        return new ReservedDFAGenarator();
    }
    @Override
    public ArrayList<Pair<String, Integer>> getTokens() {
        ArrayList<Pair<String,Integer>> tokens = new ArrayList<>();
        
        tokens.add(new Pair<String,Integer>("if", 40));
        tokens.add(new Pair<String,Integer>("while", 41));
        tokens.add(new Pair<String,Integer>("for", 42));
        tokens.add(new Pair<String,Integer>("const", 43));
        tokens.add(new Pair<String,Integer>("int", 44));
        tokens.add(new Pair<String,Integer>("float", 45));
        tokens.add(new Pair<String,Integer>("else", 46));
        tokens.add(new Pair<String,Integer>("return", 47));
        tokens.add(new Pair<String,Integer>("void", 48));
        tokens.add(new Pair<String,Integer>("break", 49));
        tokens.add(new Pair<String,Integer>("continue", 50));
        tokens.add(new Pair<String,Integer>("char", 51));
        
        return tokens;
    }
}