package dfs.binaryTree;

import java.util.*;
import java.util.stream.Collectors;
/*
      3
  9       20
8       15   7
post: 8,9,15,7,20,3
in:   8,9,3,15,20,7
post and in consist of unique values.
 */
public class ConstructBTFromPostOrderInOrder_m106 {
  public static TreeNode buildTree(int[] inorder, int[] postorder) {
    List<Integer> post = Arrays.stream(postorder).boxed().collect(Collectors.toList());
    List<Integer> in = Arrays.stream(inorder).boxed().collect(Collectors.toList());
    return helper(post, in);   
  }
  private static TreeNode helper(List<Integer> post, List<Integer> in) {
    if (post.isEmpty() || in.isEmpty()) return null;
    int val = post.get(post.size()-1);
    TreeNode node = new TreeNode(val);
    int mid = in.indexOf(val);
    node.left = helper(post.subList(0, mid), in.subList(0, mid));
    node.right = helper(post.subList(mid, post.size()-1), in.subList(mid+1, in.size()));
    return node;
  }
  public static void main(String[] args) {
    int[] a = {3,9,20,15,7};
    int[] b = {9,3,15,20,7};
    System.out.println(buildTree(a, b));
  }
}
