package matrix;

public class IslandPerimeter_e463 {
  public int islandPerimeter(int[][] grid) {
    int ans = 0;
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        if (grid[r][c] == 1) {
          ans += 4;
          if (c > 0 && grid[r][c-1] == 1) ans -= 2;
          if (r > 0 && grid[r-1][c] == 1) ans -= 2;
        }
      }
    }
    return ans;
  }  
}
