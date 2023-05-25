package array.backTracking;

import java.util.*;
/*
 */
public class ComboSum3_m216 {
  public static List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    backTrack(ans, new ArrayList<>(), 1, k, n);
    return ans;
  }
  
  private static void backTrack (List<List<Integer>> ans, List<Integer> curr, int currNum, int count, int target) {
    if (target < 0 || count < 0) return;
    if (target == 0 && count == 0) {
      ans.add(new ArrayList<>(curr));
      return;
    }
    for (int i = currNum; i < 10; i++) {
      curr.add(i);
      backTrack(ans, curr, i+1, count-1, target-i);
      curr.remove(curr.size()-1);
    }    
  }
  public static void main(String[] args) {
    List<List<Integer>> combo = combinationSum3(3, 9);
    for (List<Integer> cb : combo) System.out.println(cb);
  }
}
