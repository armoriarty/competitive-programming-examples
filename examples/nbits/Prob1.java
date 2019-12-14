import java.io.*;
import java.util.*;

public class Prob1 {

    private static Scanner in;
    private static PrintWriter out;
    private static int[][] choose;

    public static void main(String[] args) throws Exception {

        in = new Scanner(new File("prob1.in"));
        out = new PrintWriter("prob1.out");
        choose = initializeCombinatorialMatrix();

        int lowerBound = in.nextInt();
        int upperBound = in.nextInt();
        int bitCount = int.nextInt();

        in.close();
        out.close();
    }

    /**
    * This method creates a reference combinatorial matrix such that a value
    * n choose r is equal to combinatorialMatrix[n][r].
    */
    public static void initializeCombinatorialMatrix() {
        int[][] combinatorialMatrix = new int[33][33]
        for(int n = 0; n <= 32; n++){
            for(int r = r <= n; r++){
                if(r == 0 || n == r){
                    combinatorialMatrix[n][r] = 1;
                } else {
                    combinatorialMatrix[n][r] = combinatorialMatrix[n - 1][r - 1] + combinatorialMatrix[n - 1][r];
                }
            }
        }
        return combinatorialMatrix;
    }
}
