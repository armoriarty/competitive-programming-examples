import java.io.*;
import java.util.*;

public class prob3 {

    private static Scanner in;
    private static PrintWriter out;
    private static int[][][] maze;
    private static int rows, columns, levels;
    private static LinkedList<Position> futureMoves;

    private static class Position {
        public static int row;
        public static int column;
        public static int level;

        public Position(int aRow, int aColumn, int aLevel){
            row = aRow;
            column = aColumn;
            level = aLevel;
        }
    }

    public static void main (String[] args) throws Exception {
        in = new Scanner (new File ("prob3.in"));
        out = new PrintWriter ("prob3.out");

        int count = 1;

        while(in.hasNext()){
            rows = in.nextInt();
            columns = in.nextInt();
            levels = in.nextInt();
            if(rows == 0){
                return;
            }
            in.nextLine();

            maze = new int[rows + 2][columns + 2][levels];
            for(int i = 0; i < rows + 2; i++){
                for(int j = 0; j < columns + 2; j++){
                    for(int k = 0; k < levels; k++){
                        maze[i][j][k] = 1;
                    }
                }
            }

            for(int k = 0; k < levels; k++){
                for(int i = 1 ; i <= rows; i++){
                    String aRow = in.nextLine();
                    for(int j = 1; j <= columns; j++){
                        maze[i][j][k] = '0' - aRow.charAt(j - 1);
                    }
                }
                in.nextLine();
            }

            maze[1][1][0] = 1;

            out.printf("Case %d:  ", count);
            process();
            count++;
        }

        in.close ();
        out.close ();
    }

    public static void process(){

        futureMoves = new LinkedList<>();
        futureMoves.add(new Position(1, 1, 0));

        while(!futureMoves.isEmpty()){
            Position now = futureMoves.remove();

            if(now.row == rows && now.column == columns){
                out.printf("Luke and Leia can escape in %d steps.\n", maze[now.row][now.column][now.level] - 1);
                return;
            }

            if(maze[now.row][now.column][(now.level + 1) % levels] == 0){
                maze[now.row][now.column][(now.level + 1) % levels] = maze[now.row][now.column][now.level] + 1;
                futureMoves.add(new Position(now.row, now.column, ((now.level + 1) % levels)));
            }
            if(maze[now.row + 1][now.column][(now.level + 1) % levels] == 0){
                maze[now.row + 1][now.column][(now.level + 1) % levels] = maze[now.row][now.column][now.level] + 1;
                futureMoves.add(new Position(now.row + 1, now.column, ((now.level + 1) % levels)));
            }
            if(maze[now.row - 1][now.column][(now.level + 1) % levels] == 0){
                maze[now.row - 1][now.column][(now.level + 1) % levels] = maze[now.row][now.column][now.level] + 1;
                futureMoves.add(new Position(now.row - 1, now.column, ((now.level + 1) % levels)));
            }
            if(maze[now.row][now.column + 1][(now.level + 1) % levels] == 0){
                maze[now.row][now.column + 1][(now.level + 1) % levels] = maze[now.row][now.column][now.level] + 1;
                futureMoves.add(new Position(now.row, now.column + 1, ((now.level + 1) % levels)));
            }
            if(maze[now.row][now.column - 1][(now.level + 1) % levels] == 0){
                maze[now.row][now.column - 1][(now.level + 1) % levels] = maze[now.row][now.column][now.level] + 1;
                futureMoves.add(new Position(now.row, now.column - 1, ((now.level + 1) % levels)));
            }
        }
        out.printf("Luke and leia cannot escape.\n");
        out.flush();
    }


    public static void printMaze(){
        for(int k = 0; k < levels; k++){
            for(int i = 0; i < rows + 2; i++){
                for(int j = 0; j < columns + 2; j++){
                    System.out.printf("%d ", maze[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }
}
