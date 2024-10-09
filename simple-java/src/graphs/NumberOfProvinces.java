package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {

    private void bfs(int[][] isConnected, boolean[] visited, int startPoint) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startPoint);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            visited[currentNode] = true;

            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[currentNode][i] == 1 && !visited[i]) {
                    queue.add(i);
                }
            }
        }
    }

    public int findCircleNumUsingBFS(int[][] isConnected) {
        int n = isConnected.length;

        int provinces = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(isConnected, visited, i);
                provinces++;
            }
        }

        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int currentNode) {
        visited[currentNode] = true;

        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[currentNode][i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i);
            }
        }
    }

    public int findCircleNumUsingDFS(int[][] isConnected) {
        int n = isConnected.length;

        int provinces = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++;
            }
        }

        return provinces;
    }
}
