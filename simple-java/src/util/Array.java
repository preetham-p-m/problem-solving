package util;

public class Array {
    private Array() {
    }

    // #region sway array elements
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    // #endregion

    // #region reverse array
    public static void reverse(int[] array) {
        reverse(array, 0, array.length);
    }

    public static void reverse(int[] array, int startIndex, int endIndex) {
        for (int i = startIndex; i < (startIndex + endIndex) / 2; i++) {
            swap(array, i, endIndex + startIndex - i);
        }
    }
    // #endregion
}
