//Robin Moriarty
import java.io.*;
import java.util.*;

public class prob10 {
    private static Scanner in;
    private static PrintWriter out;
    private static int count;
    private static char[][] display;

    public static void main (String[] args) throws Exception {
        in = new Scanner (new File ("prob10.in"));
        out = new PrintWriter ("prob10.out");

        while(in.hasNext()){
            int size = in.nextInt();
            if(size == 0){
                break;
            }
            in.nextLine();
            String input = in.nextLine();
            in.nextLine();
            out.println(input);
            display = new char[size][size];
            fillDisplay(input, size);
            printDisplay(size);
        }
        in.close ();
        out.close ();
    }

    public static void fillDisplay(String input, int length){
        int x = length - 1;
        int y = length - 1;
        int dx = 0;
        int dy = -1;
        int stepLength = length - 1;
        int duration = 0;
        int times = 0;
        int currentInputPos = 0;

        for(; currentInputPos < length; currentInputPos++){
            display[currentInputPos][length - 1] = input.charAt(currentInputPos);
        }

        while(currentInputPos < input.length()){
            duration += 1;
            if(duration >= stepLength){
                duration = -1;
                times += 1;
                //turn left
                int temp = dx;
                dx = dy*(-1);
                dy = temp;
                // decrease size
                if(times >= 2){
                    times = 0;
                    stepLength -= 1;
                }
            }
            x += dx;
            y += dy;
            System.out.println("Duration:  " + duration);
            System.out.println(x + "  " + y);
            System.out.flush();
            display[x][y] = input.charAt(currentInputPos);
        }
    }

    public static void printDisplay(int size){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                out.print(display[j][i]);
            }
            out.println();
        }
        out.println();
    }
}
