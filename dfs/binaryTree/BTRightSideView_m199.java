package dfs.binaryTree;

import java.util.*;

public class BTRightSideView_m199 {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    dfs(root, ans, 0);
    return ans;   
  }
  private void dfs(TreeNode root, List<Integer> ans, int lv) {
    if (root == null) return;
    if (lv == ans.size()) ans.add(root.val);
    dfs(root.right, ans, lv+1);
    dfs(root.left, ans, lv+1);
  }
}
