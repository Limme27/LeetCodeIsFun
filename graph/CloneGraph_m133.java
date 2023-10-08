package graph;

import java.util.*;

public class CloneGraph_m133 {
  class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
  }
  
  public Node cloneGraph(Node node) {
    if (node == null) return null;
    Map<Integer, Node> map = new HashMap<>();
    return dfs(node, map);
  }
  private Node dfs(Node node, Map<Integer, Node> map) {
    if (map.containsKey(node.val)) return map.get(node.val);
    Node newNode = new Node(node.val);
    map.put(node.val, newNode);
    for (Node n : node.neighbors) {
      Node neighbor = dfs(n, map);
      newNode.neighbors.add(neighbor);
    }
    return newNode;
  }
}
