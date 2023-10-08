package dfs.matrix;
// Using HashSet as visited DS see q.200
// Non-DFS method is in ../../matrix
public class IslandPerimeterDFS_e463 {
  // Using matrix as visited DS
  public int islandPerimeter(int[][] grid) {
    int[][] visited = new int[grid.length][grid[0].length];
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        if (grid[r][c] == 1) return dfs(grid, r, c, visited);
      }
    }
    return 0;
  }
  public int dfs(int[][] grid, int r, int c, int[][] visited) {
    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) return 1;
    if (visited[r][c] == 1) return 0;
    visited[r][c] = 1;
    return dfs(grid, r-1, c, visited) + dfs(grid, r+1, c, visited) + dfs(grid, r, c-1, visited) + dfs(grid, r, c+1, visited);
  }
}
