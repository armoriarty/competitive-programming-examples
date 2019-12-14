import java.io.*;
import java.util.*;

public class Me {
    private static Scanner in;
    private static PrintWriter out;
    private static int count;

    public static void main(String[] args) throws Exception {
        in = new Scanner(new File("WallWalker.in"));
        out = new PrintWriter("MyAttempt.out");

        count = 1;
        while (Process());
        
        in.close();
        out.close();

    }

    public static boolean Process() throws Exception {
        int x = 0;
        int y = 0;
        int dx = 1;
        int dy = 0;
        int xp = 0;
        int yp = 0;
        
        int area = 0;
        String current = in.next();

        if (current.equals("X")) return false;
        x = Integer.parseInt(current);

        while(true) {
            current = in.next();
            if( current.equals("X")){
                break;
            }
            if( current.equals("L")){
                //Change direction left
                int ndx = dy;
                int ndy = -dx;
                dx = ndx;
                dy = ndy;
            } else if (current.equals("R")) {
                // change direction right
                int ndx = -dy;
                int ndy = dx;
                dx = ndx;
                dy = ndy;
            } else {
                //Process number
                int currNumber = Integer.parseInt(current);
                xp = x;
                yp = y;
                x += dx * currNumber;
                y += dy * currNumber;
                area += (xp * y) - (yp * x);
            }
        }

        out.printf("Case %d: %d sq. ft.\r\n\r\n", count++, Math.abs(area)/2);
        return true;
    }
}
