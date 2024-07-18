import java.util.*;

class Program {
  // O(nk) time | O(n) space - n is the number of the prices, and k is the input
  // k.
  public static int maxProfitWithKTransactions(int[] prices, int k) {
    if (prices.length == 0)
      return 0;

    int[] evenProfitsRow = new int[prices.length];
    int[] oddProfitsRow = new int[prices.length];
    for (int t = 1; t < k + 1; t++) {
      int maxProfit = Integer.MIN_VALUE;
      int[] current = t % 2 == 1 ? oddProfitsRow : evenProfitsRow;
      int[] prev = t % 2 == 1 ? evenProfitsRow : oddProfitsRow;
      for (int d = 1; d < current.length; d++) {
        maxProfit = Math.max(maxProfit, prev[d - 1] - prices[d - 1]);
        current[d] = Math.max(current[d - 1], maxProfit + prices[d]);
      }
    }

    return k % 2 == 0 ? evenProfitsRow[prices.length - 1] : oddProfitsRow[prices.length - 1];
  }

  // O(nk) time | O(nk) space - n is the number of the prices, and k is the input
  // k.
  // public static int maxProfitWithKTransactions(int[] prices, int k) {
  // if (prices.length == 0)
  // return 0;

  // int[][] maxProfits = new int[k + 1][prices.length];
  // for (int t = 1; t < maxProfits.length; t++) {
  // int maxProfit = Integer.MIN_VALUE;
  // for (int d = 1; d < prices.length; d++) {
  // maxProfit = Math.max(maxProfit, maxProfits[t - 1][d - 1] - prices[d - 1]);
  // maxProfits[t][d] = Math.max(maxProfits[t][d - 1], prices[d] + maxProfit);
  // }
  // }

  // return maxProfits[k][prices.length - 1];
  // }
}
