package array;

import java.util.ArrayList;
import java.util.List;

public class PrintArrayInSpiral {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }
        };

        var list = start(matrix);

        System.out.println(list.toString());
    }

    public static List<Integer> start(int[][] matrix) {
        var list = new ArrayList<Integer>();

        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int top = 0;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        return list;
    }
}
