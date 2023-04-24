package array.prefixSum;

// 560 -> 1248
public class CountSubarraysWithKOdds_m1248 {
  public static int numberOfSubarrays(int[] nums, int k) {
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
