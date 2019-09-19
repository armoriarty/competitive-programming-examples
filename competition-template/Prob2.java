import java.io.*;
import java.util.*;

public class Prob2 {
    private static Scanner in;
    private static PrintWriter out;

    public static void main(String[] args) throws Exception{

        in = new Scanner(new File("prob2.in"));
        out = new PrintWriter("prob2.out");

        int[][] M = new int[10][3]; //M is a 2d array of ints

        double x = 5.0;
        out.println("The square root of 5 is " + Math.sqrt(x));

        in.close();
        out.close();
    }
}

