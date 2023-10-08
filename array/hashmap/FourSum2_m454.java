package array.hashmap;

import java.util.HashMap;
import java.util.Map;

public class FourSum2_m454 {
  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    Map<Integer, Integer> map =  new HashMap<>();
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums1.length; j++) {
        int key = nums1[i]+nums2[j];
        map.put(key, map.getOrDefault(key, 0)+1);
      }
    }
    int ans = 0;
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums1.length; j++) {
        int key = nums3[i]+nums4[j];
        ans += map.getOrDefault(-key, 0);
      }
    }
    return ans;
  }
}
