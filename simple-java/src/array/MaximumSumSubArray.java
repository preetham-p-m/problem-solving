package array;

import java.util.Arrays;

import array.helper.MaximumSumSubArrayOutput;

public class MaximumSumSubArray {

    public static void main(String[] args) {
        var ans = run(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
        System.out.println(ans.getSum());
        System.out.println(Arrays.toString(ans.getSumArray()));
    }

    public static MaximumSumSubArrayOutput run(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        int ansStartIndex = 0;
        int ansEndIndex = 0;

        int sum = 0;
        int start = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];

            if (sum > maxSum) {
                maxSum = sum;
                ansStartIndex = start;
                ansEndIndex = i;
            }

            if (sum <= 0) {
                sum = 0;
                start = i + 1;
            }
        }

        int[] ansArray = new int[ansEndIndex - ansStartIndex + 1];

        for (int i = ansStartIndex, j = 0; i <= ansEndIndex; i++, j++) {
            ansArray[j] = array[i];
        }

        return new MaximumSumSubArrayOutput(maxSum, ansArray);
    }
}
