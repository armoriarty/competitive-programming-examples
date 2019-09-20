import java.io.*;
import java.util.*;

public class prob3 {

    private static Scanner in;
    private static PrintWriter out;

    public static void main (String[] args) throws Exception {
        in = new Scanner (new File ("prob3.in"));
        out = new PrintWriter ("prob3.out");

        String S = in.nextLine();
        char[] SC = S.toCharArray ();
        Arrays.sort (SC);
        String SS = new String (SC);
        out.printf ("%s sorted is %s\r\n",S,SS);
        in.close ();
        out.close ();
    }
}
