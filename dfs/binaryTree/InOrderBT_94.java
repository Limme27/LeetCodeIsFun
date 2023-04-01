package dfs.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class InOrderBT_94 {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    dfs(root, res);
    return res;
  }

  public void dfs(TreeNode t, List<Integer> res) {
    if (t == null) return;
    dfs(t.left, res);
    res.add(t.val);
    dfs(t.right, res);
  }
}
