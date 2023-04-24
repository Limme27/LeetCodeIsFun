package dp;

public class CoinChange1_m322 {
  public int coinChange(int[] coins, int amount) {
    int len = coins.length;
    int[][] dp = new int[len][amount+1];
    for (int i = 0; i < len; i++) dp[i][0] = 0;

    for (int r = 0; r < len; r++) {
      for (int c = 1; c <= amount; c++) {
        int diff = c - coins[r];
        if (r == 0) {
          if (diff < 0 || dp[r][diff] == -1) dp[r][c] = -1;
          else dp[r][c] = 1 + dp[r][diff];
        } else {
          if (diff < 0 || dp[r][diff] == -1) dp[r][c] = dp[r-1][c];
          else {
            if (dp[r-1][c] != -1) dp[r][c] = Math.min(dp[r-1][c], 1 + dp[r][diff]);
            else dp[r][c] = 1 + dp[r][diff];
          }  
        }
      }
    }
    return dp[len-1][amount];        
  }
}
