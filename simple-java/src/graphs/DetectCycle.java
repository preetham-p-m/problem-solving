package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycle {

    public class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // #region Using BFS

    boolean cycleUsingBFS(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(node, -1));

        while (!queue.isEmpty()) {
            int currentNode = queue.peek().first;
            int parentNode = queue.peek().second;
            queue.remove();

            for (int adjNode : adj.get(currentNode)) {
                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    queue.add(new Pair(adjNode, currentNode));
                } else if (parentNode != adjNode) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isCycleUsingBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (cycleUsingBFS(i, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    // #endregion

    // #region Using DFS

    private boolean cycleUsingDFS(int node, int parentNode, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        for (Integer adjNode : adj.get(node)) {
            if (!visited[adjNode]) {
                if (cycleUsingDFS(adjNode, node, adj, visited)) {
                    return true;
                }
            } else if (adjNode != parentNode) {
                return true;
            }
        }

        return false;
    }

    public boolean isCycleUsingDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (cycleUsingDFS(i, -1, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    // #endregion
}
