package array.hashmap;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2_219 {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> dict = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      if (!dict.containsKey(nums[i])) dict.put(nums[i], i);
      else {
        int idx = dict.get(nums[i]);
        if (Math.abs(idx - i) <= k) return true;
        else dict.replace(nums[i], i);
      }
    }
    return false;
  } 
}
