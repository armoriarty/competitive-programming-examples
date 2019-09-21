import java.io.*;
import java.util.*;

public class prob3 {

    private static Scanner in;
    private static PrintWriter out;

    public static void main (String[] args) throws Exception {
        in = new Scanner (new File ("prob3.in"));
        out = new PrintWriter ("prob3.out");

        String S = in.nextLine();
        permute("", "ABCD");
    //    char[] SC = S.toCharArray ();
    //    Arrays.sort (SC);
    //    String SS = new String (SC);
        //out.printf ("%s sorted is %s\r\n",S,SS);
        in.close ();
        out.close ();
    }

    public static void permute(String prefix, String suffix){
        if(suffix.compareTo("") == 0){
            System.out.println(prefix);
        } else {
            for(int i = 0; i < suffix.length(); i++){
                String newPrefix = prefix + suffix.charAt(i);
                String newSuffix = suffix.substring(0, i) + suffix.substring(i + 1);
                permute(newPrefix, newSuffix);
            }
        }
    }
}
