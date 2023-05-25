package array.backTracking;

import java.util.*;

public class NonDecreasingSubseque_m491 {
  public static List<List<Integer>> findSubsequences(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    backTrack(ans, new HashSet<>(), new ArrayList<>(), nums, 0);
    return ans;
  }
  private static void backTrack(List<List<Integer>> ans, Set<Integer> set, List<Integer> curr, int[] nums, int currLv) {
    if (curr.size() > 1) {
      if (curr.get(curr.size()-1) < curr.get(curr.size()-2)) return;
      ans.add(new ArrayList<>(curr));
    }
    for (int i = currLv; i < nums.length; i++) {
      if (!set.contains(nums[i])) {
        curr.add(nums[i]);
        backTrack(ans, new HashSet<>(), curr, nums, i+1);
        curr.remove(curr.size()-1);
        set.add(nums[i]);
      }
    }
  }
  public static void main(String[] args) {
    int[] a = {4,6,7,7};
    //int[] b = {1,2,3,1,1};
    List<List<Integer>> combo = findSubsequences(a);
    for (List<Integer> cb : combo) System.out.println(cb);
  } 
}
