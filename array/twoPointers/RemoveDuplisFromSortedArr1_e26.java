package array.twoPointers;

public class RemoveDuplisFromSortedArr1_e26 {
  public static int removeDuplicates(int[] nums) {
    int ref = 1;
    for (int i = ref; i < nums.length; i++) {
      if (nums[i] != nums[ref-1]) {
        nums[ref] = nums[i];
        ref++;
      }
    }
    return ref;
  }
}
