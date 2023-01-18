package linkedList;

public class FindDuplicateNum_287 {
  public int findDuplicate(int[] nums) {
    // Floyd's Hare-Tortoise algorithm
    int slow = 0, fast = 0;
    while (true) {
      slow = nums[slow];
      int temp = nums[fast];
      fast = nums[temp];
      if (slow == fast) break;
    }
    
    fast = 0;
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }

    return fast;
  }
}
