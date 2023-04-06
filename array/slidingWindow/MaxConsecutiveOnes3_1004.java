package array.slidingWindow;

// 1004 -> 2024 -> 424
public class MaxConsecutiveOnes3_1004 {
  public int longestOnes(int[] nums, int k) {
    int window = 0;
    int numFlipLeft = k;
    int r = 0;
    int maxLen = 0;
    for (int l = 0; l < nums.length; l++) { 
      while (r < nums.length && (nums[r] == 1 || nums[r] == 0 && numFlipLeft > 0)) {
        if (nums[r] == 0) numFlipLeft--;
        window++;
        r++;
      }
      maxLen = Math.max(maxLen, window);
      if (nums[l] == 0) numFlipLeft++;
      window--;
    }
    return maxLen;
  }
}