import java.io.*;
import java.util.*;

public class WallWalker {

    private static Scanner in;
    private static PrintWriter out;
    private static int count;

    public static void main(String[] args) throws Exception {

        in = new Scanner(new File("WallWalker.in"));
        out = new PrintWriter("WallWalker.out");
        count = 1;
        while(process());

        in.close();
        out.close();

    }

    public static boolean process() throws Exception {
        int x = 0;
        int y = 0;
        int dx = 1;
        int dy = 1;
        int xp = 1;
        int yp = 1;

        int determinant = 0;

        String currentSymbol = in.next();
        // Check for the end case
        if(currentSymbol.equals("X")){
            return false;
        }
        x = Integer.parseInt(currentSymbol);
        while(true){
            currentSymbol = in.next();
            // End Case
            if(currentSymbol.equals("X")){
                break;
            }
            // Change dx and dy for left and right 
            if(currentSymbol.equals("L")){
                int newDx = dy;
                int newDy = -dx;
                dx = newDx;
                dy = newDy;
            } else if(currentSymbol.equals("R")){
                int newDx = -dy;
                int newDy = dx;
                dx = newDx;
                dy = newDy;
            // Handle distance being walked in a direction
            } else {
                int distance = Integer.parseInt(currentSymbol);
                xp = x;
                yp = y;
                x += dx*distance;
                y += dy*distance;

                determinant += xp*y - yp*x;
            }
        }
        out.printf("Case %d: %d sq. ft\r\n\r\n", count++, Math.abs(determinant));
        return true;
    }
}
