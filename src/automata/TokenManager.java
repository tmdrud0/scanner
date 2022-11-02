package automata;

public abstract class TokenManager {
    int tokenNum;
    public TokenManager(int tNum){
        tokenNum = tNum;
    }
    public Token getToken(State state, String input) {
        if(state==State.OK) return new Token(tokenNum,getId(input),input);
        else                return Token.NULL;
    }
    abstract int getId(String input);
}