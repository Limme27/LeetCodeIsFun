package dfs.binaryTree;

import java.util.*;

public class LeafSimilarTrees_e872 {
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();
    dfs(root1, l1);
    dfs(root2, l2);
    if (l1.equals(l2)) return true;
    return false;    
  }
  private void dfs(TreeNode root, List<Integer> ans) {
    if (root == null) return;
    dfs(root.left, ans);
    dfs(root.right, ans);
    if (root.left == null & root.right == null) ans.add(root.val);
  }
}
