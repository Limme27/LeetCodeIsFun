package array.hashmap;

import java.util.HashMap;
import java.util.Map;

public class FindSubarraysWithEqualSum_2395 {
  public boolean findSubarrays(int[] nums) {
    Map<Integer, Boolean> dict = new HashMap<Integer, Boolean>();
    
    for (int i = 0; i < nums.length - 1; i++) {
      if (dict.containsKey(nums[i] + nums[i+1])) return true;
      else dict.put(nums[i] + nums[i+1], true);
    }
    return false;
  }
}