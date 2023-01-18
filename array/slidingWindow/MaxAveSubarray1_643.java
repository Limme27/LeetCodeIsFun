package array.slidingWindow;

public class MaxAveSubarray1_643 {
  public double findMaxAverage(int[] nums, int k) {    
    double sum = nums[0];
    for (int i = 1; i < k; i++) {
      sum += nums[i];
    }
    double sumMax = sum;
    for (int i = k; i < nums.length; i++) {
      sum = sum + nums[i] - nums[i-k];
      if (sum > sumMax) sumMax = sum;
    }
    return sumMax / k;
  }  
}
