package array;

public class Stocks {
    public static void main(String[] args) {
        int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
        System.out.println(start(prices));
    }

    public static int start(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                int profit = prices[i] - min;

                if (profit > maxProfit)
                    maxProfit = profit;
            }
        }

        return maxProfit;
    }
}