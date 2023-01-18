package array.slidingWindow;

public class LgstSubstrWithoutRepeatingChars_3 {
  public int lengthOfLongestSubstring(String s) {
    int len = s.length();
		char[] arr = s.toCharArray();
    
    String temp = "";
    int r = 0;
    int maxLen = 0;
    for (int l = 0; l < len; l++) { 
      while (r < len && temp.indexOf(arr[r]) == -1) {
        temp += arr[r];
        r++;
      }
      maxLen = Math.max(maxLen, temp.length());
      temp = temp.substring(1);
    }
    return maxLen;
  }
  
  public static void main(String[] args) {
    LgstSubstrWithoutRepeatingChars_3 l = new LgstSubstrWithoutRepeatingChars_3();
    System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
    
  }
}
