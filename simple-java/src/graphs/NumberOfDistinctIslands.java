package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands {

    private int[] rows = { 1, 0, -1, 0 };
    private int[] cols = { 0, 1, 0, -1 };

    private void dfs(int row, int col, int[][] grid, boolean[][] visited, int row0, int col0, List<String> list) {
        visited[row][col] = true;
        list.add(returnString((row - row0), (col - col0)));
        for (int i = 0; i < 4; i++) {
            int effRow = row + rows[i];
            int effCol = col + cols[i];

            if (effRow >= 0 && effRow < grid.length && effCol >= 0 && effCol < grid[0].length
                    && !visited[effRow][effCol] && grid[effRow][effCol] == 1) {
                dfs(effRow, effCol, grid, visited, row0, col0, list);
            }
        }

    }

    private String returnString(int r, int c) {
        return r + " " + c;
    }

    public int countDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Set<List<String>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    var list = new ArrayList<String>();
                    dfs(i, j, grid, visited, i, j, list);
                    set.add(list);
                }
            }
        }

        return set.size();
    }
}
