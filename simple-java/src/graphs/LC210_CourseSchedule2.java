package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC210_CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            var node = queue.poll();
            list.add(node);

            for (var adjNode : adj.get(node)) {
                inDegree[adjNode]--;

                if (inDegree[adjNode] == 0) {
                    queue.add(adjNode);
                }
            }
        }

        return list.size() == numCourses ? list.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }

    public static void main(String[] args) {
        var courseSchedule = new LC210_CourseSchedule2();
        int[][] prerequisites = { { 1, 0 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 1, 4 } };
        courseSchedule.findOrder(5, prerequisites);
    }
}
