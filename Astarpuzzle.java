
import java.util.*;

public class Astarpuzzle {

    static int[][] goal = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 0}
    };

    static int[] rowMove = {-1, 1, 0, 0};
    static int[] colMove = {0, 0, -1, 1};

    public static void main(String[] args) {

        int[][] start = {
            {1, 2, 3},
            {4, 5, 6},
            {0, 7, 8}
        };

    }

    // Calculate heuristic
    static int heuristic(int[][] board) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 0 &&
                    board[i][j] != goal[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    // Node class
    static class Node {
        int[][] board;
        int g, h;

        Node(int[][] board, int g) {
            this.board = board;
            this.g = g;
            this.h = heuristic(board);
        }

        int f() {
            return g + h;
        }
    }

    // Copy the board
    static int[][] copyboard(int[][] board) {
        int[][] copy = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                copy[i][j] = board[i][j];
            }
        }

        return copy;
    }

    // Find the empty space (0)
    static int[] findzero(int[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
}
