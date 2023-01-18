package string;

public class LPalindromicSubstr_5 {
  public String longestPalindrome(String s) {
    int len = s.length();
		char[] s1 = s.toCharArray();
    int newLen = 2 * len + 1;
    
    char[] newS1 = new char[newLen];
    for (int i = 0; i < len; i++) {
      newS1[2*i + 1] = s1[i];
      newS1[2*i] = '$';
    }
    newS1[newLen-1] = '$'; 
    
    int[] dp = new int[newLen];
    /*
     * Non Manacher's algo as no dp[] is used
     */
    for (int i = 0; i < newLen; i++) {
      int offset = 1;
      while (i-offset >= 0 && i+offset < newLen && newS1[i-offset] == newS1[i+offset]) {
        offset++;
      }
      dp[i] = (offset-1)*2 + 1;
    }
    
    int maxCounter = 0;
    int maxIndex = 0;
    for (int i = 0; i < dp.length; i++) {
      if (dp[i] > maxCounter) {
        maxCounter = dp[i];
        maxIndex = i;
      }  
    }

    String result = "";
    for (int j = maxIndex - maxCounter/2; j <= maxIndex + maxCounter/2; j++) {
      if (newS1[j] != '$') result = result + newS1[j];
    }
    return result;
  }
}