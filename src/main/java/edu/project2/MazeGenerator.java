package edu.project2;

import java.util.Random;
import java.util.Stack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class MazeGenerator {

    public static Logger logger = (Logger) LogManager.getLogger(MazeGenerator.class);

    private final int width;
    private final int height;

    private final int right = 1;

    private final int down = 2;

    private final int left = 3;

    private final int up = 4;

    private final char[][] maze;
    private final boolean[][] visited;

    public MazeGenerator(int width, int height) {
        this.width = (width % 2 == 0) ? width + 1 : width; // Подкорректируем стороны, для правильной работы
        this.height = (height % 2 == 0) ? height + 1 : height;
        maze = new char[this.height][this.width];
        visited = new boolean[this.height][this.width];
        initializeMaze();
    }

    private void initializeMaze() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                maze[i][j] = '\u2588'; // Проинициализируем массив лабиринта
                visited[i][j] = false;
            }
        }
    }

    public void generateMaze() {
        Random rand = new Random();
        int startX = 1;
        int startY = 1;
        visited[startY][startX] = true;
        maze[startY][startX] = ' ';

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {startX, startY});

        while (!stack.isEmpty()) {
            int[] current = stack.peek();
            int x = current[0];
            int y = current[1];

            int[] directions = {right, down, left, up}; // Вправо, вниз, влево, вверх
            shuffleArray(directions, rand);

            boolean moved = false;

            for (int dir : directions) {
                int newX = x;
                int newY = y;

                if (dir == right) { // Вправо
                    newX = x + 2;
                } else if (dir == down) { // Вниз
                    newY = y + 2;
                } else if (dir == left) { // Влево
                    newX = x - 2;
                } else if (dir == up) { // Вверх
                    newY = y - 2;
                }

                if (newX > 0 && newX < width && newY > 0 && newY < height && !visited[newY][newX]) {
                    stack.push(new int[] {newX, newY});
                    visited[newY][newX] = true;
                    maze[newY][newX] = ' ';
                    maze[y + (newY - y) / 2][x + (newX - x) / 2] = ' ';
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                stack.pop();
            }
        }
    }

    public void printMaze() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (maze[i][j] == '\u2588') {
                    logger.info("\u001B[37m" + maze[i][j] + " "); // Серый квадрат
                } else {
                    logger.info("\u001B[30m" + maze[i][j] + " "); // Черный квадрат
                }
            }
            logger.info("\u001B[0m");
        }
    }

    private void shuffleArray(int[] array, Random rand) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }

    public char[][] getMaze() {
        return maze;
    }

}
