/**
 * Best Time to Buy and Sell Stock.
 *
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one and
 * sell one share of the stock), design an algorithm to find the maximum profit.
 */

class leetcode_Best_Time_to_Buy_and_Sell_Stock {

  public static void main(String[] args) {
    max(new int[] {1,2,4,2,5,7,2,4,9,0,9});
  }

  public static int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int cur_min = prices[0];
    int max = 0;
    for (int i = 1; i < prices.length; ++i) {
      max = Math.max(prices[i] - cur_min, max);
      cur_min = Math.min(cur_min, prices[i]);
    }
    return max;
  }
}

/* Python Version
def maxProfit(self, prices):
    if not prices:
        return 0
    local_min = prices[0]
    ret = 0

    for idx in xrange(1, len(prices)):
        if prices[idx] < local_min:
            local_min = prices[idx]
        elif prices[idx] > local_min:
            ret = max(ret, prices[idx] - local_min)
        else:
            pass
    return ret
*/
