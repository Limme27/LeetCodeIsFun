package array.backTracking;

import java.util.*;
/*
    1 <= nums.length <= 100
    1 <= nums[i] <= 50
    NO multi use of the same element
    NO duplicate combos even made by diff element
*/
public class ComboSum2_m40 {
  public static List<List<Integer>> combinationSum2(int[] nums, int target) {
    // sort and prev eliminate duplicate combos
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    backTrack(ans, new ArrayList<>(), nums, 0, target);
    return ans;
  }
  
  private static void backTrack (List<List<Integer>> ans, List<Integer> curr, int[] nums, int currLv, int target) {
    if (target < 0) return;
    if (target == 0) {
      ans.add(new ArrayList<>(curr));
      return;
    }  
    int prev = 0;
    for (int i = currLv; i < nums.length; i++) {
      if (nums[i] != prev) {
        curr.add(nums[i]);
        backTrack(ans, curr, nums, i+1, target-nums[i]);
        curr.remove(curr.size()-1);
        prev = nums[i];
      }
    }
  }
  public static void main(String[] args) {
    int[] a = {2,5,2,1,2};
    List<List<Integer>> combo = combinationSum2(a, 5);
    for (List<Integer> cb : combo) System.out.println(cb);
  }
}
