package array.twoPointers;

public class RemoveDuplisFromSortedArr2_m80 {
  public static int removeDuplicates(int[] nums) {
    /* My init method
    int j = 0;
    int numDuplis = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[j]) {
        if (numDuplis > 0) {
          nums[j+1] = nums[j];
          j += 2;
        } else j++;
        nums[j] = nums[i];
        numDuplis = 0;
      } else numDuplis++;
    }
    if (numDuplis > 0) {
      j++;
      nums[j] = nums[nums.length-1];
    }
    return j+1;
    */
    int ref = 2;
    for (int i = ref; i < nums.length; i++) {
      if (nums[i] != nums[ref-2]) {
        nums[ref] = nums[i];
        ref++;
      }
    }
    return ref;
  }
  public static void main(String[] args) {
    int[] a = {1,1,1,2,2,3};
    int[] b = {0,0,1,1,1,1,2,3,3};
    int[] c = {1,2,3};
    System.out.println(removeDuplicates(a));
    System.out.println(removeDuplicates(b));
    System.out.println(removeDuplicates(c));
  }
}
