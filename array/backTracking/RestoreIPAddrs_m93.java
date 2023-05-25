package array.backTracking;

import java.util.*;
import java.util.stream.Collectors;

public class RestoreIPAddrs_m93 {
  public static List<String> restoreIpAddresses(String s) {
    List<String> ans = new ArrayList<>();
    if (s.length() < 4 || s.length() >12) return ans;
    backTrack(ans, new ArrayList<>(), s, 0);
    return ans;
  }
  private static void backTrack(List<String> ans, List<String> curr, String s, int currLv) {
    if (curr.size() == 4) {
      if (currLv == s.length()) ans.add(curr.stream().collect(Collectors.joining(".")));
      return;
    }
    for (int i = currLv + 1; i < currLv+4 && i <= s.length(); i++) {
      String currStr = s.substring(currLv, i);
      if (currStr.length() > 1 && currStr.startsWith("0")) continue;
      int currInt = Integer.parseInt(currStr);
      if (currInt < 256 && currInt >= 0) {
        curr.add(currStr);
        backTrack(ans, curr, s, i);
        curr.remove(curr.size()-1);
      }
    }
  }
  public static void main(String[] args) {
    System.out.println(restoreIpAddresses("25525511135"));
    System.out.println(restoreIpAddresses("0000"));
    System.out.println(restoreIpAddresses("101023"));
  }
}
