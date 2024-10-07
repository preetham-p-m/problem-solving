package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(0);

        while (!queue.isEmpty()) {
            var node = queue.poll();
            bfs.add(node);

            for (Integer it : adj.get(node)) {
                if (visited[it] == false) {
                    visited[it] = true;
                    queue.add(it);
                }
            }
        }

        return bfs;
    }
}
