import java.util.ArrayList;

import automata.Automata;
import automata.AutomataBuilder;
import automata.AutomataSet;

public class ScannerDFABuilder implements AutomataBuilder{
    ArrayList<AutomataBuilder> builders;
    public ScannerDFABuilder() {
        builders = new ArrayList<>();
        builders.add(new RemarkDFABuilder());
        builders.add(new StringDFABuilder());
        builders.add(new NumDFABuilder());
        builders.add(new SymbolDFABuilder());
        builders.add(new ReservedDFABuilder());
        builders.add(new IdDFABuilder());
        builders.add(new WhiteDFABuilder());
    }

    @Override
    public Automata buildAutomata() {
        AutomataSet resultAutomata = new AutomataSet();
        builders.forEach((builder)->resultAutomata.addAutomata(builder.buildAutomata()));
        return resultAutomata;
    }
}