package automata;

import java.util.ArrayList;
import java.util.List;

public class SetIdentifier implements Identifier{
    List<Character> elements;
    boolean doesNotHave;
    final static boolean DOES_NOT_HAVE = true, HAS = false;

    public SetIdentifier(List<Character> eList,boolean flag){
        elements = new ArrayList<Character>(eList);
        doesNotHave = flag;
    }
    @Override
    public boolean isRight(char input) {
        boolean find = false;
        for (Character element : elements) 
            if(element.equals(Character.valueOf(input))) find = true;
        return find ^ doesNotHave;
    }
}