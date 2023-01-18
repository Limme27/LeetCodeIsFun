package dp;

public class MaxProductSubarray_152 {
  public int maxProduct(int[] nums) {
    int len = nums.length;
    int[] dp = new int[len];
    
    dp[0] = nums[0];
    int max = dp[0];  
    for (int i = 1; i < len; i++) {
      if ((dp[i-1] < 0 && nums[i] < 0) || (dp[i-1] > 0 && nums[i] > 0)) dp[i] = dp[i-1] * nums[i];
      else if (nums[i] == 0 || dp[i-1] == 0) dp[i] = nums[i];
      else {
        boolean isNeg = false;
        int j = i + 1;
        while (j < len) {
          if (nums[j] < 0) {
            isNeg = true;
            break;
          }
          j++;
        }
        if (isNeg) dp[i] = dp[i-1] * nums[i];
        else dp[i] = nums[i];
      }
      max = Math.max(max, dp[i]);
    }
    
    dp[len-1] = nums[len-1];
    for (int i = len - 2; i >= 0; i--) {
      if ((dp[i+1] < 0 && nums[i] < 0) || (dp[i+1] > 0 && nums[i] > 0)) dp[i] = dp[i+1] * nums[i];
      else if (nums[i] == 0 || dp[i+1] == 0) dp[i] = nums[i];
      else {
        boolean isNeg = false;
        int j = i - 1;
        while (j >= 0) {
          if (nums[j] < 0) {
            isNeg = true;
            break;
          }
          j--;
        }
        if (isNeg) dp[i] = dp[i+1] * nums[i];
        else dp[i] = nums[i];
      }
      max = Math.max(max, dp[i]);
    }
    
    return max;
  }
  
  public static void main(String[] args) {
    MaxProductSubarray_152 m = new MaxProductSubarray_152();
    int[] a = {-1,-2,-3,0};
    System.out.println(m.maxProduct(a));
  }
}