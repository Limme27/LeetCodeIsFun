package array.backTracking;

import java.util.*;

public class LetterCombosPhoneNum_m17 {
  static Map<Character, String> map;

  public static List<String> letterCombinations(String digits) {
    map = new HashMap<>();
    map.putAll(Map.of(
    '2', "abc",
    '3', "def",
    '4', "ghi",
    '5', "jkl",
    '6', "mno",
    '7', "pqrs",
    '8', "tuv",
    '9', "wxyz"));
    List<String> ans = new ArrayList<>();
    if (digits.length() != 0) backTrack(ans, digits, new StringBuilder(), 0);
    return ans;
  }

  private static void backTrack(List<String> ans, String digits, StringBuilder curr, int currLv) {
    if (currLv > digits.length()) return;
    if (curr.length() == digits.length()) {
      ans.add(curr.toString());
      return;
    }
    for (int i = 0; i < map.get(digits.charAt(currLv)).length(); i++) {
      curr.append(map.get(digits.charAt(currLv)).charAt(i));
      backTrack(ans, digits, curr, currLv+1);
      curr.deleteCharAt(curr.length()-1);
    }
  }
  public static void main(String[] args) {
    System.out.println(letterCombinations("23"));
    System.out.println(letterCombinations("2"));
    System.out.println(letterCombinations(""));
  }
}
