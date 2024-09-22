package recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        var ans = start(4);

        System.out.println(ans.toString());

    }

    public static List<List<String>> start(int n) {
        var ans = new ArrayList<List<String>>();
        var board = new ArrayList<StringBuilder>();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append('.');
        }
        String stringToFill = builder.toString();
        for (int i = 0; i < n; i++) {
            board.add(new StringBuilder(stringToFill));
        }

        boolean[] left = new boolean[n];
        boolean[] leftUpper = new boolean[2 * n - 1];
        boolean[] leftLower = new boolean[2 * n - 1];

        calculatePossibility(n, ans, 0, board, left, leftUpper, leftLower);

        return ans;
    }

    public static void calculatePossibility(int n, List<List<String>> ansList, int col, List<StringBuilder> board,
            boolean[] left,
            boolean[] leftUpper, boolean[] leftLower) {
        if (col >= n) {
            List<String> temp = new ArrayList<>();
            for (var stringBuilder : board) {
                temp.add(stringBuilder.toString());
            }
            ansList.add(temp);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (!left[row] && !leftLower[row + col] && !leftUpper[col + n - 1 - row]) {
                var builder = board.get(row);

                builder.setCharAt(col, 'Q');
                left[row] = leftLower[row + col] = leftUpper[col + n - 1 - row] = true;
                calculatePossibility(n, ansList, col + 1, board, left, leftUpper, leftLower);
                left[row] = leftLower[row + col] = leftUpper[col + n - 1 - row] = false;
                builder.setCharAt(col, '.');
            }
        }
    }
}
