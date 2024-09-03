package array;

import java.util.Scanner;

import util.Matrix;
import util.test.MatrixUtils;

public class SetMatrixToZero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // var matrix = Matrix.in(3, 3, sc);
        var matrix = MatrixUtils.defaultZeroTest();

        start(matrix);

        Matrix.out(matrix);

        sc.close();
    }

    public static void start(int[][] matrix) {
        boolean col0 = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j == 0)
                        col0 = true;
                    else
                        matrix[0][j] = 0;
                }
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0) {
                matrix[i][0] = 0;
            }
        }
    }

}
