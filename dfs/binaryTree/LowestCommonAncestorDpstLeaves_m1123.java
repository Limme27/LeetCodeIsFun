package dfs.binaryTree;

import java.util.*;

public class LowestCommonAncestorDpstLeaves_m1123 {
  TreeNode ans = null;
  public TreeNode lcaDeepestLeaves(TreeNode root) {
    int maxH = maxDepth(root);
    List<TreeNode> nodes = new ArrayList<>();
    getDpstL(nodes, root, maxH, 1);
    if (nodes.size() == 1) return nodes.get(0);
    lowestCommonAncestor(root, nodes);
    return ans;
  }
    
  private int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
  
  private void getDpstL(List<TreeNode> nodes, TreeNode root, int maxH, int h) {
    if (root == null) return;
    if (h == maxH) {
      nodes.add(root);
      return;
    }
    getDpstL(nodes, root.left, maxH, h+1);
    getDpstL(nodes, root.right, maxH, h+1);
  }
  
  private int lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
    if (root == null) return 0;
    int l = lowestCommonAncestor(root.left, nodes);
    int r = lowestCommonAncestor(root.right, nodes);
    int self = nodes.contains(root) ? 1 : 0;
    int count = l+r+self;
    if (count == nodes.size() && ans == null) ans = root;
    return count;
  }
}
