import java.io.*;
import java.util.*;

public class prob3 {

    private static Scanner in;
    private static PrintWriter out;
    private static String lastString;

    public static void main (String[] args) throws Exception {
        lastString = "";
        in = new Scanner (new File ("prob3.in"));
        out = new PrintWriter ("prob3.out");
        String inputString = in.nextLine();
        int count = 1;
        while(!inputString.equals("")){
            String intString = in.nextLine();
            int stringLength = Integer.parseInt(intString);
            char[] inputArray = inputString.toCharArray();
            Arrays.sort (inputArray);
            String sortedInput = new String (inputArray);
            out.printf("Case: %d: The alphebetical substrings of %s are:\n", count, sortedInput);
            permute("", stringLength, sortedInput);
            out.println();
            count++;
            inputString = in.nextLine();

        }
        in.close ();
        out.close ();
    }

    public static void permute(String prefix, int stringLength, String candidates){
        if(stringLength == 0){
            out.printf("%s\n", prefix);
        } else {
            for(int i = 0; i <= candidates.length() - stringLength; i++)
                if( i == 0 || candidates.charAt(i) > candidates.charAt(i - 1)){
                    String newPrefix = prefix + candidates.charAt(i);
                    String newCandidates = candidates.substring(i + 1);
                    permute(newPrefix, stringLength - 1, newCandidates);
                }
            }
        }
//        if(prefix.length() + candidates.length() < stringLength){
//            return;
//        }
//        if(prefix.length() == stringLength && !prefix.equals(lastString) ){
//            out.println(prefix);
//            lastString = prefix;
//        } else {
//            for(int i = 0; i < candidates.length() - stringLength; i++){
//                String newPrefix = prefix + candidates.charAt(i);
//                String newcandidates = candidates.substring(i + 1);
//                permute(newPrefix, stringLength, newcandidates);
//            }
//        }
//    }
}
