package array.backTracking;

import java.util.*;
// Q.40
public class Subsets2_m90 {
  public static List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i <= nums.length; i++) {
      backTrack(ans, new ArrayList<>(), nums, i, 0);
    }
    return ans;
  }

  private static void backTrack(List<List<Integer>> ans, List<Integer> curr, int[] nums, int count, int currIndx) {
    if (curr.size() == count) {
      ans.add(new ArrayList<>(curr));
      return;
    }
    // -10 <= nums[i] <= 10
    int prev = 11;
    for (int i = currIndx; i < nums.length; i++) {
      if (nums[i] != prev) {
        curr.add(nums[i]);
        backTrack(ans, curr, nums, count, i+1);
        curr.remove(curr.size()-1);
        prev = nums[i];
      }
    }
  }

  public static void main(String[] args) {
    int[] a = {1,2,2};
    List<List<Integer>> combo = subsetsWithDup(a);
    for (List<Integer> cb : combo) System.out.println(cb);
  } 
}
