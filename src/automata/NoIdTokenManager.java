package automata;

public class NoIdTokenManager extends TokenManager{
    public NoIdTokenManager(int tNum) {
        super(tNum);
    }
    @Override
    int getId(String input) {
        return 0;
    }
}