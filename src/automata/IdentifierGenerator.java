package automata;

import java.util.List;

public class IdentifierGenerator {
    public Identifier makeHasIdentifier(List<Character> cList){
        return new SetIdentifier(cList, SetIdentifier.HAS);
    }
    public Identifier makeNotHasIdentifier(List<Character> cList){
        return new SetIdentifier(cList, SetIdentifier.DOES_NOT_HAVE);
    }
}