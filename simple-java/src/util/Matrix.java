package util;

import java.util.Scanner;

public class Matrix {

    public static int[][] in(int row, int column, Scanner scanner) {
        int[][] matrix = new int[row][column];

        System.out.println("Matrix Input: ");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    public static void out(int[][] matrix) {
        System.out.println("Matrix Output: ");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    public static void swap(int[][] matrix, int[] source, int[] destination) {
        int temp = matrix[source[0]][source[1]];
        matrix[source[0]][source[1]] = matrix[destination[0]][destination[1]];
        matrix[destination[0]][destination[1]] = temp;
    }
}
