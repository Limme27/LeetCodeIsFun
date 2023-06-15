package dfs.binaryTree;

class Node {
  public int val;
  public Node left;
  public Node right;
  public Node next;
  public Node() {}
  public Node(int _val) {
      val = _val;
  }
  public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
  }
};

public class NextRightPointersToEachNode_m117 {
  public static Node connect(Node root) {
    dfs(root,0);
    return root;
  }
  private static void dfs(Node node, int isL) {
    if (node == null) return;
    if (node.left == null && node.right == null) return;
    if (node.right != null) {
      if (node.left != null) node.left.next = node.right;
      if (isL == 1) {
        Node next = bfs(node.next);
        if (next != null) {
          node.right.next = next;
        }
      }  
    }
    else if (node.left != null) {
      if (isL == 1) {
        Node next = bfs(node.next);
        if (next != null) {
          node.left.next = next;
        }
      }
    }
    if (node.next != null) dfs(node.right, 1); // Right subtree first 
    else dfs(node.right, 0);
    dfs(node.left, 1);
  }
  private static Node bfs(Node node) {
    if (node == null) return null;
    if (node.left != null) return node.left;
    else if (node.right != null) return node.right;
    return bfs(node.next);
  }
  public static void main(String[] args) {
    Node n2 = new Node(0, new Node(2, null, null, null), null, null);
    Node n3 = new Node(7, new Node(1, null, null, null), new Node(0, null, null, null), null);
    Node n4 = new Node(9, null, null, null);
    Node n5 = new Node(1, new Node(8, null, null, null), new Node(8, null, null, null), null);
    Node n1 = new Node(2, new Node(1, n2, n3, null), new Node(3, n4, n5, null), null);
    System.out.println(connect(n1));
  }
}
