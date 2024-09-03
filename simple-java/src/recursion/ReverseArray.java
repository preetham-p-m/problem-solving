package recursion;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 3, 4, 5, 6 };
        start(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void start(int[] array, int start, int end) {
        if (start < end) {
            swap(array, start, end);
            start(array, start + 1, end - 1);
        }
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
