import java.io.*;
import java.util.*;

public class Permutation {
    private static PrintWriter out;
    
    public static void main(String[] args) throws Exception {
        out = new PrintWriter("Permutations.out");
        permute("", "ABCDEFG");
        out.close();
    }

    public static void permute (String prefix, String suffix) {
//        System.out.println("Permute has been called:");
//        System.out.println("My prefix is: " + prefix);
//        System.out.println("My suffix is: " + suffix);
        
        if(suffix.compareTo("") == 0){
            out.println(prefix);
        }
        for(int i = 0; i < suffix.length(); i++){
            String nextPrefix = prefix + suffix.charAt(i);
            String nextSuffix = suffix.substring(0, i) + suffix.substring(i + 1);
            permute(nextPrefix, nextSuffix);
        }
    }
}
