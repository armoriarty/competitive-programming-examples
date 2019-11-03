import java.io.*;
import java.util.*;

public class altprob3 {

    private static Scanner in;
    private static PrintWriter out;
    private static int rows, columns, levels;
    private static char[][][] maze;
    private static LinkedList<Position> futureMoves;

    private static class Position {
        public int row;
        public int column;
        public int level;
        public int steps;

        public Position(int aRow, int aColumn, int aLevel, int aDist) {
            row = aRow;
            column = aColumn;
            level = aLevel;
            steps = aDist;
        }
    }

    public static void main(String[] args) throws Exception {
        in = new Scanner(new File("prob3.in"));
        out = new PrintWriter("prob3.out");
        int count = 1;

        while (in.hasNext()) {
            rows = in.nextInt();
            columns = in.nextInt();
            levels = in.nextInt();
            in.nextLine();

            if (rows == 0) {
                break;
            }

            maze = new char[rows + 2][columns + 2][levels];
            for (int i = 0; i < rows + 2; i++) {
                for (int j = 0; j < columns + 2; j++) {
                    for (int k = 0; k < levels; k++) {
                        maze[i][j][k] = '1';
                    }
                }
            }

            for (int k = 0; k < levels; k++) {
                for (int i = 1; i < rows + 1; i++) {
                    String aRow = in.nextLine();
                    for (int j = 1; j < columns + 1; j++) {
                        maze[i][j][k] = aRow.charAt(j - 1);
                    }
                }
                in.nextLine();
            }

            out.printf("Case %d:  ", count);
            process();
            count++;
        }

        in.close();
        out.close();
    }

    private static void process() {

        futureMoves = new LinkedList<>();
        futureMoves.add(new Position(1, 1, 0, 0));

        while (!futureMoves.isEmpty()) {
            Position now = futureMoves.remove();
            final int row = now.row;
            final int column = now.column;
            final int level = now.level;
            final int steps = now.steps;
            System.out.printf("Position: %d %d %d %d\n", row, column, level, steps);
            printMaze();
            System.out.println();

            if (row == rows && column == columns) {
                out.printf("Luke and Leia can escape in %d steps.\r\n", steps);
                return;
            }

            if (maze[row][column][level] == '1') {
                continue;
            }
            maze[row][column][level] = '1';

            final int nextLevel = (level + 1) % levels;
            System.out.printf("Position: %d %d %d %d\n", row, column, level, steps);
            System.out.printf("Current Level: %d Next Level: %d \n", level, nextLevel);
            final int nextStepCount = steps + 1;

            futureMoves.add(new Position(row, column, nextLevel, nextStepCount));
            System.out.printf("Position: %d %d %d %d\n", row, column, level, steps);
            System.out.printf("Adding %d %d %d \r\n", row, column, nextLevel, nextStepCount);

            futureMoves.add(new Position((row) + 1, column, nextLevel, nextStepCount));
            System.out.printf("Position: %d %d %d %d\n", row, column, level, steps);
            System.out.printf("Adding %d %d %d \r\n", row + 1, column, nextLevel, nextStepCount);

            futureMoves.add(new Position((row) - 1, column, nextLevel, nextStepCount));
            System.out.printf("Position: %d %d %d %d\n", row, column, level, steps);
            System.out.printf("Adding %d %d %d \r\n", row - 1, column, nextLevel, nextStepCount);

            futureMoves.add(new Position(row, (column) + 1, nextLevel, nextStepCount));
            System.out.printf("Position: %d %d %d %d\n", row, column, level, steps);
            System.out.printf("Adding %d %d %d \r\n", row, column + 1, nextLevel, nextStepCount);

            futureMoves.add(new Position(row, (column) - 1, nextLevel, nextStepCount));
            System.out.printf("Position: %d %d %d %d\n", row, column, level, steps);
            System.out.printf("Adding %d %d %d \r\n", row, column - 1, nextLevel, nextStepCount);
        }
        System.out.println();
        out.printf("Luke and Leia cannot escape.\r\n");
    }

    public static void printMaze() {
        for (int k = 0; k < levels; k++) {
            for (int i = 0; i < rows + 2; i++) {
                for (int j = 0; j < columns + 2; j++) {
                    System.out.printf("%s ", maze[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }
}