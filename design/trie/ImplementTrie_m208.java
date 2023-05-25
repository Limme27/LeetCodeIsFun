package design.trie;

public class ImplementTrie_m208 {
  class Trie {
    private class TrieNode {
      private TrieNode[] children;
      private boolean isWord;
      TrieNode() {
        children = new TrieNode[26];
        isWord = false;
      }
    }
    TrieNode root;
    
    public Trie() {
      root = new TrieNode();
    }
    
    public void insert(String word) {
      TrieNode curr = root;
      int len = word.length();
      for (int i = 0; i < len; i++) {
        int index = word.charAt(i) - 'a';
        if (curr.children[index] == null) curr.children[index] = new TrieNode();
        curr = curr.children[index];
      }
      curr.isWord = true;
    }
    
    public boolean search(String word) {
      return dfs(word, root, 0);
    }
    
    public boolean startsWith(String prefix) {
      // Can also use dfs()
      TrieNode curr = root;
      int len = prefix.length();
      for (int i = 0; i < len; i++) {
        int index = prefix.charAt(i) - 'a';
        if (curr.children[index] == null) return false;
        curr = curr.children[index];
      }
      return true;
    }
    
    private boolean dfs(String word, TrieNode node, int i) {
      if (node == null) return false;
      if (i == word.length()) return node.isWord;
      int index = word.charAt(i) - 'a';
      return dfs(word, node.children[index], i+1);
    }
  }
}
