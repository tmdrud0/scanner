package automata;

public class DFA implements Automata{
    State startState;
    TokenManager tManager;

    public DFA(TokenManager tokenManager){
        tManager = tokenManager;
    }
    public void setStartState(State start){
        startState = start;
    }
    public Token getToken(String inputString){
        State curState = startState;
        String curString = "", tempString = inputString;
        
        while(true){
            char inputChar=' ';
            if(!tempString.isEmpty())    inputChar = tempString.charAt(0);

            curState = curState.getNextState(inputChar);
            if(curState == State.OK||curState == State.NULL)    break;
            
            tempString = tempString.substring(1);
            curString = curString + inputChar; 
        }
        return tManager.getToken(curState, curString);
    }
}