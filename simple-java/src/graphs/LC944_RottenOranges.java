package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class LC944_RottenOranges {

    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private int[] rows = new int[] { 0, 0, -1, 1 };
    private int[] columns = new int[] { -1, 1, 0, 0 };

    public int orangesRotting(int[][] grid) {
        int time = -1, fresh = 0;
        int n = grid.length, m = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
            }
        }

        if (fresh == 0 && queue.isEmpty()) {
            return 0;
        }

        while (!queue.isEmpty()) {
            time += 1;
            int currentQueueSize = queue.size();

            for (int i = 0; i < currentQueueSize; i++) {
                var pair = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int effRow = pair.first + rows[j];
                    int effCol = pair.second + columns[j];

                    if (effRow >= 0 && effRow < n && effCol >= 0 && effCol < m && grid[effRow][effCol] == 1) {
                        grid[effRow][effCol] = 2;
                        fresh -= 1;
                        queue.add(new Pair(effRow, effCol));
                    }
                }
            }
        }

        return fresh > 0 ? -1 : time;
    }

}
