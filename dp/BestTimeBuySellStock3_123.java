package dp;

public class BestTimeBuySellStock3_123 {
  public int maxProfit(int[] prices) {
    int numTransaction = 2;
    int len = prices.length;
    if (len < 2) return 0;

		int[][] dp = new int[numTransaction + 1][len];
		for (int j = 0; j < len; j++) dp[0][j] = 0;
    for (int i = 0; i <= numTransaction; i++) dp[i][0] = 0;

    for (int i = 1; i <= numTransaction; i++) {
			int maxDiffBtwPrevTransProfitNPrevDayCost = Integer.MIN_VALUE;
      for (int j = 1; j < len; j++) {
        maxDiffBtwPrevTransProfitNPrevDayCost = Math.max(maxDiffBtwPrevTransProfitNPrevDayCost, dp[i-1][j-1] - prices[j-1]);
        dp[i][j] = Math.max(maxDiffBtwPrevTransProfitNPrevDayCost + prices[j], dp[i][j-1]);
			}
		}
    return dp[numTransaction][len-1];
  }
}