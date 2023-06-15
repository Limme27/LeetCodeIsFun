package dfs.binaryTree;

import java.util.*;
import java.util.stream.Collectors;

public class SerializeDeserializeBT_h297 {
  int currNode;
  public String serialize(TreeNode root) {
    if (root == null) return null;
    List<Integer> pre = new ArrayList<>();
    dfs(root, pre);
    return pre.stream().map(Object::toString).collect(Collectors.joining(","));  
  }

  public TreeNode deserialize(String data) {
    if (data == null) return null;
    List<Integer> pre = Arrays.stream(data.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    currNode = 0;
    return buildTree(pre);
  }
  
  private void dfs(TreeNode t, List<Integer> res) {
    if (t == null) {
      res.add(1001);
      return;
    }
    res.add(t.val);
    dfs(t.left, res);
    dfs(t.right, res);
  }

  private TreeNode buildTree(List<Integer> pre) {
    int val = pre.get(currNode);
    if (val == 1001) {
      currNode++;
      return null;
    }  
    TreeNode node = new TreeNode(val);
    currNode++;
    node.left = buildTree(pre);
    node.right = buildTree(pre);
    return node;
  }
}
