package array;

import java.util.Arrays;

public class Merge2SortedArray {

    public static void main(String[] args) throws Exception {
      int[] arr1 = new int[] { 1, 4, 5, 8, 0, 0, 0, 0 };
      int[] arr2 = new int[] { 2, 3, 6, 7 };

      run(arr1, 4, arr2, arr2.length);

      System.out.println(Arrays.toString(arr1));

    }

    public static void run(int[] nums1, int m, int[] nums2, int n) {
      int left = m - 1;
      int right = n - 1;
      int index = m + n - 1;

      while (index >= 0 && left >= 0 && right >= 0) {
        if (nums1[left] > nums2[right]) {
          nums1[index--] = nums1[left--];
        } else {
          nums1[index--] = nums2[right--];
        }
      }

      while (right >= 0 && index >= 0) {
        nums1[index--] = nums2[right--];
      }
    }
}
