package array.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class MergeSortedArray_e88 {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < m; i++) queue.add(nums1[i]);
    
    int j = 0;
    for (int i = 0; i < m+n; i++) {
      if ( (j < n && !queue.isEmpty() && nums2[j] >= queue.peek()) 
        || (j == n && !queue.isEmpty()) ) nums1[i] = queue.poll();
      else {
        nums1[i] = nums2[j];
        j++;
      }
    }
  }
}
