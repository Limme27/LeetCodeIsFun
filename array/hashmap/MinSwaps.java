package array.hashmap;

import java.util.*;

public class MinSwaps {
  // O(nlog(n))
  public static int getMinSwaps(List<Integer> popularity) {
    Map<Integer, Integer> map = new HashMap<>();
    int len = popularity.size();
    for (int i = 0; i < len; i++) map.put(popularity.get(i), i);
    
    Collections.sort(popularity, Collections.reverseOrder());
    
    boolean[] visited = new boolean[len];
    Arrays.fill(visited, false);
    
    int ans = 0;
    for (int i = 0; i < len; i++) {
      if (visited[i] || map.get(popularity.get(i)) == i) continue;
      int j = i, cycleSize = 0;
      while (!visited[j]) {
        visited[j] = true;
        j = map.get(popularity.get(j));
        cycleSize++;
      }
      if (cycleSize > 0) ans += (cycleSize - 1);
    }
    return ans;
  }
  public static void main(String[] args) {
    List<Integer> a = Arrays.asList(2, 5, 4, 1, 3);
    System.out.println(getMinSwaps(a));
  }
}