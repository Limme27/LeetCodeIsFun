package array.prefixSum;

import java.util.*;
/* 
    1 <= nums.length <= 2 * 104
    -1000 <= nums[i] <= 1000 ====> sliding window not working
    -107 <= k <= 107
*/
public class SubarraySumEqualsK_560 {
  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    // (key: value) = (prefixSum: counter)
    map.put(0, 1);

    int count = 0;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      // 看map里是否存储了当前的sum - k这个entry
      if (map.containsKey(sum - k)) count += map.get(sum - k);
      map.put(sum, map.getOrDefault(sum, 0) + 1);      
    }
    return count;    
  }
}