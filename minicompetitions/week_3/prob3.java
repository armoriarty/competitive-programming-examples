import java.io.*;
import java.util.*;

public class prob3 {

    private static Scanner in;
    private static PrintWriter out;
    private static String lastString;
    private static boolean stopFlag;

    public static void main (String[] args) throws Exception {
        lastString = "";
        in = new Scanner (new File ("prob3.in"));
        out = new PrintWriter ("prob3.out");
        String S = in.nextLine();
        int count = 1;
        while(!S.equals("")){
            stopFlag = false;
            String intString = in.nextLine();
            int stringLength = Integer.parseInt(intString);
            char[] SC = S.toCharArray ();
            Arrays.sort (SC);
            String SS = new String (SC);
            out.print("Case ");
            out.print( count);
            out.print(": The alphebetical substring of ");
            out.print(SS);
            out.println(" are: ");
            permute("", stringLength, SS);
            out.println();
            count++;
            S = in.nextLine();

        }
        in.close ();
        out.close ();
    }

    public static void permute(String prefix, int stringLength, String candidates){
        if(prefix.length() > stringLength){
            return;
        }
        if(prefix.length() == stringLength ){
            if(lastString.equals(prefix)){
                stopFlag = true;
                return;
            }
            out.println(prefix);
            System.out.println(prefix);
            lastString = prefix;
        } else {
            for(int i = 0; i < candidates.length(); i++){
                if(stopFlag){
                    return;
                }
                String newPrefix = prefix + candidates.charAt(i);
                String newcandidates = candidates.substring(i + 1);
                permute(newPrefix, stringLength, newcandidates);
            }
        }
    }
}
