package binarySearch.bsAlike2Pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 167 -> 15
public class ThreeSum_m15 {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    int prevI = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length - 2; i++) {
      if (nums[i] != prevI) {
        // O(n^2) algo
        int l = i+1;
        int r = nums.length - 1;
        int prevL = Integer.MAX_VALUE;
        int prevR = Integer.MAX_VALUE;
        while (l < r) {
          if (nums[l] == prevL) l++;
          else if (nums[r] == prevR) r--;
          else {
            int sum = nums[l] + nums[r];
            if (sum + nums[i] < 0) {
              prevL = nums[l];
              l++;
            }
            else if (sum + nums[i] > 0) {
              prevR = nums[r];
              r--;
            }
            else {
              ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
              prevL = nums[l];
              l++;
              prevR = nums[r];
              r--;
            }
          } 
        }
      }      
      prevI = nums[i];
    }
    return ans;
  }
}
