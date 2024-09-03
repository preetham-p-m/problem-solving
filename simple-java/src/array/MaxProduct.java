package array;

public class MaxProduct {
    public static void main(String[] args) {

        int[] array = new int[] { 1, 2, 3, 4, 5, 5, 7, 8 };

        var ans = maxProduct(array);

        System.out.println(ans);

    }

    public static int maxProduct(int[] array) {
        int n = array.length;
        int ans = Integer.MIN_VALUE;

        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < n; i++) {
            if (suffix == 0) {
                suffix = 1;
            }

            if (prefix == 0) {
                prefix = 1;
            }

            prefix = prefix * array[i];
            suffix = suffix * array[n - 1 - i];

            ans = Math.max(ans, Math.max(prefix, suffix));
        }

        return ans;
    }
}
