package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    class Node {
        int first;
        int second;
        int third;

        public Node(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int N = mat.length, M = mat[0].length;
        boolean[][] visited = new boolean[N][M];
        int[][] result = new int[N][M];

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int[] rowDirection = { -1, 0, 1, 0 };
        int[] columnDirection = { 0, 1, 0, -1 };

        while (!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            int steps = queue.peek().third;

            queue.remove();
            result[row][col] = steps;

            for (int i = 0; i < 4; i++) {
                int effRow = row + rowDirection[i];
                int effCol = col + columnDirection[i];

                if (effRow >= 0 && effRow < N && effCol >= 0 && effCol < M && !visited[effRow][effCol]) {
                    visited[effRow][effCol] = true;
                    queue.add(new Node(effRow, effCol, steps + 1));
                }
            }
        }

        return result;
    }
}
