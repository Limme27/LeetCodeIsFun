package array.backTracking;

import java.util.*;
/*
    1 <= candidates.length <= 100
    1 <= candidates[i] <= 50
    NO multi use of the same element
    Elements with the same value can only be used ONCE
 */
public class ComboSum2_m40 {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    backTrack(ans, new ArrayList<>(), candidates, 0, target);
    return ans;
  }
  
  private void backTrack (List<List<Integer>> ans, List<Integer> curr, int[] candidates, int currIndx, int target) {
    if (target < 0) return;
    if (target == 0) {
      ans.add(new ArrayList<>(curr));
      return;
    }  
    int prev = 0;
    for (int i = currIndx; i < candidates.length; i++) {
      if (candidates[i] != prev) {
        curr.add(candidates[i]);
        backTrack(ans, curr, candidates, i + 1, target - candidates[i]);
        int len = curr.size();
        curr.remove(len-1);
        prev = candidates[i];
      }
    }
  }
}
