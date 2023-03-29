package bfs.tree;

import java.util.*;

public class LevelOrderNaryT_m429 {
  public class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val) {
      val = _val;
    }
    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;
    
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node curr = queue.poll();
        level.add(curr.val);
        for (Node n : curr.children) queue.add(n);
      }
      ans.add(level);
    }
    return ans;    
  }  
}
