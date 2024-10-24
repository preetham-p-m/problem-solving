package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class LC785_IsGraphBipartite {

    private boolean checkIsBipartite(int[][] graph, int[] bipartite, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        bipartite[start] = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i : graph[node]) {
                if (bipartite[i] == 0) {
                    bipartite[i] = 3 - bipartite[node];
                    queue.add(i);
                } else if (bipartite[i] == bipartite[node]) {
                    return false;
                }
            }

        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        int[] bipartite = new int[N];

        for (int i = 0; i < N; i++) {
            if (bipartite[i] == 0) {
                if (!checkIsBipartite(graph, bipartite, i)) {
                    return false;
                }
            }
        }

        return true;
    }
}
