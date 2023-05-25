package array.backTracking;

import java.util.*;

public class PartitionToKEqualSumSubsets_m698 {
  public static boolean canPartitionKSubsets(int[] nums, int k) {
    int sum = Arrays.stream(nums).sum();
    if (sum % k != 0) return false;
    int[] visited = new int[nums.length];
    int targetSum = sum / k;
    return backTrack(nums, visited, 0, 0, targetSum, k);
  }
  
  private static boolean backTrack(int[] nums, int[] visited, int currIndx, int currSum, int targetSum, int k) {
    if (k == 0) return true;
    if (currSum > targetSum) return false;
    if (currSum == targetSum) return backTrack(nums, visited, 0, 0, targetSum, k-1);
    for (int i = currIndx; i < nums.length; i++) {
      if (visited[i] != 1) {
        currSum += nums[i];
        visited[i] = 1;
        if (backTrack(nums, visited, i+1, currSum, targetSum, k)) return true;
        currSum -= nums[i];
        visited[i] = 0;
      } 
    }
    return false;
  }

  public static void main(String[] args) {
    int[] a = {4,3,2,3,5,2,1};
    System.out.println(canPartitionKSubsets(a, 4));
    System.out.println(canPartitionKSubsets(a, 2));
    System.out.println(canPartitionKSubsets(a, 5));
  }
}