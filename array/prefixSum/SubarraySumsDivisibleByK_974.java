package array.prefixSum;

public class SubarraySumsDivisibleByK_974 {
  public int subarraysDivByK(int[] nums, int k) {
    int[] map = new int[k];
    map[0] = 1;
    // (key -> value) : (mod = prefixSum % k -> num of subarray(option) has the exact same mod)
    int counter = 0, prefixSum = 0;
    for (int i = 0; i < nums.length; i++) {
      prefixSum += nums[i];
      int key = prefixSum % k;
      if (key < 0) key += k;
      counter += map[key];
      map[key]++;
    }  
    return counter;
  }

  public static void main(String[] args) {
    SubarraySumsDivisibleByK_974 l = new SubarraySumsDivisibleByK_974();
    int[] a = {5, 2, 0, 1, 3, 2};
    int[] b = {4, 5, 0, -2, -3, 1, 5};
    System.out.println(l.subarraysDivByK(a, 3));
    System.out.println(l.subarraysDivByK(b, 5));
  }
}
