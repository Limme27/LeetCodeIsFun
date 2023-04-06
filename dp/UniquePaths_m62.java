package dp;

public class UniquePaths_m62 {
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) dp[i][0] = 1;
    for (int i = 0; i < n; i++) dp[0][i] = 1;

    for (int r = 1; r < m; r++) {
      for (int c = 1; c < n; c++) dp[r][c] = dp[r-1][c] + dp[r][c-1];
    }
    return dp[m-1][n-1]; 
  }
}
