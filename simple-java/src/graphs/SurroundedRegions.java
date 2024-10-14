package graphs;

import java.util.Arrays;

public class SurroundedRegions {

    private int[] rowDir = { 0, 1, 0, -1 };
    private int[] colDir = { 1, 0, -1, 0 };

    private void markVisited(int row, int col, boolean[][] visited, char[][] board) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int effRow = row + rowDir[i];
            int effCol = col + colDir[i];

            if (effRow >= 0 && effRow < board.length && effCol >= 0 && effCol < board[0].length
                    && !visited[effRow][effCol] && board[effRow][effCol] == 'O') {
                markVisited(effRow, effCol, visited, board);
            }
        }
    }

    public void solve(char[][] board) {
        int N = board.length, M = board[0].length;
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < M; i++) {
            if (!visited[0][i] && board[0][i] == 'O') {
                markVisited(0, i, visited, board);
            }

            if (!visited[N - 1][i] && board[N - 1][i] == 'O') {
                markVisited(N - 1, i, visited, board);
            }
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i][0] && board[i][0] == 'O') {
                markVisited(i, 0, visited, board);
            }

            if (!visited[i][M - 1] && board[i][M - 1] == 'O') {
                markVisited(i, M - 1, visited, board);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] array = {
                { 'X', 'O', 'X', 'O', 'X', 'O' },
                { 'O', 'X', 'O', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'O', 'X', 'O' },
                { 'O', 'X', 'O', 'X', 'O', 'X' }
        };

        var surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(array);

        String result = Arrays.deepToString(array)
                .replace("], ", "]\n")
                .replace("[[", "[")
                .replace("]]", "]");

        System.out.println(result);
    }
}
