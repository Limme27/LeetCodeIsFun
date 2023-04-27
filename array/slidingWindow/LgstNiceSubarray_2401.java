package array.slidingWindow;

public class LgstNiceSubarray_2401 {
  public int longestNiceSubarray(int[] nums) {
    int temp = 0;
    int r = 0;
    int maxLen = 0;
    for (int l = 0; l < nums.length; l++) { 
      while (r < nums.length && (temp & nums[r]) == 0) {
        temp += nums[r];
        r++;
      }
      maxLen = Math.max(maxLen, r - l);
      temp -= nums[l];
    }
    return maxLen;
  }
}
