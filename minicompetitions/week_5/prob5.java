//Robin Moriarty
import java.io.*;
import java.util.*;

public class prob5 {

    private static Scanner in;
    private static PrintWriter out;

    public static void main(String[] args) throws Exception {

        in = new Scanner(new File("prob5.in"));
        out = new PrintWriter("prob5.out");

        int lower = in.nextInt();
        int upper = in.nextInt();
        int count = 1;
        while(lower <= upper){
            out.println("Case " + count);
            out.print("The unescaped prisoners are in cells ");
            calculateCells(lower, upper);
            out.println();
            out.println();

            lower = in.nextInt();
            upper = in.nextInt();
            count++;
        }

        in.close();
        out.close();
    }

    public static void calculateCells(int lower, int upper){
        for(int i = lower; i <= upper; i++){
            if(Math.sqrt(i) == Math.floor(Math.sqrt(i))){
            } else {
                out.printf("%d ", i);
            }
        }
    }
}
