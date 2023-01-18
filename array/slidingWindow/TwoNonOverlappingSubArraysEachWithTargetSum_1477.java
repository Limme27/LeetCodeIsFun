package array.slidingWindow;

public class TwoNonOverlappingSubArraysEachWithTargetSum_1477 {
  public int minSumOfLengths(int[] arr, int target) {
    int dp[] = new int[arr.length];
    
    int sum = 0;
    int l = 0;
    int ans = Integer.MAX_VALUE;
    int minLenOfOneOkSubarry = Integer.MAX_VALUE;
    for(int r = 0; r < arr.length; r++){
      sum += arr[r];
      while(sum > target) {
        sum -= arr[l];
        l++;
      }
      if(sum == target) {
        int lenOfCurrOkSubary = r - l + 1;
        if(l > 0 && dp[l - 1] != Integer.MAX_VALUE){
          ans = Math.min(ans, dp[l - 1] + lenOfCurrOkSubary);
        }
        minLenOfOneOkSubarry = Math.min(minLenOfOneOkSubarry, lenOfCurrOkSubary);
      }
      dp[r] = minLenOfOneOkSubarry;
    }
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }  

  public static void main(String[] args) {
    TwoNonOverlappingSubArraysEachWithTargetSum_1477 t = new TwoNonOverlappingSubArraysEachWithTargetSum_1477();
    int[] a = {1,1,2,2,2};
    // int[] b = {2,1,3,3,2,3,1};
    // int[] c = {4,3,2,6,2,3,4};

    System.out.println(t.minSumOfLengths(a, 4));
    // System.out.println(t.minSumOfLengths(b, 6));
    // System.out.println(t.minSumOfLengths(c, 6));
  }
}
