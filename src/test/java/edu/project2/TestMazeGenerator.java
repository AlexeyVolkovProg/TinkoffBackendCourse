package edu.project2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMazeGenerator {

    @Test
    public void testOddDimensions() {
        int height = 11;
        int width = 21;
        MazeGenerator mazeGenerator = new MazeGenerator(width, height);
        mazeGenerator.generateMaze();
        char[][] maze = mazeGenerator.getMaze();
        assertNotEquals(maze[1][1], '\u2588'); // Проверка, что начальная точка не стена
        assertNotEquals(maze[height - 2][width - 2], '\u2588'); // Проверка, что конечная точка не стена
        assertTrue(
            maze[1][1] == ' ' || maze[1][2] == ' ' || maze[2][1] == ' '); // Проверка на наличие пути от начальной точки
        assertTrue(maze[height - 2][width - 2] == ' ' || maze[height - 2][width - 1] == ' ' ||
            maze[height - 1][width - 2] == ' '); // Проверка на наличие пути к конечной точке
    }

    @Test
    public void testEvenDimensions() {
        int height = 30;
        int width = 30;
        MazeGenerator mazeGenerator = new MazeGenerator(width, height);
        mazeGenerator.generateMaze();
        char[][] maze = mazeGenerator.getMaze();
        assertNotEquals(maze[1][1], '\u2588'); // Проверка, что начальная точка не стена
        assertNotEquals(maze[height - 1][width - 1], '\u2588'); // Проверка, что конечная точка не стена
        assertTrue(
            maze[1][1] == ' ' || maze[1][2] == ' ' || maze[2][1] == ' '); // Проверка на наличие пути от начальной точки
        assertTrue(maze[height - 2][width - 2] == ' ' || maze[height - 2][width - 1] == ' ' ||
            maze[height - 1][width - 2] == ' '); // Проверка на наличие пути к конечной точке
    }

    @Test
    public void testWall(){
        int height = 11;
        int width = 21;
        MazeGenerator mazeGenerator = new MazeGenerator(width, height);
        char[][] maze = mazeGenerator.getMaze();
        for (int i = 0; i < height; i++) { //Проверка на лабиринт окружен стенами
            assertEquals(maze[i][0], '\u2588'); // Стена слева
            assertEquals(maze[i][width - 1], '\u2588'); // Стена справа
        }
        for (int j = 0; j < width; j++) {
            assertEquals(maze[0][j], '\u2588'); // Стена сверху
            assertEquals(maze[height - 1][j], '\u2588'); // Стена снизу
        }

    }

}
