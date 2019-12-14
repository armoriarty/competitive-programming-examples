import java.io.*;
import java.util.*;

public class spiralofprimes {
    private static Scanner in;
    private static PrintWriter out;
    private static int r, c, dr, dc, cs;
    private static Vector<rcp> grid;
    private static int leftturns, ltl;
    public static void main (String[] args) throws Exception {

        in = new Scanner (new File ("spiralofprimes.in"));
        out = new PrintWriter ("spiralofprimes.out");
        cs = 1;
        r = 0; c = 0; dr = 0; dc = 1;
        BuildGrid();
        while (true) {
            int rr = in.nextInt();
            if (rr==-999) break;
            int cc = in.nextInt ();
            for (int i=0; i < grid.size(); i++) {
                rcp g = grid.elementAt(i);
                if (g.r == cc && g.c==rr) {
                    out.printf ("Case %d: The prime at location (%d,%d) is %d.\r\n\r\n",
                    cs++,rr,cc,g.p);
                    break;
                }
            }
        }
        in.close ();
        out.close ();
    }
    public static void turnleft () {
        int ndr = dc; //(0,1)-->(1,0)-->(0,-1)-->(-1,0)
        int ndc = -dr;
        dr = ndr;
        dc = ndc;
    }
    public static void BuildGrid () {
        leftturns = 0;
        ltl = 1;
        int mct = 0;
        grid = new Vector<> ();
        outer: for (int p = 2; p <= 10000; p++) {
             for (int i=0; i < grid.size(); i++)

                                                                                                                              if (p % grid.elementAt(i).p == 0)

                                                                                                                                       continue outer;

                                                                                                                                          grid.add (new rcp (r,c,p));

                                                                                                                                             r += dr;

                                                                                                                                                c += dc;

                                                                                                                                                   mct++;

                                                                                                                                                      if (mct==ltl) {

                                                                                                                                                              turnleft();

                                                                                                                                                                  leftturns++;

                                                                                                                                                                      mct = 0;

                                                                                                                                                                          if (leftturns%2==0) ltl++;

                                                                                                                                                                             }

                                                                                                                                                                               }

                                                                                                                                                                                }

}



class rcp {



     public int r, c, p;

      rcp (int R, int C, int P) {r=R;c=C;p=P;}

}


