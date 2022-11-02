import java.util.ArrayList;
import java.util.List;

import automata.Automata;
import automata.Token;
public class Scanner {
    Automata scannerDFA;

    public Scanner(){
        scannerDFA = new ScannerDFABuilder().buildAutomata();
    }

    List<Token> scan(String input){
        List<Token> result = new ArrayList<>();
        InputManager iManager = new InputManager(input);
        try {
            while(!iManager.getCur().isEmpty()){
                Token temp = scannerDFA.getToken(iManager.getCur());
  
                if(temp==Token.NULL)    throw new Exception();
                if(temp.gettNum()!=Token.WHITE_NUM) result.add(temp);
                
                iManager.cutString(temp);
            }
        } catch (Exception e) {
            System.out.println("scan error");
        }
        
        return result;
    }
}