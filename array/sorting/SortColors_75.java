package array.sorting;

public class SortColors_75 {
  public void sortColors(int[] nums) {
    int l = 0, r = nums.length-1;
    for (int i = 0; i <= r; i++) {
      if (nums[i] == 0) {
        swap(nums, i, l);
        l++;
      }
      else if (nums[i] == 2) {
        swap(nums, i, r);
        r--;
        i--;
      }
    }
  }
  
  public void swap(int[] nums, int a, int b) {
    int temp = nums[b];
    nums[b] = nums[a];
    nums[a] = temp;
  }
}
