package dfs.binaryTree;

public class ConvertSortedArrayToBST_108 {
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

  public TreeNode sortedArrayToBST(int[] nums) {
    return dfs(0, nums.length-1, nums);
  }

  public TreeNode dfs(int l, int r, int[] nums) {
    if (r < l || l < 0 || r >= nums.length) return null;
    int m = l + (r-l)/2;
    TreeNode res = new TreeNode(nums[m]);
    res.left = dfs(l, m-1, nums);
    res.right = dfs(m+1, r, nums);
    return res;
  }
}