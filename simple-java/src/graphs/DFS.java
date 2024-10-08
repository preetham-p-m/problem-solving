package graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS {
    public static void main(String[] args) {
        var V = 5;
        var adj = new ArrayList<ArrayList<Integer>>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(2, 3, 1)),
                        new ArrayList<>(Arrays.asList(0)),
                        new ArrayList<>(Arrays.asList(0, 4)),
                        new ArrayList<>(Arrays.asList(0)),
                        new ArrayList<>(Arrays.asList(2))));

        var dfs = new DFS();
        System.out.println(dfs.dfsOfGraph(V, adj));
    }

    private void dfs(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, ArrayList<Integer> ansList) {
        visited[node] = true;
        ansList.add(node);

        for (Integer adj : adjList.get(node)) {
            if (!visited[adj]) {
                dfs(adj, adjList, visited, ansList);
            }
        }
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ansList = new ArrayList<>();
        dfs(0, adj, visited, ansList);
        return ansList;
    }
}
