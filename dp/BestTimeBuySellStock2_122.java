package dp;

public class BestTimeBuySellStock2_122 {
  public int maxProfit(int[] prices) {
    int len = prices.length;
    int[] dp = new int[len];

    dp[0] = 0;
    for (int i = 1; i < dp.length; i++) {
      if (prices[i] > prices[i-1]) dp[i] = dp[i-1] + prices[i] - prices[i-1];
      else dp[i] = dp[i-1];
    }

    return dp[len-1];
  }
}
