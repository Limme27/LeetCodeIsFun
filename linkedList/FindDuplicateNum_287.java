package linkedList;

public class FindDuplicateNum_287 {
  // Floyd's Hare-Tortoise algorithm
  public int findDuplicate(int[] nums) {
    // find the intersection node
    int slow = 0, fast = 0;
    while (true) {
      slow = nums[slow];
      int temp = nums[fast];
      fast = nums[temp];
      if (slow == fast) break;
    }
    // distance from the intersection node to the start of cycle == distance from the 1st node to the start of cycle
    fast = 0;
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }
    return fast;
  }
}
