import automata.Token;

public class InputManager {
    String input;
    public InputManager(String input){
        this.input = input;
    }

    public String getCur(){
        return input;
    }

    public void cutString(Token token) throws Exception{
        if(!input.startsWith(token.gettString())){
            System.out.println("input manager error");
            System.out.println("input : " + input);
            System.out.println("token : " + token.gettString());
            throw new Exception();
        }
        input = input.substring(token.gettString().length());
    }
}