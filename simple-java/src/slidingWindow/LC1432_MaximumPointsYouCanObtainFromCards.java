package slidingWindow;

public class LC1432_MaximumPointsYouCanObtainFromCards {
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int window = n - k;

        int temp = 0;
        for (int i = 0; i < window; i++) {
            temp += cardPoints[i];
        }

        int minSum = temp;
        int total = temp;

        for (int i = window; i < n; i++) {
            temp = temp - cardPoints[i - window] + cardPoints[i];
            minSum = Math.min(minSum, temp);
            total += cardPoints[i];
        }

        return total - minSum;
    }

    public static void main(String[] args) {
        System.out.println(maxScore(new int[] { 96, 90, 41, 82, 39, 74, 64, 50, 30 }, 8));
    }
}
