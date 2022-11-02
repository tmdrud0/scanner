import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

import automata.Automata;
import automata.AutomataBuilder;
import automata.AutomataSet;
import automata.NoIdTokenManager;
import automata.DFA;
import automata.Identifier;
import automata.IdentifierGenerator;
import automata.State;
import automata.StateImpl;

public class NumDFABuilder implements AutomataBuilder{
    List<Character> zero,number,noZeroNumber,xX,eE,plusMinus,dot,numDotE;
    IdentifierGenerator ig;
    public NumDFABuilder(){
        Stream<Character> num = Stream.iterate('0', (n)->(char)(n+1)).limit(10);
        Stream<Character> noZeroNum = Stream.iterate('1', (n)->(char)(n+1)).limit(9);
        
        number = num.collect(Collectors.toList());
        noZeroNumber = noZeroNum.collect(Collectors.toList());
        xX = new ArrayList<>(Arrays.asList('x','X'));
        eE = new ArrayList<>(Arrays.asList('e','E'));
        plusMinus = new ArrayList<>(Arrays.asList('-','+'));
        dot = new ArrayList<>(Arrays.asList('.'));
        zero = new ArrayList<>(Arrays.asList('0'));
        numDotE = Stream.of(number,dot,eE)
                    .flatMap(List::stream)
                    .collect(Collectors.toList());

        ig = new IdentifierGenerator();
    }

    @Override
    public Automata buildAutomata() {
        AutomataSet resultAutomata = new AutomataSet();
    
        resultAutomata.addAutomata(buildReal());
        resultAutomata.addAutomata(buildNetural());
        
        return resultAutomata;
    }

    private Automata buildNetural(){
        DFA neturalDFA = new DFA(new NoIdTokenManager(5));
        State start = new StateImpl();
        State afterZero = new StateImpl();
        State afterX = new StateImpl();
        State afterNoZero = new StateImpl();
        
        Identifier zeroIdentifier = ig.makeHasIdentifier(zero);
        Identifier noZeroNumIdentifier = ig.makeHasIdentifier(noZeroNumber);
        Identifier numIdentifier = ig.makeHasIdentifier(number);
        Identifier noNumbeIdentifier = ig.makeNotHasIdentifier(number);
        Identifier xIdentifier = ig.makeHasIdentifier(xX);

        neturalDFA.setStartState(start);
        start.addTransition(zeroIdentifier, afterZero);
        start.addTransition(noZeroNumIdentifier, afterNoZero);

        afterZero.addTransition(xIdentifier, afterX);
        afterZero.addTransition(noZeroNumIdentifier, afterNoZero);
        afterZero.addTransition(noNumbeIdentifier, State.OK);

        afterX.addTransition(noZeroNumIdentifier, afterNoZero);

        afterNoZero.addTransition(numIdentifier, afterNoZero);
        afterNoZero.addTransition(noNumbeIdentifier, State.OK);

        return neturalDFA;
    }

    private Automata buildReal(){
        DFA realDFA = new DFA(new NoIdTokenManager(6));
        State start = new StateImpl();
        State afterNum = new StateImpl();
        State afterDot = new StateImpl();
        State afterDotNum = new StateImpl();
        State afterE = new StateImpl();
        State afterPM = new StateImpl();
        State afterENum = new StateImpl();

        Identifier numIdentifier = ig.makeHasIdentifier(number);
        Identifier dotIdentifier = ig.makeHasIdentifier(dot);
        Identifier eIdentifier = ig.makeHasIdentifier(eE);
        Identifier pmIdentifier = ig.makeHasIdentifier(plusMinus);
        Identifier notNumDotEIdentifier = ig.makeNotHasIdentifier(numDotE);

        realDFA.setStartState(start);
        start.addTransition(numIdentifier, afterNum);

        afterNum.addTransition(numIdentifier, afterNum);
        afterNum.addTransition(dotIdentifier, afterDot);
        afterNum.addTransition(eIdentifier, afterE);
        afterNum.addTransition(notNumDotEIdentifier, State.OK);

        afterDot.addTransition(numIdentifier, afterDotNum);

        afterDotNum.addTransition(numIdentifier, afterDotNum);
        afterDotNum.addTransition(eIdentifier, afterE);
        afterDotNum.addTransition(notNumDotEIdentifier, State.OK);
        
        afterE.addTransition(pmIdentifier, afterPM);
        afterE.addTransition(numIdentifier, afterENum);

        afterPM.addTransition(numIdentifier, afterENum);

        afterENum.addTransition(numIdentifier, afterENum);
        afterENum.addTransition(notNumDotEIdentifier, State.OK);
        
        return realDFA;
    }
}