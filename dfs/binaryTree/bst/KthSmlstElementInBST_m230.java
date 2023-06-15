package dfs.binaryTree.bst;

import dfs.binaryTree.TreeNode;

public class KthSmlstElementInBST_m230 {
  int count = 0;
  int ans = -1;
  public int kthSmallest(TreeNode root, int k) {
    dfs(root, k);
    return ans;
  }
  private void dfs(TreeNode root, int k) {
    if (root == null) return;
    dfs(root.left, k);
    count++;
    if (count == k) ans = root.val;
    if (count < k) dfs(root.right, k);
  }
}
