package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LPalindromicS_516 {
	public int longestPalindromeSubseq(String s) {
		int len = s.length();
		char[] s1 = s.toCharArray();
		// create revered String s
		List<String> s2 = new ArrayList<>();
		for (char c : s1) s2.add(Character.toString(c));
		Collections.reverse(s2);
		
		// inti dp[][]
		int[][] dp = new int[len + 1][len + 1];
		for (int i = 0; i <= len; i++) dp[i][0] = 0;
		for (int j = 0; j <= len; j++) dp[0][j] = 0;

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (s1[i] == s2.get(j).charAt(0)) dp[i+1][j+1] = dp[i][j] + 1;
				else dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
			}
		}

		return dp[len][len];
	}

}