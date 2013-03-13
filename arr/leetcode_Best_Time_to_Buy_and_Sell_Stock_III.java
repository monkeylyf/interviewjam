/*Best Time to Buy and Sell Stock III

Say you have an array for which the ith element is the price of a given stock
on day i.
Design an algorithm to find the maximum profit. You may complete at most two
transactions.
Note:
You may not engage in multiple transactions at the same time (ie, you must sell
the stock before you buy again).
*/

import java.util.ArrayList;


class Best_Time_to_Buy_and_Sell_Stock_III {
    public static void main(String[] args) {
        maxProfit(new int[] {1,2,4,2,5,7,2,4,9,0});
    }
    public static int maxProfit(int[] prices) {
        if (prices.length ==0) {
            return 0;
        }
        int retval = 0;
        int[] premax = new int[prices.length];
        int[] postmax = new int[prices.length];
        //premax[0] = 0;
        //postmax[prices.length - 1] = 0;
        int low = prices[0];
        int high = prices[prices.length - 1];
        for (int m = 1; m < prices.length; m++) {
            premax[m] = Math.max(premax[m - 1], prices[m] - low);
            low = Math.min(low, prices[m]);
        }
        for (int n = prices.length - 2; n >= 0; n--) {
            postmax[n] = Math.max(postmax[n + 1], high - prices[n]);
            high = Math.max(high, prices[n]);
        }
        print(premax);
        print(postmax);
        for (int j = 1; j < prices.length; j++) {
            retval = Math.max(retval, (premax[j] + postmax[j]));
        }
        return retval;
    }
    public static void print(int[] A) {
        for (int i : A) System.out.print(i + " ");
        System.out.println();
    }
}
