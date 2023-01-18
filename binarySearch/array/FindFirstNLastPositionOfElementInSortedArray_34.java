package binarySearch.array;

import java.util.Arrays;

public class FindFirstNLastPositionOfElementInSortedArray_34 {
  public int[] searchRange(int[] nums, int target) {
    int[] res = new int[2];
    Arrays.fill(res, -1);
    
    int l = 0, r = nums.length-1;
    int i = -1;
    while (l <= r) {
      int m = l + (r-l)/2;
      if (nums[m] > target) r = m-1;
      else if (nums[m] < target) l = m+1;
      else {
        i = m;
        break;
      }  
    }
    if (i == -1) return res;
    
    int ll = l;
    int rr = i-1;
    int low = i;
    while (ll <= rr) {
      int m = ll + (rr-ll)/2;
      if (nums[m] == target) {
        low = Math.min(low, m);
        rr = m-1;
      }  
      else ll = m+1;
    }
    res[0] = low;

    ll = i+1;
    rr = r;
    int high = i;
    while (ll <= rr) {
      int m = ll + (rr-ll)/2;
      if (nums[m] == target) {
        high = Math.max(high, m);
        ll = m+1;
      }  
      else rr = m-1;
    }
    res[1] = high;
    return res;
  }
}
