//Robin Moriarty
import java.io.*;
import java.util.*;

public class prob7 {
    private static Scanner in;
    private static PrintWriter out;
    private static char[][] maze;
    private static LinkedList<stuff> q;

    private static class stuff { 
        public int row, column;
        public String steps;
        public stuff (int A, int B, String C) {
            row = A; column = B;
            steps = C;
        }
    }

    public static void main (String[] args) throws Exception {
        in = new Scanner (new File ("prob7.in"));
        out = new PrintWriter ("prob7.out");
        int count = 1;

        while(in.hasNext()){
            int rows = in.nextInt();
            int columns = in.nextInt();
            in.nextLine();

            if(rows == 0){
                break;
            }

            int startRow = 0;
            int startColumn = 0;

            maze = new char[rows + 2][columns + 2];
            for(int i = 0; i < rows + 2; i++){
                for(int j = 0; j < columns + 2; j++){
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
                    }
                }
            }

            out.printf("Case %d:\r\n", count);
            process(startRow, startColumn);
            count++;
        }

        in.close ();
        out.close ();
    }

    public static void process(int startRow, int startColumn){
        q = new LinkedList<>();

        q.add(new stuff(startRow, startColumn, ""));

        while(!q.isEmpty()){
            stuff now = q.remove();
            final int row = now.row;
            final int column = now.column;
            final String steps = now.steps;

            if(maze[row][column] == 'T'){
                printVictory(steps);
                return;
            }

            if(maze[row][column] == '*'){
                continue;
            }
            maze[row][column] = '*';

            q.add(new stuff(row + 1, column, steps + "N"));
            q.add(new stuff(row - 1, column, steps + "S"));
            q.add(new stuff(row, column + 1, steps + "E"));
            q.add(new stuff(row, column - 1, steps + "W"));

        }

        out.printf("Arrr!  There be no treasure here!\r\n");
    }

    public static void printVictory(String steps){
        int i = 0;

        while( i < steps.length()){
            int size = 1;
            String direction;
            while((i + size) < steps.length() && steps.charAt(i) == steps.charAt(i + size) ){
                size++;
            }

            if(steps.charAt(i) == 'N'){
                direction = "north";
            } else if(steps.charAt(i) == 'S'){
                direction = "south";
            } else if(steps.charAt(i) == 'E'){
                direction = "east";
            } else {
                direction = "west";
            }

            if(size == 1){
                out.printf("Walk %d pace %s.\r\n", size, direction);
            } else {
                out.printf("Walk %d paces %s.\r\n", size, direction);
            }
            i += size;
        }
        out.printf("\r\n");
    }
}
