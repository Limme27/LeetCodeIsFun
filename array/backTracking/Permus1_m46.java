package array.backTracking;

import java.util.*;
// nums[i] distinct
public class Permus1_m46 {
  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    backTrack(ans, new ArrayList<>(), nums);
    return ans;
  }
  private static void backTrack (List<List<Integer>> ans, List<Integer> curr, int[] nums) {
    if (curr.size() == nums.length) {
      ans.add(new ArrayList<>(curr));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (!curr.contains(nums[i])) {
        curr.add(nums[i]);
        backTrack(ans, curr, nums);
        curr.remove(curr.size()-1);
      }
    }
  }
  public static void main(String[] args) {
    int[] a = {1,2,3};
    List<List<Integer>> combo = permute(a);
    for (List<Integer> cb : combo) System.out.println(cb);
  }
}
