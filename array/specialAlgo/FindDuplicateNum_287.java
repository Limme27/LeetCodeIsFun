package array.specialAlgo;
// Floyd's Hare-Tortiose
// Time: O(n)
// Space: O(1)
// Array [nums] not modified
public class FindDuplicateNum_287 {
  public int findDuplicate(int[] nums) {
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
