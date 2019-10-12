//Robin Moriarty
import java.io.*;
import java.util.*;

public class prob6 {

    private static Scanner in;
    private static PrintWriter out;

    static int bricklength;
    static int brickwidth;
    static int brickheight;
    static int boxlength;
    static int boxwidth;
    static int boxheight;

    public static void main(String[] args) throws Exception {

        in = new Scanner(new File("prob6.in"));
        out = new PrintWriter("prob6.out");

        boxlength = in.nextInt();
        boxwidth = in.nextInt();
        boxheight = in.nextInt();
        int count = 1;

        while(boxlength != 0 || boxwidth != 0 || boxheight != 0){
            bricklength = in.nextInt();
            brickwidth = in.nextInt();
            brickheight = in.nextInt();
            
            int brickSum = sumBricks();

            out.printf("Case %d:  Jar Jar can fit %d bricks in the box.\r\n\r\n", count, brickSum);
            
            boxlength = in.nextInt();
            boxwidth = in.nextInt();
            boxheight = in.nextInt();
            count++;
        }

        in.close();
        out.close();
    }


    public static int sumBricks(){
        int sum[] = new int[6];
        sum[0] = (int)Math.floor(boxlength / bricklength) * (int)Math.floor(boxwidth / brickwidth) * (int)Math.floor(boxheight / brickheight);
        sum[1] = (int)Math.floor(boxlength / brickwidth) * (int)Math.floor(boxwidth / brickheight) * (int)Math.floor(boxheight / bricklength);
        sum[2] = (int)Math.floor(boxlength / brickheight) * (int)Math.floor(boxwidth / bricklength) * (int)Math.floor(boxheight / brickwidth);

        sum[3] = (int)Math.floor(boxlength / bricklength) * (int)Math.floor(boxwidth / brickheight) * (int)Math.floor(boxheight / brickwidth);
        sum[4] = (int)Math.floor(boxlength / brickheight) * (int)Math.floor(boxwidth / brickwidth) * (int)Math.floor(boxheight / bricklength);
        sum[5] = (int)Math.floor(boxlength / brickwidth) * (int)Math.floor(boxwidth / bricklength) * (int)Math.floor(boxheight / brickheight);

        int candidate = sum[0];
        for(int i = 1; i < 6; i++){
            if(sum[i] > candidate){
                candidate = sum[i];
            }
        }
        return candidate;
    }

}
