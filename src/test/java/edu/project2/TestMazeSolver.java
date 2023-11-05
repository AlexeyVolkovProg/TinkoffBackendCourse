package edu.project2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMazeSolver {

    @Test
    public void testSolveMazeSuccess() {
        char[][] maze = {
            {'█', '█', '█', '█', '█', '█'},
            {'█', ' ', ' ', ' ', ' ', '█'},
            {'█', '█', '█', ' ', '█', '█'},
            {'█', ' ', ' ', ' ', ' ', '█'},
            {'█', '█', '█', '█', '█', '█'}
        };

        MazeSolver mazeSolver = new MazeSolver(maze);
        assertTrue(mazeSolver.solveMaze());
    }

    @Test
    public void testSolveMazeFailure() {
        char[][] maze = {
            {'█', '█', '█', '█', '█', '█'},
            {'█', ' ', '█', ' ', ' ', '█'},
            {'█', '█', '█', ' ', '█', '█'},
            {'█', ' ', '█', ' ', '█', '█'},
            {'█', '█', '█', '█', '█', '█'}
        };

        MazeSolver mazeSolver = new MazeSolver(maze);
        assertFalse(mazeSolver.solveMaze());
    }

    @Test
    public void testMarkPath() {
        char[][] maze = {
            {'█', '█', '█', '█', '█', '█'},
            {'█', ' ', ' ', ' ', ' ', '█'},
            {'█', '█', '█', ' ', '█', '█'},
            {'█', ' ', ' ', ' ', ' ', '█'},
            {'█', '█', '█', '█', '█', '█'}
        };

        MazeSolver mazeSolver = new MazeSolver(maze);
        mazeSolver.solveMaze();
        mazeSolver.markPath();

        char[][] markedMaze = {
            {'█', '█', '█', '█', '█', '█'},
            {'█', '*', '*', '*', ' ', '█'},
            {'█', '█', '█', '*', '█', '█'},
            {'█', ' ', ' ', '*', ' ', '█'},
            {'█', '█', '█', '█', '█', '█'}
        };

        assertArrayEquals(maze, markedMaze);
    }

    @Test
    public void testMarkNoPath() {
        char[][] maze = {
            {'█', '█', '█', '█', '█', '█'},
            {'█', ' ', '█', '█', '█', '█'},
            {'█', '█', '█', '█', '█', '█'},
            {'█', '█', '█', '█', '█', '█'},
            {'█', '█', '█', '█', '█', '█'}
        };

        MazeSolver mazeSolver = new MazeSolver(maze);
        assertFalse(mazeSolver.solveMaze());
        mazeSolver.markPath();

        char[][] markedMaze = {
            {'█', '█', '█', '█', '█', '█'},
            {'█', ' ', '█', '█', '█', '█'},
            {'█', '█', '█', '█', '█', '█'},
            {'█', '█', '█', '█', '█', '█'},
            {'█', '█', '█', '█', '█', '█'}
        };

        assertArrayEquals(maze, markedMaze);
    }


}
