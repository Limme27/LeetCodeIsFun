package array.heap;

import java.util.*;

public class TopKFreqWords_m692 {
  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String s : words) map.put(s, map.getOrDefault(s, 0)+1);
    // Customize sorting as per the value of the String
    PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> {
      int valueA = map.get(a);
      int valueB = map.get(b);
      if (valueA == valueB) return a.compareTo(b);
      else return valueB - valueA;
    });
    pq.addAll(map.keySet());
    List<String> ans = new ArrayList<>();
    for (int i = k; i > 0; i--) ans.add(pq.poll());
    return ans;
  }
}