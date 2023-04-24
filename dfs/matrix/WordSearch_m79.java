package dfs.matrix;

public class WordSearch_m79 {
  public boolean exist(char[][] board, String word) {
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[0].length; c++) {
        if (board[r][c] == word.charAt(0)) {
          int[][] visited = new int[board.length][board[0].length];
          if (dfs(board, word, 0, r, c, visited)) return true;
        }  
      }
    }
    return false;
  }
  public boolean dfs(char[][] grid, String word, int i, int r, int c, int[][] visited) {
    if (i >= word.length()) return true;
    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != word.charAt(i) || visited[r][c] == 1) return false;
    visited[r][c] = 1;
    if (dfs(grid, word, i+1, r-1, c, visited) || dfs(grid, word, i+1, r+1, c, visited)
        || dfs(grid, word, i+1, r, c-1, visited) || dfs(grid, word, i+1, r, c+1, visited)) return true;
    visited[r][c] = 0;
    return false;
  }
  
  public static void main(String[] args) {
    WordSearch_m79 w = new WordSearch_m79();
    char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
    System.out.println(w.exist(board, "ABCCED"));
    System.out.println(w.exist(board, "ABCESEEEFS"));
    System.out.println(w.exist(board, "ECBFCS"));
  }
}
