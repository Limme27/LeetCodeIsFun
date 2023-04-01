package dfs.binaryTree;

public class IsBSTValidate_m98 {
  public boolean isValidBST(TreeNode root) {
    return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }
  
  public static boolean isValid(TreeNode root, long boundaryL, long boundaryR) {
    if (root == null) return true;
    if ((root.left != null && (root.left.val >= root.val || root.left.val <= boundaryL)) || (root.right != null && (root.right.val <= root.val || root.right.val >= boundaryR))) return false;
    return isValid(root.left, boundaryL, root.val) && isValid(root.right, root.val, boundaryR);
  }
}
