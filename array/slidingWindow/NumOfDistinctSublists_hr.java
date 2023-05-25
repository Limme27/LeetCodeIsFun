package array.slidingWindow;

import java.util.*;

public class NumOfDistinctSublists_hr {
  public static int countDistinctSublists(List<Integer> list) {
    Set<Integer> set = new HashSet<>(list);
    Map<Integer, Integer> map = new HashMap<>();
    int ans = 0;
    int l = 0;
    int r = 0;
    while (r < list.size()) {
      int curr = list.get(r);
      map.put(curr, map.getOrDefault(curr, 0) + 1);
      while (set.size() == map.size()) {
        ans += list.size() - r;
        int removed = list.get(l);
        map.put(removed, map.get(removed) - 1);
        if (map.get(removed) == 0) map.remove(removed);
        l++;
      }
      r++;
    }
    return ans;
  }
  public static void main(String[] args) {
    List<Integer> arr1 = Arrays.asList(2,1,3,2,3);
    List<Integer> arr2 = Arrays.asList(2,4,4,2,4);
    System.out.println(countDistinctSublists(arr1));
    System.out.println(countDistinctSublists(arr2));
  }
}

