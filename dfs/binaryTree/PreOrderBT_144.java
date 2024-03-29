package dfs.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class PreOrderBT_144 {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    dfs(root, res);
    return res;
  }

  public void dfs(TreeNode t, List<Integer> res) {
    if (t == null) return;
    res.add(t.val);
    dfs(t.left, res);
    dfs(t.right, res);
  }
}
