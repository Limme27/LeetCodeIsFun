package array.twoPointers;

import java.util.HashMap;
import java.util.Map;

public class RotateArr_m189 {
  public void rotate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int len = nums.length;
    k %= len;
    for (int i = 0; i < k; i++) {
      int prev = nums[i];
      int j = i + k;
      while (j < len) {
        int tmp = nums[j];
        nums[j] = prev;
        prev = tmp;
        j += k;
      }
      if (j%len <= i) nums[j%len] = prev;
      else map.put(j%len, prev);
    }
    for (Integer e : map.keySet()) nums[e] = map.get(e);
  }
}
