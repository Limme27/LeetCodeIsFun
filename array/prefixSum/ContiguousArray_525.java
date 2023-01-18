package array.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray_525 {
  public int findMaxLength(int[] nums) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    // (key: value) = (len of subarray - 2 * prefixSum: index)
    int maxLen = 0;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      int diff = i + 1 - 2*sum;
      if (diff == 0) maxLen = Math.max(maxLen, i + 1);
      else {
        if (map.containsKey(diff)) {
          maxLen = Math.max(maxLen, i - map.get(diff));
        }
        else {
          map.put(diff, i);
        }
      }
    }
    return maxLen;
  }
}
