package dfs.binaryTree.bst;

import dfs.binaryTree.TreeNode;

public class ConvertSortedArrToBalancedBST_e108 {
  public TreeNode sortedArrayToBST(int[] nums) {
    return btBuilder(nums, 0, nums.length-1);
  }
  private TreeNode btBuilder(int[] nums, int l, int r) {
    if (l > r) return null;
    int m = l + (r-l)/2;
    TreeNode node = new TreeNode(nums[m]);
    node.left = btBuilder(nums,l,m-1);
    node.right = btBuilder(nums,m+1,r);
    return node;
  }
}