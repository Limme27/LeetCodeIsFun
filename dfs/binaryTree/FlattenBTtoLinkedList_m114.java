package dfs.binaryTree;

public class FlattenBTtoLinkedList_m114 {
  public void flatten(TreeNode root) {
    if (root == null) return;
    if (root.left == null) {
      flatten(root.right);
      return;
    }
    flatten(root.right);
    flatten(root.left);
    // append the right subtree to the end of left subtree
    TreeNode r = root.right;
    TreeNode curr = root.left;
    while (curr.right != null) curr = curr.right;
    curr.right = r;
    // rearrange root's children
    root.right = root.left;
    root.left = null;
  }
}
