package dfs.binaryTree;

public class BalanceBST_1382 {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public TreeNode balanceBST(TreeNode root) {
    if (treeHeight(root.left) - treeHeight(root.right) > 1) {
      root = rotateRight(root);
      balanceBST(root.left);
    }  
    else if (treeHeight(root.right) - treeHeight(root.left) > 1) {
      root = rotateLeft(root);
      balanceBST(root.right);
    }
    return root;
  }

  public int treeHeight(TreeNode t) {
    if (t == null) return -1;
    if (t.left == null && t.right == null) return 0;
    return 1 + Math.max(treeHeight(t.left), treeHeight(t.right));  
  }

  public TreeNode rotateLeft(TreeNode n) {
    if (n == null || n.right == null) return n;
    TreeNode n1 = new TreeNode(n.right.val);
    n.right = n1.left;
    n1.left = n;
    return n1;
  }

  public TreeNode rotateRight(TreeNode n) {
    if (n == null || n.left == null) return n;
    TreeNode n1 = new TreeNode(n.left.val);
    n.left = n1.right;
    n1.right = n;
    return n1;
  }
}