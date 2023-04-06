package dfs.array;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets_698 {
  boolean[] visited = new boolean[16];
  
  public boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = Arrays.stream(nums).sum();
    if (sum % k != 0) return false;
    
    int target = sum / k;

    Arrays.sort(nums);
    int len = nums.length;
    if (nums[len-1] > target) return false;
    
    return dfs(nums, nums.length - 1, k, 0, target);         
  }
  
  public boolean dfs(int[] nums, int curr, int partitionLeft, int partitionSum, int target) {
    // All Partition found
    if (partitionLeft == 0) return true;
    // PartitionSum is bigger than the target during recursion
    if (partitionSum > target) return false;
    // One Partition found, keep finding the next Partition
    if (partitionSum == target) return dfs(nums, nums.length - 1, partitionLeft - 1, 0, target);
    // if partitionSum < target, Recursion is going as below
    int prevNum = 0; 
    for (int i = curr; i >= 0; i--) {
      if (!visited[i] && nums[i] != prevNum) {
        visited[i] = true;
        if (dfs(nums, i-1, partitionLeft, partitionSum + nums[i], target)) return true;
        visited[i] = false;
        prevNum = nums[i];
      }  
    }
    // PartitionSum is still < target aftre recursion
    return false;
  }
}