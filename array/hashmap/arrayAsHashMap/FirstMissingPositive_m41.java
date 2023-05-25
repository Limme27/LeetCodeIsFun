package array.hashmap.arrayAsHashMap;

// HARD is O(1) space complexity
public class FirstMissingPositive_m41 {
  public static int firstMissingPositive(int[] nums) {
    int len = nums.length;
    // Medium is O(n) for both time and space complexity
    int[] temp = new int[len];
    for (int i = 0; i < len; i++) {
      if (nums[i] > 0 && nums[i] <= len) temp[nums[i] - 1] = 1;
    }
    for (int i = 0; i < len; i++) {
      if (temp[i] != 1) return i + 1;
    }
    return len + 1;      
  }
  public static void main(String[] args) {
    int[] A1 = {1, 3, 6, 4, 1, 2};
    int[] A2 = {1, 2, 3};
    int[] A3 = {-1, -3};
    int[] A4 = {-1, 1, -3, 2};
    int[] A5 = {-1, 1, -3, 3};
    System.out.println(firstMissingPositive(A1));
    System.out.println(firstMissingPositive(A2));
    System.out.println(firstMissingPositive(A3));
    System.out.println(firstMissingPositive(A4)); // 3
    System.out.println(firstMissingPositive(A5)); // 2
  }
}
