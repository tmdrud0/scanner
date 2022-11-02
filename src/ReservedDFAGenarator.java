import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReservedDFAGenarator extends WordDFAGenarator{
    @Override
    public ArrayList<Character> getNotEndAlphabet() {
        Stream<Character> lowerAlpabet = Stream.iterate('a', (c)->(char)(c+1)).limit(26);
        Stream<Character> upperAlpabet = Stream.iterate('A', (c)->(char)(c+1)).limit(26);
        Stream<Character> number = Stream.iterate('0', (c)->(char)(c+1)).limit(10);
        Stream<Character> alphaNumber = Stream.concat(number, Stream.concat(lowerAlpabet, upperAlpabet));
        
        return new ArrayList<>(alphaNumber.collect(Collectors.toList()));
    }
    
}