package bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class JumpGame3_1306 {
  public boolean canReach(int[] arr, int start) {
    int len = arr.length;
    
    Queue<Integer> queue = new ArrayDeque<>();
    int[] visited = new int[len];
    
    visited[start] = 1;
    queue.add(start);
    while (!queue.isEmpty()) {
      int i = queue.poll();
      if (arr[i] == 0) return true;
      if (i + arr[i] < len && i - arr[i] >= 0) {
        if (visited[i + arr[i]] == 0) {
          visited[i + arr[i]] = 1;
          queue.add(i + arr[i]);
        }
        if (visited[i - arr[i]] == 0) {
          visited[i - arr[i]] = 1;
          queue.add(i - arr[i]);
        }
      } else {
        if (i + arr[i] < len && visited[i + arr[i]] == 0) {
          visited[i + arr[i]] = 1;
          queue.add(i + arr[i]);
        } else if (i - arr[i] >= 0 && visited[i - arr[i]] == 0) {
          visited[i - arr[i]] = 1;
          queue.add(i - arr[i]);
        }
      }  
    }
    return false;
  }
}