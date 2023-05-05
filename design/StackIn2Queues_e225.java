package design;

import java.util.*;

public class StackIn2Queues_e225 {
  private Queue<Integer> q1;
  private Queue<Integer> q2;
  
  public StackIn2Queues_e225() {
    q1 = new ArrayDeque<>();
    q2 = new ArrayDeque<>();
  }
  
  public void push(int x) {
    q1.add(x);
  }
  
  public int pop() {
    while (q1.size() > 1) q2.add(q1.poll());
    int ans = q1.poll();
    Queue<Integer> temp = q1;
    q1 = q2;
    q2 = temp;
    return ans;
  }

  public int top() {
    while (q1.size() > 1) q2.add(q1.poll());
    int ans = q1.peek();
    q2.add(q1.poll());
    Queue<Integer> temp = q1;
    q1 = q2;
    q2 = temp;
    return ans;
  }
  
  public boolean empty() {
    return q1.isEmpty();
  }
}