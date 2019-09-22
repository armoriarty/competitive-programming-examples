import java.io.*;
import java.util.*;

public class Induction {

    private static Scanner in;
    private static PrintWriter out;

    public static void main (String[] args) throws Exception {
        in = new Scanner (new File ("Induction.in"));
        out = new PrintWriter ("Induction.out");

        int currentInput = in.nextInt();
        while(currentInput != -1){
            out.printf("f(%d) = %d\n", currentInput, function(currentInput));
            currentInput = in.nextInt();
        }
        
        in.close ();
        out.close ();
    }

    public static int function(int aNumber){
        if(aNumber == 1){
            return 1;
        }
        if(aNumber % 2 == 0){
            return aNumber / 2;
        }
        int n = (aNumber - 1) / 2;
        return function(n) + function (n + 1); 
    }
}
