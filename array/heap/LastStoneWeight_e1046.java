package array.heap;

import java.util.*;

public class LastStoneWeight_e1046 {
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
    for (int e : stones) maxPQ.add(e);
    while (!maxPQ.isEmpty()) {
      int num1 = maxPQ.poll();
      if (!maxPQ.isEmpty()) {
        int num2 = maxPQ.poll();
        if (num1 > num2) maxPQ.add(num1-num2);
      } else return num1;  
    }
    return 0;
  }
}
