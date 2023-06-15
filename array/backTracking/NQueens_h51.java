package array.backTracking;

import java.util.*;

public class NQueens_h51 {
  public static List<List<String>> solveNQueens(int n) {
    List<List<String>> ans = new ArrayList<>();
    char[][] grid = new char[n][n];
    for (int r = 0; r < n; r++) {
      for (int c = 0; c < n; c++) {
        grid[r][c] = '.';
      }
    }
    backTrack(ans, new ArrayList<>(), grid, n, 0);
    return ans;
  }

  private static void backTrack(List<List<String>> ans, List<String> curr, char[][] grid, int n, int r) {
    if (r == n) {
      ans.add(new ArrayList<>(curr));
      return;
    }
    for (int c = 0; c < n; c++) {
      if (isValid(grid, r, c)) {
        grid[r][c] = 'Q';
        curr.add(new String(grid[r]));
        backTrack(ans, curr, grid, n, r+1);
        curr.remove(curr.size()-1);
        grid[r][c] = '.';
      }
    }
  }
  private static boolean isValid(char[][] grid, int r, int c) {
    for (int i = 0; i < r; i++) if (grid[i][c] == 'Q') return false;
    for (int i = 1; r-i >= 0 && c-i >= 0; i++) if (grid[r-i][c-i] == 'Q') return false;
    for (int i = 1; r-i >= 0 && c+i < grid[0].length; i++) if (grid[r-i][c+i] == 'Q') return false;
    return true;
  }

  public static void main(String[] args) {
    System.out.println(solveNQueens(4));
  }
}
