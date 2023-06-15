package dfs.binaryTree;

import java.util.*;
import java.util.stream.Collectors;
/*
      3
  9       20
8       15   7
pre: 3,9,8,20,15,7
in:  8,9,3,15,20,7
pre and in consist of unique values.
 */
public class ConstructBTFromPreOrderInOrder_m105 {
  public static TreeNode buildTree(int[] preorder, int[] inorder) {
    List<Integer> pre = Arrays.stream(preorder).boxed().collect(Collectors.toList());
    List<Integer> in = Arrays.stream(inorder).boxed().collect(Collectors.toList());
    return helper(pre, in);   
  }
  private static TreeNode helper(List<Integer> pre, List<Integer> in) {
    if (pre.isEmpty() || in.isEmpty()) return null;
    int val = pre.get(0);
    TreeNode node = new TreeNode(val);
    int mid = in.indexOf(val);
    // num of elements on the left of mid is the length of sub-preorder[] of the left subtree
    node.left = helper(pre.subList(1, mid+1), in.subList(0, mid));
    node.right = helper(pre.subList(mid+1, pre.size()), in.subList(mid+1, in.size()));
    return node;
  }
  public static void main(String[] args) {
    int[] a = {3,9,20,15,7};
    int[] b = {9,3,15,20,7};
    System.out.println(buildTree(a, b));
  }
}
