package dfs.matrix;

public class SurroundedRegions_m130 {
  public static void solve(char[][] board) {
    int m = board.length;
    int n = board[0].length;
    for (int r = 0; r < m; r++) {
      if (board[r][0] == 'O') dfs(board, r, 0);
      if (board[r][n-1] == 'O') dfs(board, r, n-1);

    }
    for (int c = 0; c < n; c++) {
      if (board[0][c] == 'O') dfs(board, 0, c);
      if (board[m-1][c] == 'O') dfs(board, m-1, c);
    }
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (board[r][c] == 'O') board[r][c] = 'X';
        else if (board[r][c] == '$') board[r][c] = 'O';
      }
    }
  }
  private static void dfs(char[][] grid, int r, int c) {
    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 'O') return;
    grid[r][c] = '$';
    dfs(grid, r-1, c);
    dfs(grid, r+1, c);
    dfs(grid, r, c-1);
    dfs(grid, r, c+1);
  }
  public static void main(String[] args) {
    char[][] board = {
      {'X', 'X', 'X', 'X'},
      {'X', 'O', 'O', 'X'},
      {'X', 'X', 'O', 'X'},
      {'X', 'O', 'X', 'X'}
      // {'O','O','O','O','X','X'},{'O','O','O','O','O','O'},{'O','X','O','X','O','O'},
      // {'O','X','O','O','X','O'},{'O','X','O','X','O','O'},{'O','X','O','O','O','O'}
    };
    solve(board);
    for (char[] row : board) {
      for (char cell : row) System.out.print(cell);
      System.out.println();
    }  
  }
}
