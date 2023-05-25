package array.backTracking;

import java.util.*;

public class Subsets1_m78 {
  public static List<List<Integer>> subsets(int[] nums) {
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
    for (int i = currIndx; i < nums.length; i++) {
      curr.add(nums[i]);
      backTrack(ans, curr, nums, count, i+1);
      curr.remove(curr.size()-1);
    }
  }

  public static void main(String[] args) {
    int[] a = {1,2,3};
    List<List<Integer>> combo = subsets(a);
    for (List<Integer> cb : combo) System.out.println(cb);
  } 
}
