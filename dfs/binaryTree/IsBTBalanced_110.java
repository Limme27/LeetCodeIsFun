package dfs.binaryTree;

public class IsBTBalanced_110 {
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
  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;
    if (Math.abs(treeHeight(root.left) - treeHeight(root.right)) < 2) 
      return isBalanced(root.left) && isBalanced(root.right);
    return false;
  }

  public int treeHeight(TreeNode t) {
    if (t == null) return -1;
    if (t.left == null && t.right == null) return 0;
    return 1 + Math.max(treeHeight(t.left), treeHeight(t.right));  
  }
}
