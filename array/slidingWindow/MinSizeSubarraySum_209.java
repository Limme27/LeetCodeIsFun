package array.slidingWindow;

public class MinSizeSubarraySum_209 {
  public int minSubArrayLen(int target, int[] nums) {
    int minLen = Integer.MAX_VALUE;
    int window = 0;
    int r = 0;
    for (int l = 0; l < nums.length; l++) {
      while (r < nums.length && window + nums[r] < target) {
        window += nums[r];
        r++;
      }
      if (r < nums.length) minLen = Math.min(minLen, r - l + 1);
      if (minLen == 1) return minLen;
      window -= nums[l];
    }
    if (minLen == Integer.MAX_VALUE) return 0;
    else return minLen;
  }
}
