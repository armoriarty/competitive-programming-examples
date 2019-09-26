import java.io.*;
import java.util.*;

public class Sexpr {

    private static Scanner in;
    private static PrintWriter out;

    public static void main (String[] args) throws Exception {

        int count = 1;
        String aString;

        in = new Scanner(new File("sexpr.in"));
        out = new PrintWriter("sexpr.out");

        while(true) {
            aString = in.nextLine().trim();
            if(aString.equals("")){
                break;
            }

            out.printf("%d: %s\r\n", count++, aString);
            
            try{
                process(aString);
                out.printf("\tis an s-expression.\r\n\r\n");

            } catch (Exception e) {
                out.printf("\tis not an s-expression\r\n\r\n");
            }

        }
        in.close();
        out.close();
    }

    public static void process(String aString) throws Exception {
        aString = parse(aString);
        if (!aString.equals("")){
            throw new Exception();
        }
    }

    public static String parse(String aString) throws Exception {

        if(Character.isLetter(aString.charAt(0))){
            return aString.substring(1);
        }
        if(aString.charAt(0) != '('){
            throw new Exception();
        }
        aString = parse(aString.substring(1));

        if(aString.charAt(0) != ','){
            throw new Exception();
        }
        aString = parse(aString.substring(1));

        if(aString.charAt(0) != ')'){
            throw new Exception();
        }
        return aString.substring(1);
    }
}
