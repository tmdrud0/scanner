import java.io.FileInputStream;

public class MyFileReader {
    final String fileName = "C:/Users/tmdru/java_code/test/input.txt";
    final int MAX_LENGTH = 1024;
    FileInputStream fis;      

    public MyFileReader() throws Exception{
        fis = new FileInputStream(fileName);
    }
    
    public String readInput() throws Exception{
        char[] input = new char[MAX_LENGTH];
        int readData;
        for(int i=0;i<MAX_LENGTH&&((readData=fis.read()) != -1);i++){
            input[i] = (char)readData;
        }
        String result = new String(input);
        result = result.substring(0,result.indexOf("\0"));
        return result;
    }
}