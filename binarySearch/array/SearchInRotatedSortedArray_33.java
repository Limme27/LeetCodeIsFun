package binarySearch.array;

public class SearchInRotatedSortedArray_33 {
  public int search(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while (l <= r) {
      int m = l + (r-l) / 2;
      if (target == nums[m]) return m;
      
      if (nums[m] >= nums[l]) {
        // we are in left sorted area
        if (target > nums[m] || target < nums[l]) l = m + 1;
        else r = m - 1;
      }
      else {
        // we are in right sorted area
        if (target < nums[m] || target > nums[r]) r = m - 1;
        else l = m + 1;
      }
    }
    return -1;
  }
}