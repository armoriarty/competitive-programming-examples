import java.io.*;
import java.util.*;

public class prob4 {

    private static Scanner in;
    private static PrintWriter out;

    public static void main (String[] args) throws Exception {
        in = new Scanner (new File ("prob4.in"));
        out = new PrintWriter ("prob4.out");
        int count = 1;
        String inputString = in.nextLine();
        while(!inputString.equals("")){
            String bracketString = compress(inputString);
            try{
                lint(bracketString, ' ');
                out.printf("case %d: YES\n", count);
            } catch (Exception e){
                out.printf("case %d: NO\n", count);
            } finally {
                count++;
            }
            inputString = in.nextLine();
        }
        in.close ();
        out.close ();
    }

    public static String compress(String aString){
        String result = "";
        for(int i = 0; i < aString.length(); i++){
            // This is a really clever "set contains" operation being 
            // disguised as an index lookup in a string
            if("()[]{}".indexOf(aString.charAt(i)) >= 0){
                result += aString.charAt(i);
            }
        }
        return result;
    }

    public static String lint(String aBracketString, char aChar) throws Exception {
        if(aChar == ' '){
            if(aBracketString.equals("")){
                return "";
            }
            if("]})".indexOf(aBracketString.charAt(0)) >= 0){
                throw new Exception();
            }
            aBracketString = lint(aBracketString.substring(1), aBracketString.charAt(0));
            return lint(aBracketString, aChar);
        }
        if(aBracketString.equals("")){
            throw new Exception();
        }
        if( aChar == '(' && "]}".indexOf(aBracketString.charAt(0)) >= 0 ||
            aChar == '[' && ")}".indexOf(aBracketString.charAt(0)) >= 0 ||
            aChar == '{' && "])".indexOf(aBracketString.charAt(0)) >= 0 ){
            throw new Exception();
        }
        if("([{".indexOf(aBracketString.charAt(0)) >= 0){
            aBracketString = lint(aBracketString.substring(1), aBracketString.charAt(0));
            return lint(aBracketString, aChar);
        }
        return aBracketString.substring(1);
    }
}
