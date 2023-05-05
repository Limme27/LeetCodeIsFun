package design;

import java.util.Stack;

public class QueueIn2Stacks_e232 {
  private Stack<Integer> s1;
  private Stack<Integer> s2;
  
  public QueueIn2Stacks_e232() {
    s1 = new Stack<>();
    s2 = new Stack<>();
  }
  
  public void push(int x) {
    s1.push(x);
  }
  
  public int pop() {
    if (s2.isEmpty()) {
      while (!s1.isEmpty()) {
        s2.push(s1.pop());
      }
    }
    return s2.pop();
  }
  
  public int peek() {
    if (s2.isEmpty()) {
      while (!s1.isEmpty()) {
        s2.push(s1.pop());
      }
    }
    return s2.peek();
  }
  
  public boolean empty() {
    return s1.isEmpty() && s2.isEmpty();
  }
}
