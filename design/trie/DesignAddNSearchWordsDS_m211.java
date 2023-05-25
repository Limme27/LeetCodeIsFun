package design.trie;

public class DesignAddNSearchWordsDS_m211 {
  class WordDictionary {
    private class TrieNode {
      private TrieNode[] children;
      private boolean isWord;
      TrieNode() {
        children = new TrieNode[26];
        isWord = false;
      }
    }
    TrieNode root;

    public WordDictionary() {
      root = new TrieNode();
    }
    
    public void addWord(String word) {
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

    private boolean dfs(String word, TrieNode node, int i) {
      if (node == null) return false;
      if (i == word.length()) return node.isWord;
      if (word.charAt(i) == '.') {
        for (TrieNode t : node.children){
          if (dfs(word, t, i+1)) return true;
        }
      } else {
        int index = word.charAt(i) - 'a';
        return dfs(word, node.children[index], i+1);
      }
      return false;
    }
  }
}
