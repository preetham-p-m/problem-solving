package array;

public class FindIn2DMatrix {

    public static void main(String[] args) {
        int[][] array = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 5;

        boolean found = start(array, target);
        System.out.println("Target " + target + " found: " + found);

        boolean foundBinary = startBinary(array, target);
        System.out.println("Target " + target + " found with Binary Search Approach: " + foundBinary);
    }

    public static boolean start(int[][] array, int target) {
        int rows = 0;
        int cols = array[0].length - 1;

        while (rows < array.length && cols >= 0) {
            if (array[rows][cols] == target) {
                return true;
            } else if (array[rows][cols] < target) {
                rows++;
            } else {
                cols--;
            }
        }

        return false;
    }

    public static boolean startBinary(int[][] array, int target) {
        int rows = array.length;
        int cols = array[0].length;

        int start = 0;
        int end = rows * cols - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (array[mid / cols][mid % cols] == target) {
                return true;
            } else if (array[mid / cols][mid % cols] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}
