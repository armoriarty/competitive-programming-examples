import java.io.*;
import java.util.*;

public class ChangingMaze {

    private static Scanner in;
    private static PrintWriter out;
    private static int r,c,t,cs;
    private static char[][][] Maze;
    private static LinkedList<Loc> futureMoves;

    public static void main (String[] args) throws Exception {

        cs=1;
        in = new Scanner (new File ("prob3.in"));
        out = new PrintWriter ("prob3.out");
        while (true) {
            r = in.nextInt();
            c = in.nextInt();
            t = in.nextInt();
            if (r == 0 && c == 0 && t == 0){
                break;
            }
            InitializeMaze ();
            Process ();
        }
        in.close ();
        out.close ();
    }


    public static void InitializeMaze () throws Exception {
        Maze = new char[r+2][c+2][t];
        for (int i=0; i < r+2; i++){
            for (int j=0; j < c+2; j++){
                for (int k=0; k < t; k++){
                    Maze[i][j][k] = '1';
                }
            }
        }
        for (int k=0; k < t; k++){
            for (int i=1; i <=r; i++) {
                String l = in.next();
                for (int j=1; j <=c; j++)
                Maze[i][j][k] = l.charAt(j-1);
            }
        }
    }

    public static void Process () throws Exception {

        Loc l;
        futureMoves = new LinkedList<> ();
        futureMoves.add (new Loc(1,1,0,0));
        while ((l=futureMoves.poll()) != null) {
            int currentRow = l.row;
            int col = l.column;
            int lev = l.time;
            int m = l.moves;

            if (Maze[currentRow][col][lev]=='1'){
                continue;
            }
            Maze[currentRow][col][lev]='1';

            if (currentRow == r && col == c) {
                out.printf ("Case %d:  Luke and Leia can escape in %d steps.\r\n", cs++, m);
                return;
            }
            int nextTime = (lev + 1) % t;
            futureMoves.add (new Loc(currentRow    , col    , nextTime, m+1));
            futureMoves.add (new Loc(currentRow + 1, col    , nextTime, m+1));
            futureMoves.add (new Loc(currentRow - 1, col    , nextTime, m+1));
            futureMoves.add (new Loc(currentRow    , col + 1, nextTime, m+1));
            futureMoves.add (new Loc(currentRow    , col - 1, nextTime, m+1));
        }
        out.printf ("Case %d:  Luke and Leia cannot escape.\r\n",cs++);
    }

    private static class Loc {

        public int row;
        public int column;
        public int time;
        public int moves;

        public Loc (int aRow, int aColumn, int aTime, int aDistance) {
            row = aRow;
            column = aColumn;
            time = aTime;
            moves = aDistance;
        }
    }
}