package array.prefixSum;

import java.util.Arrays;

public class FindPivotIndex_724_1991 {
  public int pivotIndex(int[] nums) {
    int sumR = Arrays.stream(nums).sum();
    int sumL = 0;
    for (int i = 0; i < nums.length; i++) {
      sumR -= nums[i];
      if (sumL == sumR) return i;
      sumL += nums[i];
    }
    return -1;
  }
}
