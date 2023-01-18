package binarySearch.array;

public class SearchInRotatedSortedArray2_81 {
  public boolean search(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    while (l <= r) {
      int m = l + (r-l) / 2;
      if (nums[m] == target) return true;
      
      if (nums[m] > nums[l]) {
        if (target > nums[m] || target < nums[l]) l = m + 1;
        else r = m - 1;
      } 
      else if (nums[m] < nums[l]) {
        if (target < nums[m] || target > nums[r]) r = m - 1;
        else l = m + 1;
      }
      else l++;
    }
    return false;
  }  
}
