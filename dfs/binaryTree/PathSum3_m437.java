package dfs.binaryTree;

public class PathSum3_m437 {
  // Check targetSum from two paths for every node: 1. path starts at the root 2. path starts at this node as the new root
  public static int pathSum(TreeNode root, int targetSum) {
    if (root == null) return 0;
    return dfs(root, (long) targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
  }
  // Check targetSum from the path starts at the root
  private static int dfs(TreeNode root, long targetSum) {
    if (root == null) return 0;
    return (root.val == targetSum ? 1 : 0) + dfs(root.left, targetSum-root.val) + dfs(root.right, targetSum-root.val);
  }
  
  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(1);
    TreeNode t2 = new TreeNode(-2);
    TreeNode t3 = new TreeNode(3);
    TreeNode t4 = new TreeNode(3,t3,t2);
    TreeNode t5 = new TreeNode(2,null,t1);
    TreeNode t6 = new TreeNode(5,t4,t5);
    TreeNode t7 = new TreeNode(11);
    TreeNode t8 = new TreeNode(-3,null,t7);
    TreeNode t9 = new TreeNode(10,t6,t8);
    System.out.println(pathSum(t9, 8));
  }
}

