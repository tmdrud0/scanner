package automata;

public interface State {
    State getNextState(char input);
    void addTransition(Identifier identifier, State goalState);

    public static final State NULL = new State() {
        @Override
        public State getNextState(char input) {
            return NULL;
        }
        @Override
        public void addTransition(Identifier identifier, State goalState) {            
        }
    };
    public static final State OK = new State() {
        @Override
        public State getNextState(char input) {
            return OK;
        }
        @Override
        public void addTransition(Identifier identifier, State goalState) {           
        }
    };
}