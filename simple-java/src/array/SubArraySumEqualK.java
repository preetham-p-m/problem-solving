package array;

import java.util.*;

public class SubArraySumEqualK {
    public static void main(String[] args) {
        var nums = new int[] { 1, 1, 1 };
        var result = start(nums, 2);

        System.out.println(result);
    }

    public static int start(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);

        int prefixSum = 0;

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            count += map.getOrDefault(prefixSum - k, 0);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
