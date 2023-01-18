package dfs.Tree;

public class InvertBT_226 {
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
  public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    TreeNode res = new TreeNode(root.val);
    res.left = invertTree(root.right);
    res.right = invertTree(root.left);
    return res;
  }
}