package array.hashmap;

import java.util.*;

public class NumOfGoodPairs_e1512 {
  public int numIdenticalPairs(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
    int count = 0;
    for (Integer i : map.values()) {
      if (i >= 2) count += (i * (i-1)) / 2;
    }
    return count;
  }
}
