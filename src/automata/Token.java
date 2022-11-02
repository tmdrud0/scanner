package automata;

public class Token {
    public static final Token NULL = new Token(-1,0,"");
    public static final int WHITE_NUM = -2;
    private int tNum,tId;
    private String tString;
    public Token(int num, int id, String string){
        tNum = num;
        tId = id;
        tString = string;
    }
    public int gettNum() {
        return tNum;
    }
    public int gettId() {
        return tId;
    }
    public String gettString() {
        return tString;
    }
    @Override
    public String toString(){
        String result = tString + "   tNUm : " + tNum + "   tId : " + tId;
        return result;
    }
}