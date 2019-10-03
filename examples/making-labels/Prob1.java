import java.io.*;
import java.util.*;

public class Prob1 {

    private static Scanner in;
    private static PrintWriter out;

    public static void main(String[] args) throws Exception {

        in = new Scanner(new File("prob1.in"));
        out = new PrintWriter("prob1.out");

        int numberOfNodes = in.nextInt();
        while(numberOfNodes != 0){
            int numberOfConfigurations = 1;
            for(int i = 2; i < numberOfNodes; i++){
                numberOfConfigurations *= numberOfNodes;
            }
            out.printf("Case %d, N=%d, # of different labelings = %d\n", 1, numberOfNodes, numberOfConfigurations);
            numberOfNodes = in.nextInt();
        }

        in.close();
        out.close();
    }
}
