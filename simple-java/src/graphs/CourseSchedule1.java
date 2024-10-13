package graphs;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule1 {

    boolean cycleUsingDFS(int node, List<List<Integer>> adjList, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int adj : adjList.get(node)) {
            if (!visited[adj]) {
                if (cycleUsingDFS(adj, adjList, visited, recStack)) {
                    return true;
                }
            } else if (recStack[adj]) {
                return true;
            }
        }

        recStack[node] = false;

        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (cycleUsingDFS(i, adjList, visited, recStack)) {
                    return false;
                }
            }
        }

        return true;
    }
}
