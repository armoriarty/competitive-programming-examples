import java.io.*;
import java.util.*;

public class Prob1 {

    private static Scanner in;
    private static PrintWriter out;

    public static void main(String[] args) throws Exception {

        in = new Scanner(new File("prob1.in"));
        out = new PrintWriter("prob1.out");

        double d = in.nextDouble();
        out.printf("To two places %.2f\r\n", d);

        in.close();
        out.close();
    }
}
