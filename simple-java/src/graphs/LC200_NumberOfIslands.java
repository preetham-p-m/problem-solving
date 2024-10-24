package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class LC200_NumberOfIslands {

    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // #region 8 Direction(right, left, top, bottom)
    private final int[] rowDir = { -1, 1, 0, 0 };
    private final int[] colDir = { 0, 0, -1, 1 };

    private void bfsFor4Direction(char[][] grid, int row, int col, boolean[][] visited) {
        int rowLength = grid.length, colLength = grid[0].length;
        visited[row][col] = true;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));

        while (!queue.isEmpty()) {
            int currentRow = queue.peek().first;
            int currentCol = queue.peek().second;
            queue.remove();

            for (int i = 0; i < 4; i++) {
                int effRow = currentRow + rowDir[i];
                int effCol = currentCol + colDir[i];

                if (effRow >= 0 && effRow < rowLength && effCol >= 0 && effCol < colLength
                        && grid[effRow][effCol] == '1' && !visited[effRow][effCol]) {
                    visited[effRow][effCol] = true;
                    queue.add(new Pair(effRow, effCol));
                }

            }

        }
    }

    public int numIslandsFor4Direction(char[][] grid) {
        int islands = 0;
        int rowLength = grid.length, colLength = grid[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (!visited[row][col] && grid[row][col] == '1') {
                    bfsFor4Direction(grid, row, col, visited);
                    islands++;
                }
            }
        }

        return islands;
    }
    // #endregion

    // #region 8 Direction (left, right, top, bottom, top-left, top-right,
    // bottom-left, bottom-right)
    private void bfsFor8Direction(char[][] grid, int row, int col, boolean[][] visited) {
        int rowLength = grid.length, colLength = grid[0].length;
        visited[row][col] = true;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));

        while (!queue.isEmpty()) {
            int currentRow = queue.peek().first;
            int currentCol = queue.peek().second;
            queue.remove();

            for (int diffRow = -1; diffRow <= 1; diffRow++) {
                for (int diffCol = -1; diffCol <= 1; diffCol++) {
                    int effRow = currentRow + diffRow;
                    int effCol = currentCol + diffCol;

                    if (effRow >= 0 && effRow < rowLength && effCol >= 0 && effCol < colLength
                            && grid[effRow][effCol] == '1' && !visited[effRow][effCol]) {
                        visited[effRow][effCol] = true;
                        queue.add(new Pair(effRow, effCol));
                    }
                }
            }

        }
    }

    public int numIslandsFor8Direction(char[][] grid) {
        int islands = 0;
        int rowLength = grid.length, colLength = grid[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (!visited[row][col] && grid[row][col] == '1') {
                    bfsFor8Direction(grid, row, col, visited);
                    islands++;
                }
            }
        }

        return islands;
    }
    // #endregion
}
