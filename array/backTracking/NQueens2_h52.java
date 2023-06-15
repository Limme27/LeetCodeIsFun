package array.backTracking;

public class NQueens2_h52 {
  private static int ans;
  public static int totalNQueens(int n) {
    ans = 0;
    char[][] grid = new char[n][n];
    for (int r = 0; r < n; r++) {
      for (int c = 0; c < n; c++) {
        grid[r][c] = '.';
      }
    }
    backTrack(grid, n, 0);
    return ans;
  }

  private static void backTrack(char[][] grid, int n, int r) {
    if (r == n) {
      ans++;
      return;
    }
    for (int c = 0; c < n; c++) {
      if (isValid(grid, r, c)) {
        grid[r][c] = 'Q';
        backTrack(grid, n, r+1);
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
    System.out.println(totalNQueens(4));
    System.out.println(totalNQueens(1));
    System.out.println(totalNQueens(3));
  }
}
