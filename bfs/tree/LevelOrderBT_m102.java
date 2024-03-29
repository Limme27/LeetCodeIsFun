package bfs.tree;

import dfs.binaryTree.TreeNode;
import java.util.*;

public class LevelOrderBT_m102 {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;
    
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> tmp = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode curr = queue.poll();
        tmp.add(curr.val);
        if (curr.left != null) queue.add(curr.left);
        if (curr.right != null) queue.add(curr.right);
      }
      if (!tmp.isEmpty()) ans.add(tmp);
    }
    return ans;
  }
}
