package dfs.binaryTree;
// 543 -> 687
// 543 -> 124
public class DiameterBT_E543 {
  int max = 0;
  public int diameterOfBinaryTree(TreeNode root) {
    dfs(root);
    return max;
  }
  private int dfs(TreeNode root) {
    if (root == null) return 0;
    int l = dfs(root.left);
    int r = dfs(root.right);
    max = Math.max(max, l+r); // compare the max at the curr node to the global max
    return Math.max(l,r) + 1; // return the longer child plus itself to its parent node
  }
}