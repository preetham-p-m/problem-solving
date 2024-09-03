package array;

import java.util.Arrays;

import util.Array;

public class NextPermutation {

    public static void main(String[] args) {
        int[] array = new int[] { 2, 1, 5, 4, 3, 0, 0 };

        System.out.println(Arrays.toString(start(array)));
    }

    public static int[] start(int[] array) {
        int lenght = array.length;
        int index = -1;

        for (int i = lenght - 2; i >= 0; i--) {
            if (array[i] < array[i + 1]) {
                index = i;
                break;
            }
        }

        for (int i = lenght - 1; i >= index; i--) {
            if (array[index] < array[i]) {
                Array.swap(array, index, i);
                break;
            }
        }

        Array.reverse(array, index+1, array.length - 1);

        return array;
    }
}
