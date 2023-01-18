package dp;

public class PerfectSquares_279 {
  public int numSquares(int n) {
    int numRow = (int)Math.sqrt((double)n);
    int[][] dp = new int[numRow][n];
    for (int i = 0; i < n; i++) dp[0][i] = i+1;

    for (int i = 1; i < numRow; i++) {
      for (int j = 0; j < n; j++) {
        if (j+1 < (i+1)*(i+1)) dp[i][j] = dp[i-1][j];
        else if (j+1 == (i+1)*(i+1)) dp[i][j] = 1;
        else {
          int a = (j+1) / ((i+1)*(i+1));
          int b = (j+1) % ((i+1)*(i+1));
          if (b == 0) dp[i][j] = Math.min(dp[i-1][j], a);
          else dp[i][j] = Math.min(dp[i-1][j], a + dp[i-1][b-1]);
        }
      }
    }
    return dp[numRow-1][n-1];
  }
}
