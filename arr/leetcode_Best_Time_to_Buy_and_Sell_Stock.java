/*Best Time to Buy and Sell Stock

Say you have an array for which the ith element is the price of a given stock
on day i.

If you were only permitted to complete at most one transaction (ie, buy one and
sell one share of the stock), design an algorithm to find the maximum profit.
*/

class leetcode_Best_Time_to_Buy_and_Sell_Stock {
    public static void main(String[] args) {
        max(new int[] {1,2,4,2,5,7,2,4,9,0,9});
    }
    // O(N)
    public static int max(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int cur_min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] - cur_min > max) {
                max = prices[i] - cur_min;
            }
            if (prices[i] < cur_min) {
                cur_min = prices[i];
            }
        }
        return max;
    }
    // O(N^2) way to slow
    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (prices[i] - prices[j] > max) max = prices[i] - prices[j];
            }
        }
        return max;
    }
}
