package dfs;
import java.util.HashSet;

public class IslandPerimeterDFS_e463 {
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
  public int islandPerimeter(int[][] grid) {
    HashSet<Coordinates> set = new HashSet<>();
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        if (grid[r][c] == 1) return dfs(grid, r, c, set);
      }
    }
    return 0;
  }
  public int dfs(int[][] grid, int r, int c, HashSet<Coordinates> set) {
    if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) return 1;
    if (set.add(new Coordinates(r, c)) == false) return 0;
    return dfs(grid, r-1, c, set) + dfs(grid, r+1, c, set) + dfs(grid, r, c-1, set) + dfs(grid, r, c+1, set);
  }
}
