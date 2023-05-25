package design;
import java.util.*;

public class MinStack_m155 {
  class MinStack {
    private Stack<Integer> s;
    private int min;

    public MinStack() {
      s = new Stack<>();
      min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
      if (val <= min) {
        s.push(min);
        min = val;
      }
      s.push(val);
    }
    
    public void pop() {
      if (s.pop() == min) min = s.pop();
    }
    
    public int top() {
      return s.peek();
    }
    
    public int getMin() {
      return min;
    }
  }
}
