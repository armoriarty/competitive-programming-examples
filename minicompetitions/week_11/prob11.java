//Robin Moriarty
import java.io.*;
import java.util.*;

public class prob11 {
    private static Scanner in;
    private static PrintWriter out;

    public static void main (String[] args) throws Exception {
        in = new Scanner (new File ("prob11.in"));
        out = new PrintWriter ("prob11.out");

        while(in.hasNext()){
            int aNumber = in.nextInt();
            if(aNumber == 0){
                break;
            }
            process(aNumber);
            out.println();

        }

        in.close ();
        out.close ();
    }

    public static void process(int aNumber){
        for(int i = 1; i <= aNumber; i++){
            if(i % 256 == 0){
                out.println("---------");
            } else if (i % 128 == 0){
                out.println("--------");
            } else if (i % 64 == 0){
                out.println("-------");
            } else if (i % 32 == 0){
                out.println("------");
            } else if (i % 16 == 0){
                out.println("-----");
            } else if (i % 8 == 0){
                out.println("----");
            } else if (i % 4 == 0){
                out.println("---");
            } else if (i % 2 == 0){
                out.println("--");
            } else {
                out.println("-");
            }
        }

    }

}
