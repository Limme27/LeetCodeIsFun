package array.prefixSum;

import java.util.*;

// 560 -> 1248
// Not a Sliding window problem as fixing either left end or right end can not include all possible subarrays
// For example, [0,0,0,1,0,0,1,0,0,0] where k = 2
public class CountSubarraysWithKOdds_m1248 {
  public static int numberOfSubarrays(int[] nums, int k) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % 2 == 0) nums[i] = 0;
      else nums[i] = 1;
    }
    // (key: value) = (currSum: counter)
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    map.put(0, 1);
    int count = 0;
    int sum = 0;
    for (int num : nums) {
      sum += num;
      // If the target prefixSum (sum - k) exists in the map, just add up its count
      if (map.containsKey(sum - k)) count += map.get(sum - k);
      // Store the new sum in the map as the prefixSum for the remaining num
      map.put(sum, map.getOrDefault(sum, 0) + 1);      
    }
    return count;
  }
  
  public static int numberOfSubarraysChatGPT(int[] nums, int k) {
    int count = 0;
    int oddCount = 0;
    int[] prefix = new int[nums.length + 1];
    prefix[0] = 1;
    for (int num : nums) {
      oddCount += num % 2 == 1 ? 1 : 0;
      prefix[oddCount]++;
      if (oddCount >= k) count += prefix[oddCount - k];
    }
    return count;
  }  

  public static void main(String[] args) {
    int[] a = {1,1,2,1,1};
    int[] b = {2,2,2,1,2,2,1,2,2,2};
    System.out.println(numberOfSubarrays(a, 1)); // 6
    System.out.println(numberOfSubarrays(a, 2)); // 5
    System.out.println(numberOfSubarrays(a, 3)); // 2
    System.out.println(numberOfSubarrays(b, 2)); // 16
  }
}
