package dp;

public class LCS_1143 {
	public int longestCommonSubsequence(String text1, String text2) {
		int len1 = text1.length();
		int len2 = text2.length();
		char[] str1 = text1.toCharArray();
		char[] str2 = text2.toCharArray();

		int[][] dp = new int[len1 + 1][len2 + 1];

		for (int i = 0; i <= len1; i++) dp[i][0] = 0;
		for (int j = 0; j <= len2; j++) dp[0][j] = 0;

		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				if (str1[i] == str2[j]) dp[i+1][j+1] = dp[i][j] + 1;
				else dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
			}
		}

		return dp[len1][len2];
	}
}
