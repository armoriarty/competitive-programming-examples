import java.io.*;
import java.util.*;

public class Prob1 {

    private static Scanner in;
    private static PrintWriter out;

    private static double stamp1;
    private static double stamp2;
    private static double stamp3;
    private static double cost;

    public static void main(String[] args) throws Exception {

        in = new Scanner(new File("prob1.in"));
        out = new PrintWriter("prob1.out");
        
        process();

        in.close();
        out.close();
    }

    public static void process() {
        while(true){
            readValues();
            if(stamp1 == 0 && stamp2 == 0 && stamp3 == 0 && cost == 0){
                return;
            }
            out.printf("There are %d ways to make a total of %2f.\r\n", countPossibleStamps(), cost);
        }


    }

    public static int countPossibleStamps() {
        int count = 0;
        //This is assuming that stamp3 is the largest denomination, stamp 2 is the second ... etc.

        for(int i = 0; i*stamp1 - 1e-5 <= cost; i++){
            for(int j = 0; j*stamp2 - 1e-5 <= cost; j++){
                for(int k = 0; k*stamp3 - 1e-5 <= cost; k++){
                    if(equal(i*stamp1 + j*stamp2 + k+stamp3, cost)){
                        count++;
                    }
                }
            }
        }

        return count;
    }
    
    public static boolean equal(double first, double second){
        if (Math.abs(first - second) <= 1e-5){
            return true;
        }
        return false;
    }

    public static void readValues() {
        stamp1 = in.nextDouble();
        stamp2 = in.nextDouble();
        stamp3 = in.nextDouble();
        cost = in.nextDouble();
    }
}
