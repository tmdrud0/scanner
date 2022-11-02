import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import automata.Automata;
import automata.AutomataBuilder;
import automata.IdentifierGenerator;
import automata.NoIdTokenManager;
import automata.State;
import automata.StateImpl;
import automata.DFA;
import automata.Identifier;

public class RemarkDFABuilder implements AutomataBuilder{
    List<Character> slash,questionMark,nothing;
    IdentifierGenerator ig;
    public RemarkDFABuilder(){
        slash = new ArrayList<>(Arrays.asList('/'));
        questionMark = new ArrayList<>(Arrays.asList('?'));
        nothing = new ArrayList<>();

        ig = new IdentifierGenerator();
    }

    @Override
    public Automata buildAutomata() {
        DFA remarkDFA = new DFA(new NoIdTokenManager(7));
        State start = new StateImpl();
        State openSlash = new StateImpl();
        State openQuestion = new StateImpl();
        State closeQuestion = new StateImpl();
        State closeSlash = new StateImpl();

        Identifier slashIdentifier = ig.makeHasIdentifier(slash);
        Identifier questionIdentifier = ig.makeHasIdentifier(questionMark);
        Identifier notQuestionIdentifier = ig.makeNotHasIdentifier(questionMark);
        Identifier allIdentifier = ig.makeNotHasIdentifier(nothing);

        remarkDFA.setStartState(start);
        start.addTransition(slashIdentifier, openSlash);

        openSlash.addTransition(questionIdentifier, openQuestion);

        openQuestion.addTransition(notQuestionIdentifier, openQuestion);
        openQuestion.addTransition(questionIdentifier, closeQuestion);

        closeQuestion.addTransition(slashIdentifier, closeSlash);

        closeSlash.addTransition(allIdentifier, State.OK);
        
        return remarkDFA;
    }
}