package divideAndConquer.quickSelect;

public class KthLgstElementInArray_215 {
  public int findKthLargest(int[] nums, int k) {
    int target = nums.length - k;
    return quickSelect(nums, 0, nums.length - 1, target);
  }

  public int quickSelect(int[] nums, int l, int r, int target) {
    int pivot = nums[r];
    int j = l;
    for (int i = l; i < r; i++) {
      if (nums[i] <= pivot) {
        if (i != j) swap(nums, i, j);
        j++;
      }
    }
    swap(nums, j, r);
    if (target < j) return quickSelect(nums, l, j-1, target);
    else if (target > j) return quickSelect(nums, j+1, r, target);
    else return nums[j];
  }
  
  public void swap(int[] nums, int a, int b) {
    int temp = nums[b];
    nums[b] = nums[a];
    nums[a] = temp;
  }
}
