import java.io.*;
import java.util.*;

public class prob4 {

    private static Scanner in;
    private static PrintWriter out;

    public static void main (String[] args) throws Exception {
        in = new Scanner (new File ("prob4.in"));
        out = new PrintWriter ("prob4.out");
        String inputString = in.nextLine();
        while(!inputString.equals("")){
            out.println(inputString);
            inputString = in.nextLine();
        }
        in.close ();
        out.close ();
    }
}
