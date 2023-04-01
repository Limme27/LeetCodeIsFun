package dfs.binaryTree;

public class LowestCommonAncestorBST_m235 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;
    int min = Math.min(p.val, q.val);
    int max = Math.max(p.val, q.val);
    if (max < root.val) return lowestCommonAncestor(root.left, p, q);
    else if (min > root.val) return lowestCommonAncestor(root.right, p, q);
    return root;
  }
}
