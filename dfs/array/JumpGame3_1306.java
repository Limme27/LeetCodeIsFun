package dfs.array;

public class JumpGame3_1306 {
  public int[] visited = new int[50001];
  
  public boolean canReach(int[] arr, int start) {
    if (start < 0 || start >= arr.length) return false;
    if (visited[start] == 1) return false;
    if (arr[start] == 0) return true;
    
    visited[start] = 1;
    return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
  }
}
