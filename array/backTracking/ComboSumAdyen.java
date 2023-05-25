package array.backTracking;

import java.util.*;
/*
    NO multi use of the same element
    Duplicate combos allowed if made by diff elements
 */

public class ComboSumAdyen {
  public static List<List<Integer>> getCombos(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    backTrack(ans, new ArrayList<>(), candidates, 0, target);
    return ans;
  }

  private static void backTrack(List<List<Integer>> ans, List<Integer> curr, int[] candidates, int currIndx, int target) {
    if (target < 0) return;
    if (target == 0) {
      ans.add(new ArrayList<>(curr));
      return;
    }
    for (int i = currIndx; i < candidates.length; i++) {
      curr.add(candidates[i]);
      backTrack(ans, curr, candidates, i+1, target-candidates[i]);
      curr.remove(curr.size()-1);
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5};
    int[] b = {2, 2, 5, 1, 2};
    List<List<Integer>> combo = getCombos(a, 6);
    List<List<Integer>> combo1 = getCombos(b, 5);
    for (List<Integer> cb : combo) System.out.println(cb);
    for (List<Integer> cb : combo1) System.out.println(cb);
  }
}

