package array.backTracking;

import java.util.*;
// nums[i] w/ duplicates
public class Permus2_m47 {
  public static List<List<Integer>> permute(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    int[] visited = new int[nums.length];
    backTrack(ans, new ArrayList<>(), nums, visited);
    return ans;
  }
  
  private static void backTrack (List<List<Integer>> ans, List<Integer> curr, int[] nums, int[] visited) {
    if (curr.size() == nums.length) {
      ans.add(new ArrayList<>(curr));
      return;
    }
    // -10 <= nums[i] <= 10
    int prev = 11;
    for (int i = 0; i < nums.length; i++) {
      // ensure same nums[i] won't be added twice in one iteration && only ONE value (different nums[i] w/ the same value) will be added per index
      if (visited[i] != 1 && nums[i] != prev) {
        curr.add(nums[i]);
        visited[i] = 1;
        backTrack(ans, curr, nums, visited);
        curr.remove(curr.size()-1);
        visited[i] = 0;
        prev = nums[i];
      }
    }
  }
  public static void main(String[] args) {
    int[] a = {1,1,1,2,2,2};
    List<List<Integer>> combo = permute(a);
    for (List<Integer> cb : combo) System.out.println(cb);
  }
}
