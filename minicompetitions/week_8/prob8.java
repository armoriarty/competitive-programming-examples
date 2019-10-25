//Robin Moriarty
import java.io.*;
import java.util.*;

public class prob8 {
    private static Scanner in;
    private static PrintWriter out;
    private static char[][] maze;
    private static LinkedList<stuff> q;

    private static class stuff { 
        public int row, column, steps;
        public stuff (int A, int B, int C) {
            row = A; column = B;
            steps = C;
        }
    }

    public static void main (String[] args) throws Exception {
        in = new Scanner (new File ("prob8.in"));
        out = new PrintWriter ("prob8.out");
        int count = 1;

        while(in.hasNext()){
            String row1 = in.nextLine();

            if(row1.length() == 0){
                break;
            }

            int startRow = 0;
            int startColumn = 0;

            maze = new char[22][22];
            for(int i = 0; i < 22; i++){
                for(int j = 0; j < 22; j++){
                    maze[i][j] = '1';
                }
            }
            
            int rowNum = 1;
            String currentRow = row1;
            while(currentRow.length() > 0){
                //System.out.println(currentRow);
                //System.out.println(currentRow.length());
                //System.out.flush();
                for(int i = 1; i < currentRow.length(); i++){
                    maze[rowNum][i] = currentRow.charAt(i - 1);
                    if(maze[rowNum][i] == 'J'){
                        startRow = rowNum;
                        startColumn = i;
                    }
                }
                currentRow = in.nextLine();
                rowNum++;
            }

            out.printf("Case %d:  ", count++);
            //System.out.printf("%d %d\r\n", startRow, startColumn);
            //System.out.flush();

            process(startRow, startColumn);


        }
        out.println();

        in.close ();
        out.close ();
    }

    public static void process(int startRow, int startColumn){
        q = new LinkedList<>();

        q.add(new stuff(startRow, startColumn, 0));

        while(!q.isEmpty()){
            stuff now = q.remove();
            final int row = now.row;
            final int column = now.column;
            final int steps = now.steps;

            if(maze[row][column] == '1'){
                continue;
            }

            if(
                maze[row + 1][column] == 'B' ||
                maze[row - 1][column] == 'B' ||
                maze[row][column + 1] == 'B' ||
                maze[row][column - 1] == 'B' ||
                maze[row + 1][column + 1] == 'B' ||
                maze[row + 1][column - 1] == 'B' ||
                maze[row - 1][column + 1] == 'B' ||
                maze[row - 1][column - 1] == 'B'
            ){
                out.printf("The Joker cannot kill Robin.\r\n\r\n");
                return;
            }

            if(maze[row][column] == 'R'){
                out.printf("The Joker can kill Robin in %d steps.\r\n\r\n", steps);
                return;
            }

            maze[row][column] = '1';

            q.add(new stuff(row + 1, column, steps + 1));
            q.add(new stuff(row - 1, column, steps + 1));
            q.add(new stuff(row, column + 1, steps + 1));
            q.add(new stuff(row, column - 1, steps + 1));

        }
        out.printf("The Joker cannot kill Robin.\r\n\r\n");
    }
}
