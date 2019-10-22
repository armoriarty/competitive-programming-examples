//Robin Moriarty
import java.io.*;
import java.util.*;

public class prob7 {
    private static LinkedList<stuff> q;
    private static Scanner in;
    private static PrintWriter out;
    private static char[][] maze;
    private static int rows, columns;

    private static class velocity {
        public String direction;
        public int duration;
        public velocity(String aDirection, int aDur){
            direction = aDirection;
            duration = aDur;
        }
    }

    private static class stuff { 
        public int a, b;
        public LinkedList<velocity> c;
        
        public stuff (int A, int B, velocity C) {
            a = A; b = B;

            c = new LinkedList<>();

            if(C == null){
                return;
            }

            if(c.isEmpty()){
                c.add(C);
            }

            if(C.direction.equals(c.peekLast().direction)){
                c.peekLast().duration++;
            }
            c.add(C);

        }
    }

    public static void main (String[] args) throws Exception {
        in = new Scanner (new File ("prob7.in"));
        out = new PrintWriter ("prob7.out");
        int count = 1;

        while(in.hasNext()){
            rows = in.nextInt();
            columns = in.nextInt();
            System.out.printf("%d %d\r\n", rows, columns);
            System.out.flush();
            in.nextLine();
            int startRow = 0;
            int startColumn = 0;

            if(rows == 0){
                break;
            }
            maze = new char[rows + 2][columns + 2];

            for(int i = 0; i < rows + 2; i++){
                for (int j = 0; j < columns; j++){
                    maze[i][j] = '*';
                }
            }

            for(int i = 1; i < rows + 1; i++){
                String aRow = in.nextLine();
                for(int j = 1; j < columns + 1; j++){
                    maze[i][j] = aRow.charAt(j - 1);
                    if(maze[i][j] == 'P'){
                        startRow = i;
                        startColumn = j;
                        System.out.printf("%d %d\r\n\r\n", startRows, startColumns);
                        System.out.flush();

                    }
                }
            }

            out.printf("Case %d:\r\n", count);
            process(startRow, startColumn);
            out.println();
            count++;


        }
        
        in.close ();
        out.close ();
    }

    private static void process(int startRow, int startColumn){

        q = new LinkedList<>();
        q.add(new stuff(startRow, startColumn, null));

        while(!q.isEmpty()){
            stuff now = q.remove();

            int row = now.a;
            int column = now.b;
            LinkedList<velocity> path = now.c;

            if(maze[row][column] == 'T'){
                while(!path.isEmpty()){
                    velocity step = path.remove();
                    if(step.duration == 1){
                        out.printf("Walk %d pace %s\r\n", step.duration, step.direction);
                    } else {
                        out.printf("Walk %d paces %s\r\n", step.duration, step.direction);
                    }
                }
                return;
            }

            if(maze[row][column] == '*'){
                continue;
            }
            maze[row][column] = '*';

            q.add(new stuff(row + 1, column, new velocity("north", 1 )));
            q.add(new stuff(row - 1, column, new velocity("south", 1 )));
            q.add(new stuff(row, column + 1, new velocity("east", 1 )));
            q.add(new stuff(row, column - 1, new velocity("west", 1 )));

        }

        out.printf("Arrr!  There be no treasure here!\r\n");

    }
}
