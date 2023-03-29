package binarySearch.array;

public class BinarySearch_704 {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int i = left + (right-left) / 2;
      if (target == nums[i]) return i;
      if (target < nums[i]) right = i-1;
      else left = i+1;
    }
    return -1;
  }
  public static void main(String[] args) {
    System.out.println(Integer.MAX_VALUE);
  }
}