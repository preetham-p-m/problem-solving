package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows to be print: ");
        int numberOfRows = sc.nextInt();

        var ans = start(numberOfRows);

        System.out.println(ans.toString());
        sc.close();
    }

    public  static List<List<Integer>> start(int numberOfRows) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 1; i <= numberOfRows; i++) {
            list.add(getRow(i));
        }

        return list;
    }

    public static List<Integer> getRow(int row) {
        List<Integer> ansRow = new ArrayList<>();

        int temp = 1;
        ansRow.add(temp);

        for (int col = 1; col < row; col++) {
            temp = temp * (row - col);
            temp = temp / col;
            ansRow.add(temp);
        }

        return ansRow;
    }
}
