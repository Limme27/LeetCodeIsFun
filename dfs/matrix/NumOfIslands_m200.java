package dfs.matrix;
import java.util.HashSet;

// Using matrix as visited DS see q.463

public class NumOfIslands_m200 {
  // Using HashSet as visited DS
  public static class Coordinates {
    private final int x;
    private final int y;
    public Coordinates(int x, int y) {
      this.x = x;
      this.y = y;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }
  }
  public int numIslands(char[][] grid) {
    HashSet<Coordinates> set = new HashSet<>();
    int ans = 0;
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        if (grid[r][c] == '1' && !set.contains(new Coordinates(r, c))) {
          if (dfs(grid, r, c, set)) ans++;
        }
      }
    }
    return ans;
  }
  public boolean dfs(char[][] grid, int r, int c, HashSet<Coordinates> set) {
    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') return false;
    if (set.add(new Coordinates(r, c)) == false) return false;
    dfs(grid, r-1, c, set);
    dfs(grid, r+1, c, set);
    dfs(grid, r, c-1, set);
    dfs(grid, r, c+1, set);
    return true;
  }
  /* O(1) memory
  public int numIslands(char[][] grid) {
    int ans = 0;
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        if (grid[r][c] == '1') {
          if (dfs(grid, r, c)) ans++;
        }
      }
    }
    return ans;
  }
  public boolean dfs(char[][] grid, int r, int c) {
    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') return false;
    grid[r][c] = '0';
    dfs(grid, r-1, c);
    dfs(grid, r+1, c);
    dfs(grid, r, c-1);
    dfs(grid, r, c+1);
    return true;
  }
  */
}
