package edu.project2;

import java.util.Stack;
import static edu.project2.MazeGenerator.logger;

public class MazeSolver {
    private final char[][] maze;
    private final int width;
    private final int height;
    private final boolean[][] visited;

    private final int firstNumber = 3;
    private final int secondNumber = 2;
    private final int sides = 4;

    public MazeSolver(char[][] maze) {
        this.maze = maze;
        this.height = maze.length;
        this.width = maze[0].length;
        this.visited = new boolean[height][width];
    }

    public boolean solveMaze() {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {1, 1});

        while (!stack.isEmpty()) {
            int[] current = stack.peek();
            int x = current[0];
            int y = current[1];

            if (x == width - 2 && y == height - 2) {
                // Отследим конец
                return true;
            }

            visited[y][x] = true;

            // Right, Down, Left, Up
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};

            boolean moved = false;

            for (int i = 0; i < sides; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX > 0 && newX < width - 1 && newY > 0 && newY < height - 1 && maze[newY][newX] == ' '
                    && !visited[newY][newX]) {
                    stack.push(new int[] {newX, newY});
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                stack.pop();
            }
        }

        return false; // No path found
    }

    public void markPath() {
        int penultimatePointX1 = width - firstNumber;
        int penultimatePointY1 = height - secondNumber;
        int penultimatePointX2 = width - secondNumber;
        int penultimatePointY2 = height - firstNumber;

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {1, 1}); // Стартуем из (1, 1)

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];

            maze[y][x] = '*'; // Будем помечать '*'

            // Вправо, Вниз, Влево, Вверх
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            boolean moved = false;
            for (int i = 0; i < sides; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX > 0 && newX < width - 1 && newY > 0 && newY < height - 1 && maze[newY][newX] == ' '
                    && visited[newY][newX]) {
                    stack.push(new int[] {newX, newY});
                    moved = true;
                }
            }
            if (!moved) {
                maze[y][x] = ' ';
                if ((x == penultimatePointX1 && y == penultimatePointY1)
                    || (x == penultimatePointX2 && y == penultimatePointY2)) {
                    maze[y][x] = '*';
                }
            }
        }

    }

    public void printMaze() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (maze[i][j] == '\u2588') {
                    logger.info("\u001B[37m" + maze[i][j] + " "); // Серые квадраты
                } else {
                    logger.info("\u001B[30m" + maze[i][j] + " "); // Черные квадраты
                }
            }
            logger.info("\u001B[0m");
        }
    }
}
