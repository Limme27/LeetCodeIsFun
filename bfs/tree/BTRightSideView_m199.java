package bfs.tree;

import dfs.binaryTree.TreeNode;
import java.util.*;

public class BTRightSideView_m199 {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) return ans;
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      TreeNode first = queue.poll();
      ans.add(first.val);
      if (first.right != null) queue.add(first.right);
      if (first.left != null) queue.add(first.left);
      for (int i = 0; i < size-1; i++) {
        TreeNode curr = queue.poll();
        if (curr.right != null) queue.add(curr.right);
        if (curr.left != null) queue.add(curr.left);
      }
    }
    return ans;   
  }
}
