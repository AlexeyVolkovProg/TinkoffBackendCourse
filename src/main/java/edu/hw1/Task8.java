package edu.hw1;

/**
 * Напишите функцию, которая возвращает true,
 * если кони расставлены на шахматной доске так, что ни один конь не может захватить другого коня.
 * На вход подаётся двумерный массив размера 8х8, где 0 означает пустую клетку, а 1 - занятую конём клетку.
 */
public class Task8 {

    private Task8() {

    }

    @SuppressWarnings("MagicNumber")
    public static boolean isValid(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    @SuppressWarnings("MagicNumber")
    public static boolean knightBoardCapture(int[][] board) {

        int[][] knightMoves = {{-2, 1}, {-2, -1}, {-1, -2}, {2, 1}, {1, 2}, {-1, 2}, {1, -2}, {2, -1}};

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 1) {
                    for (int[] move : knightMoves) {
                        int x = i + move[0];
                        int y = j + move[1];
                        if (Task8.isValid(x, y) && board[x][y] == 1) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
