package array.prefixSum;

import java.util.*;

// 560 -> 523
public class ContinuSubarraySum_523 {
  public boolean checkSubarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    // (key: value) = (prefixSum % k: index)
    map.put(0, -1);

    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (map.containsKey(sum % k)) {
        if (i - map.get(sum % k) > 1) return true;
      }
      else {
        map.put(sum % k, i);
      }
    }
    return false;
  }
}
