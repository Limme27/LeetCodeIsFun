package bfs.tree;

import java.util.*;

public class LevelOrderBT_m102 {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;
    
    Queue<TreeNode> level = new ArrayDeque<>();
    level.add(root);
    Queue<Queue<TreeNode>> queue = new ArrayDeque<>();
    queue.add(level);

    while (!queue.isEmpty()) {
      List<Integer> tmp = new ArrayList<>();
      Queue<TreeNode> tmpLevel = new ArrayDeque<>();
      Queue<TreeNode> currLevel = queue.poll();
      while (!currLevel.isEmpty()) {
        TreeNode currNode = currLevel.poll();
        tmp.add(currNode.val);
        if (currNode.left != null) tmpLevel.add(currNode.left);
        if (currNode.right != null) tmpLevel.add(currNode.right);
      }
      if (!tmpLevel.isEmpty()) queue.add(tmpLevel);
      if (!tmp.isEmpty()) ans.add(tmp);
    }
    return ans;    
  }
}
