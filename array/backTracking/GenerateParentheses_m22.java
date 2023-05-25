package array.backTracking;

import java.util.*;

public class GenerateParentheses_m22 {
  // public static List<String> generateParenthesis(int n) {
  //   List<String> ans = new ArrayList<>();
  //   int[] visited = new int[n*2];
  //   backTrack(ans, new StringBuilder(), visited, 0, 0, n);
  //   return ans;
  // }
  // private static void backTrack(List<String> ans, StringBuilder curr, int[] visited, int numL, int numR, int n) {
  //   if (numR > numL) return;
  //   if (numR == n) {
  //     ans.add(new String(curr.toString()));
  //     return;
  //   }
  //   char prev = '|';
  //   for (int i = 0; i < n * 2; i++) {
  //     char currChar = (i < n) ? '(' : ')';
  //     if (visited[i] != 1 &&  currChar != prev) {
  //       curr.append(currChar);
  //       visited[i] = 1;
  //       if (currChar == '(') backTrack(ans, curr, visited, numL+1, numR, n);
  //       else backTrack(ans, curr, visited, numL, numR+1, n);
  //       curr.deleteCharAt(curr.length()-1);
  //       visited[i] = 0;
  //       prev = currChar;
  //     }
  //   }
  // }
  public static List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList<>();
    backTrack(ans, "", n, n);
    return ans;
  }
  private static void backTrack(List<String> ans, String curr, int numL, int numR) {
    if (numL == 0 && numR == 0) {
      ans.add(curr);
      return;
    }
    if (numL > 0) backTrack(ans, curr + "(", numL-1, numR);
    if (numR > numL) backTrack(ans, curr + ")", numL, numR-1);
  }

  public static void main(String[] args) {
    List<String> ans = generateParenthesis(3);
    for (String s : ans) System.out.println(s);
  }
}
