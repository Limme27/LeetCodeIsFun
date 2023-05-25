package array.backTracking;

import java.util.*;

public class Combos_m77 {
  public static List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> ans = new ArrayList<>();
    backTrack(ans, new ArrayList<>(), n, 1, k);
    return ans;        
  }

  private static void backTrack(List<List<Integer>> ans, List<Integer> curr, int n, int currLv, int k) {
    if (curr.size() == k) {
      ans.add(new ArrayList<>(curr));
      return;
    }
    for (int i = currLv; i <= n; i++) {
      curr.add(i);
      backTrack(ans, curr, n, i+1, k);
      curr.remove(curr.size()-1);
    }
  }
  
  public static void main(String[] args) {
    List<List<Integer>> combo = combine(4, 2);
    for (List<Integer> cb : combo) System.out.println(cb);
  }
}