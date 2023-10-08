package array.twoPointers;

import java.util.Arrays;

public class RemoveElement_e27 {
  public static int removeElement(int[] nums, int val) {
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[j] = nums[i];
        j++;
      }
    }
    return j;   
  }
  public static void main(String[] args) {
    int[] a = {3,2,2,3};
    int k = removeElement(a, 3);
    Arrays.sort(a, 0, k);
    for (int i = 0; i < k; i++) {
      System.out.println(a[i]);
    }
  }
}
