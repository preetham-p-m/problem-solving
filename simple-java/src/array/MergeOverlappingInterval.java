package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingInterval {
    public static void main(String[] args) {
        var intervals = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        var result = start(intervals);

        for (int[] is : result) {
            System.out.println(Arrays.toString(is));
        }
    }

    public static int[][] start(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (i, j) -> i[0] - j[0]);

        List<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = intervals[i][1];
            } else {
                result.add(new int[] { start, end });
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        result.add(new int[] { start, end });

        return result.toArray(new int[0][]);
    }
}
