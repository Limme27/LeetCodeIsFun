package dfs.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class PostOrderBT_145 {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    dfs(root, res);
    return res;
  }

  public void dfs(TreeNode t, List<Integer> res) {
    if (t == null) return;
    dfs(t.left, res);
    dfs(t.right, res);
    res.add(t.val);
  }
}
