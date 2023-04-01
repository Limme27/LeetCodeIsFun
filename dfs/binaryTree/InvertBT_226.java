package dfs.binaryTree;

public class InvertBT_226 {
  public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    TreeNode res = new TreeNode(root.val);
    res.left = invertTree(root.right);
    res.right = invertTree(root.left);
    return res;
  }
}