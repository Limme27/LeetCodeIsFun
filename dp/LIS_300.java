package dp;

import java.util.Arrays;

public class LIS_300 {
	public int lengthOfLIS(int[] nums) {
		int len = nums.length;
		int[] dp = new int[len];

		for (int i = 0; i < len; i++) {
			dp[i] = 1;
		}
		
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}

		return Arrays.stream(dp).max().getAsInt();
		
	}
}
