package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    public class Pair {

        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) {
                queue.add(new Pair(i, 0));
                visited[i][0] = true;
            }

            if (grid[i][m - 1] == 1) {
                queue.add(new Pair(i, m - 1));
                visited[i][m - 1] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1) {
                queue.add(new Pair(0, i));
                visited[0][i] = true;
            }

            if (grid[n - 1][i] == 1) {
                queue.add(new Pair(n - 1, i));
                visited[n - 1][i] = true;
            }
        }

        int[] rowIndex = { 1, 0, -1, 0 };
        int[] colIndex = { 0, 1, 0, -1 };

        while (!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.remove();

            for (int i = 0; i < 4; i++) {
                int effRow = row + rowIndex[i];
                int effCol = col + colIndex[i];

                if (effRow >= 0 && effRow < n && effCol >= 0 && effCol < m && !visited[effRow][effCol]
                        && grid[effRow][effCol] == 1) {
                    queue.add(new Pair(effRow, effCol));
                    visited[effRow][effCol] = true;
                }
            }

        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
