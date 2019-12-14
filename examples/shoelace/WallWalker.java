import java.io.*;
import java.util.*;

public class WallWalker {

 private static Scanner in;
 private static PrintWriter out;
 private static int cs;

 public static void main (String[] args) throws Exception {

  in = new Scanner (new File ("WallWalker.in"));
  out = new PrintWriter ("WallWalker.out");
  cs = 1;
  while (Process());
  in.close ();
  out.close ();
 }

 public static boolean Process () throws Exception {

  int x=0;
  int y=0;
  int dx=1;
  int dy=0;
  int xp=0;
  int yp=0;
  int Area = 0;
  String t = in.next();

  if (t.equals("X")) return false;
  x = Integer.parseInt (t);
  while (true) {
   t = in.next();
   if (t.equals("X")) break;
   if (t.equals("L")) {
    int ndx = dy;
    int ndy = -dx;
    dx = ndx;
    dy = ndy;
   } else if (t.equals("R")) {
    int ndx = -dy;
    int ndy = dx;
    dx = ndx;
    dy = ndy;
   } else {
    int d = Integer.parseInt (t);
    xp = x;
    yp = y;
    x += dx*d;
    y += dy*d; //Add this corner to the Shoelace Theorem
    Area += xp*y - yp*x;
   }
  }
  out.printf ("Case %d: %d sq. ft.\r\n\r\n",cs++,Math.abs(Area)/2);
  return true;
 }
}

