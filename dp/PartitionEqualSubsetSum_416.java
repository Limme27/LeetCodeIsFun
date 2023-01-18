package dp;

import java.util.Arrays;

public class PartitionEqualSubsetSum_416 {
  public boolean canPartition(int[] nums) {
    int len = nums.length;
    int sum = Arrays.stream(nums).sum();
    if (sum % 2 == 1) return false;
    
    Arrays.sort(nums);
    int target = sum / 2;
    boolean[][] dp = new boolean[len][target + 1];
    for (int i = 0; i < len; i++) dp[i][0] = true;
    for (int j = 1; j <= target; j++) {
      if (j == nums[0]) dp[0][j] = true;
      else dp[0][j] = false; 
    }
    // O(10^6)
    for (int i = 1; i < len; i++) { //  n = 10^2
      for (int j = 1; j <= target; j++) { //  target = 10^2 * 10^2 = 10^4
        if (nums[i] > j) dp[i][j] = dp[i-1][j];
        else dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
      }
    }
    return dp[len-1][target];
  }
}
