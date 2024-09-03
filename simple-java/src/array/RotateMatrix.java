package array;

import util.Matrix;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        matrix = start(matrix);
        Matrix.out(matrix);
    }

    public static int[][] start(int[][] matrix) {
        matrix = Matrix.transpose(matrix);

        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size / 2; j++) {
                Matrix.swap(matrix, new int[] { i, j }, new int[] { i, size - j - 1 });
            }
        }

        return matrix;
    }

}