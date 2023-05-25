package array.backTracking;

import java.util.*;

public class PartitionPalindrome_m131 {
  public static List<List<String>> partition(String s) {
    List<List<String>> ans = new ArrayList<>();
    backTrack(ans, new ArrayList<>(), s, 0);
    return ans;
  }

  private static void backTrack(List<List<String>> ans, List<String> curr, String s, int currLv) {
    if (currLv == s.length()) {
      ans.add(new ArrayList<>(curr));
      return;
    }
    for (int i = currLv + 1; i <= s.length(); i++) {
      String currStr = s.substring(currLv, i);
      if (isPalindrome(currStr)) {
        curr.add(currStr);
        backTrack(ans, curr, s, i);
        curr.remove(curr.size()-1);
      }
    }
  }
  
  private static boolean isPalindrome(String s) {
    for (int i = 0, j = s.length()-1; i < j; i++, j--) 
      if (s.charAt(i) != s.charAt(j)) return false;
    return true;  
  }
  public static void main(String[] args) {
    System.out.println(partition("aab"));
    System.out.println(partition("a"));
    System.out.println(partition("abab"));
  }
}