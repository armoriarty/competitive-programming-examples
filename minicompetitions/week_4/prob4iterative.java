import java.io.*;
import java.util.*;

public class prob4iterative {

    private static Scanner in;
    private static PrintWriter out;

    public static void main (String[] args) throws Exception {
        in = new Scanner (new File ("prob4.in"));
        out = new PrintWriter ("prob4.out");
        int count = 1;
        String inputString = in.nextLine();
        while(!inputString.equals("")){
            String bracketString = compress(inputString);
            if(lint(bracketString)){
                out.printf("case %d: YES\n", count);
            } else {
                out.printf("case %d: NO\n", count);
            }
            count++;
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

    public static boolean lint(String aBracketString) throws Exception {
        for(int i = 0; i < aBracketString.length(); i++){
            char c = aBracketString.charAt(i);
            if(")]}".indexOf(c) >= 0){
                if(i == 0){
                    return false;
                }
                if(c == ')' && aBracketString.charAt(i - 1) != '('){
                    return false;
                }
                if(c == ']' && aBracketString.charAt(i - 1) != '['){
                    return false;
                }
                if(c == '}' && aBracketString.charAt(i - 1) != '{'){
                    return false;
                }
                aBracketString =  aBracketString.substring(0, i - 1) + aBracketString.substring( i + 1);
                i -= 2;
            }
        }
        return aBracketString.equals("");
    }
}
