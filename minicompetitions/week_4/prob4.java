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
            try{
                process(inputString);
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

    public static void process (String aString)throws Exception {

        aString = parse(aString);
        System.out.println(aString);
        if(!aString.equals("")){
            throw new Exception();
        }
    }

    public static String parse(String aString) throws Exception {
        if(aString.equals("")){
            return "";
        }
        // Pass any non-key character 
        if(aString.charAt(0) != '{' && aString.charAt(0) != '}' && aString.charAt(0) != '(' && aString.charAt(0) != ')' && aString.charAt(0) != '[' && aString.charAt(0) != ']' && aString.charAt(0) != '\"'){
            return parse(aString.substring(1));
        }

        if(aString.charAt(0) == '('){
            System.out.println("(");
            aString = parse(aString.substring(1));
            if(aString.charAt(0) != ')'){
                throw new Exception();
            }
            System.out.println(")");
            aString = aString.substring(1);
        }

        if(aString.charAt(0) == '{'){
            System.out.println("{");
            aString = parse(aString.substring(1));
            if(aString.charAt(0) != '}'){
                //System.out.println(aString);
                throw new Exception();
            }
            System.out.println("}");
            aString = aString.substring(1);
        }

        if(aString.charAt(0) == '\"'){
            System.out.println("\"");
            aString = parse(aString.substring(1));
            if(aString.charAt(0) != '\"'){
                //System.out.println(aString);
                throw new Exception();
            }
            System.out.println("\"");
            aString = aString.substring(1);
        }

        if(aString.charAt(0) == '['){
            System.out.println("[");
            aString = parse(aString.substring(1));
            if(aString.charAt(0) != ']'){
                //System.out.println(aString);
                throw new Exception();
            }
            System.out.println("]");
            aString = aString.substring(1);
        }
        System.out.println("Returned");
        System.out.println(aString);
        return aString; 
    }
}
