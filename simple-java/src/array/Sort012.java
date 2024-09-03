package array;

import java.util.Arrays;

import util.Array;

public class Sort012 {

    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 0, 2, 1, 2, 0, 1, 2 };
        start(array);

        System.out.println(Arrays.toString(array));
    }

    public static void start(int[] array) {
        int low = 0;
        int mid = 0;
        int high = array.length - 1;

        while (mid <= high) {
            switch (array[mid]) {
                case 0:
                    Array.swap(array, mid++, low++);
                    break;

                case 1:
                    mid++;
                    break;

                default:
                    Array.swap(array, mid, high--);
                    break;
            }
        }
    }
}
