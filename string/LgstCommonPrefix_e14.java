package string;


public class LgstCommonPrefix_e14 {
  public String longestCommonPrefix(String[] strs) {
    int min = 200;
    for (String s : strs) min = Math.min(s.length(), min);
    
    String ans = "";
    for (int c = 0; c < min; c++) {
      if (strs[0] == null) break;
      char ch = strs[0].charAt(c);
      for (int r = 0; r < strs.length; r++) {
        if (strs[r] == null || ch != strs[r].charAt(c)) return ans;
      }
      ans += Character.toString(ch);
    }
    return ans;         
  }
}