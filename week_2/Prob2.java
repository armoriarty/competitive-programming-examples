import java.io.*;
import java.util.*;

public class Prob2 {
    private static Scanner in;
    private static PrintWriter out;

    public static void main(String[] args) throws Exception{

        in = new Scanner(new File("prob2.in"));
        out = new PrintWriter("prob2.out");
        
        int number = in.nextInt();
        while(number != 0){
            process(number);
            number = in.nextInt();
        }
        


        in.close();
        out.close();
    }

    public static void process(int numberOfMailboxes){

        int[][] mailboxes = new int[numberOfMailboxes][3];
        int[]  myAddress = new int[3];

        for(int i = 0; i < mailboxes.length; i++){
            mailboxes[i][0] = in.nextInt();
            mailboxes[i][1] = in.nextInt();
            mailboxes[i][2] = in.nextInt();
        }

        myAddress[0] = in.nextInt();
        myAddress[1] = in.nextInt();
        myAddress[2] = in.nextInt();

        out.println("The closest points to (" + myAddress[0] + "," + myAddress[1] + "," + myAddress[2] + ") are: ");

        double smallestDistance = distance(myAddress, mailboxes[0]);

        for(int i = 1; i < mailboxes.length; i++){
            if(distance(myAddress, mailboxes[i]) < smallestDistance - 1e-5){
                smallestDistance = distance(myAddress, mailboxes[i]);
            }
        }


        for(int i = 0; i < mailboxes.length; i++){
            if(Math.abs(distance(myAddress, mailboxes[i]) - smallestDistance) < 1e-5){
                out.println("(" + mailboxes[i][0] + "," + mailboxes[i][1] + "," + mailboxes[i][2] + ")");
            }
        }


        out.println();

    }

    public static double distance(int[] p1, int[] p2){
        return Math.abs(p1[0] - p2[0]) * Math.abs(p1[0] - p2[0]) +  (Math.abs(p1[1] - p2[1]) * Math.abs(p1[1] - p2[1])) + (Math.abs(p1[2] - p2[2]) * Math.abs(p1[2] - p2[2]));
    }

}

