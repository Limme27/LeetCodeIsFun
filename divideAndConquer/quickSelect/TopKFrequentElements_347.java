package divideAndConquer.quickSelect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements_347 {
  public int[] topKFrequentSpaceHeavy(int[] nums, int k) {
    int[] ans = new int[k];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums) map.put(i, map.getOrDefault(i, 0)+1);
    
    List<List<Integer>> tmp = new ArrayList<List<Integer>>();
    for (int i = 0; i < nums.length; i++) tmp.add(new ArrayList<Integer>());

    // map.forEach((key,v) -> tmp.get(v-1).add(key));
    // Or
    for (Map.Entry<Integer, Integer> entry : map.entrySet())
      tmp.get(entry.getValue()-1).add(entry.getKey());
    
    for (int i = tmp.size()-1; i >= 0; i--) {
      if (!tmp.get(i).isEmpty()) {
        for (Integer e : tmp.get(i)) {
          ans[k-1] = e;
          k--;
        }  
      }
      if (k == 0) break;
    }
    return ans;
  }

  public int[] topKFrequentBSbyValue(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums) map.put(i, map.getOrDefault(i, 0)+1);

    int l = 1, r = nums.length;
    while (l < r) {
      int m = r-(r-l)/2;
      if (freqGreaterOrEqual(map, m) < k) r = m-1;
      else l = m;
    }

    return getArray(map, l, k);
  }

  public int freqGreaterOrEqual(Map<Integer, Integer> map, int m) {
    int count = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() >= m) count++;
    }
    return count;
  }

  public int[] getArray(Map<Integer, Integer> map, int m, int k) {
    int[] ans = new int[k];
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() >= m) {
        if (k == 0) break;
        k--;
        ans[k] = entry.getKey();
      }  
    }
    return ans;
  }

 
  
  public static void main(String[] args) {
    TopKFrequentElements_347 t = new TopKFrequentElements_347();
    int[] a = {1,1,1,2,2,3};
    System.out.println(t.topKFrequentSpaceHeavy(a, 2));
  }
}
