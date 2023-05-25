package array.backTracking;

import java.util.*;
/* 
    1 <= candidates.length <= 30
    2 <= candidates[i] <= 40
    All elements of candidates are distinct.
    Multi use of the same element allowed
*/
public class ComboSum1_m39 {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    backTrack(ans, new ArrayList<>(), candidates, 0, target);
    return ans;
  }
  private void backTrack (List<List<Integer>> ans, List<Integer> curr, int[] candidates, int currLv, int target) {
    if (target < 0) return;
    if (target == 0) {
      ans.add(new ArrayList<>(curr));
      return;
    }  
    for (int i = currLv; i < candidates.length; i++) {
      curr.add(candidates[i]);
      // i keeps the same to allow multi use of the same element
      backTrack(ans, curr, candidates, i , target - candidates[i]);
      int len = curr.size();
      curr.remove(len-1);
    }
  }
}