package array.backTracking;

/*
    1 <= candidates.length <= 200
    1 <= candidates[i] <= 1000
    All elements of candidates are distinct.
    Multi use of the same element allowed
    CAUTION: TLE (nums = [2,1,3], target = 35) as "1 <= target <= 1000"
*/
// 39 -> 377
public class ComboSum4TLE_m377 {
  private static int ans;
  public static int combinationSum4(int[] nums, int target) {
    ans = 0;
    backTrack(0, nums, target);
    return ans;
  }
  private static void backTrack (int sum, int[] candidates, int target) {
    if (sum > target) return;
    if (sum == target) {
      ans++;
      return;
    }  
    for (int i = 0; i < candidates.length; i++) backTrack(sum + candidates[i], candidates, target);
  }
  public static void main(String[] args) {
    int[] a = {1,2,3};
    System.out.println(combinationSum4(a, 4));
    int[] b = {9};
    System.out.println(combinationSum4(b, 3));
    // int[] c = {2,1,3};
    // System.out.println(combinationSum4(c, 35));
  }
}
