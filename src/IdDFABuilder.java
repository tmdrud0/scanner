import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import automata.Automata;
import automata.AutomataBuilder;
import automata.DFA;
import automata.IdTokenManager;
import automata.Identifier;
import automata.IdentifierGenerator;
import automata.StateImpl;
import automata.State;

public class IdDFABuilder implements AutomataBuilder{
    List<Character> upperAndunderbar,alphaAndNum;

    public IdDFABuilder(){
        List<Character> lower = Stream.iterate('a', (c)->(char)(c+1)).limit(26).collect(Collectors.toList());
        List<Character> upper = Stream.iterate('A', (c)->(char)(c+1)).limit(26).collect(Collectors.toList());
        List<Character> number = Stream.iterate('0', (c)->(char)(c+1)).limit(10).collect(Collectors.toList());
        List<Character> underBar = Stream.of('_').collect(Collectors.toList());

        alphaAndNum = Stream.of(lower,upper,number)
                        .flatMap(List::stream)
                        .collect(Collectors.toList());
        upperAndunderbar = Stream.of(upper,underBar)
                            .flatMap(List::stream)
                            .collect(Collectors.toList());
    }

    @Override
    public Automata buildAutomata() {
        DFA resultDFA = new DFA(new IdTokenManager(3));
        IdentifierGenerator ig = new IdentifierGenerator();

        State start = new StateImpl();
        State afterUnderUpper = new StateImpl();

        Identifier isUpperOrUpper = ig.makeHasIdentifier(upperAndunderbar);
        Identifier isAlphaOrNum = ig.makeHasIdentifier(alphaAndNum);
        Identifier isNotAlphaOrNum = ig.makeNotHasIdentifier(alphaAndNum);

        resultDFA.setStartState(start);
        start.addTransition(isUpperOrUpper, afterUnderUpper);
        afterUnderUpper.addTransition(isAlphaOrNum, afterUnderUpper);
        afterUnderUpper.addTransition(isNotAlphaOrNum, State.OK);
        
        return resultDFA;
    }

}