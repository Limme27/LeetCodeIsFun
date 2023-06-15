package dfs.binaryTree;
// 543 -> 687
public class LgstUnivaluePath_m687 {
  int max = 0;
  public int longestUnivaluePath(TreeNode root) {
    dfs(root);
    return max;
  }
  private int dfs(TreeNode root) {
    if (root == null) return 0;
    int pathL = dfs(root.left);
    int pathR = dfs(root.right);
    int l = (pathL != 0 && root.left.val == root.val) ? pathL : 0;
    int r = (pathR != 0 && root.right.val == root.val) ? pathR : 0;
    max = Math.max(max, l+r);
    return 1 + Math.max(l, r); // return 1 means there is one child path to the curr root
  }
}