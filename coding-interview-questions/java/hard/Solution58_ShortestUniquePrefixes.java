import java.util.*;

class Program {
  // O(n * m) time | O(n * m) space - n is the number of the strings, and m is the
  // length of the longest string.
  public String[] shortestUniquePrefixes(String[] strings) {
    Trie trie = new Trie();
    for (String string : strings) {
      trie.insert(string);
    }

    String[] results = new String[strings.length];
    for (int i = 0; i < strings.length; i++) {
      results[i] = getUniquePrefix(strings[i], trie.root);
    }

    return results;
  }

  public String getUniquePrefix(String str, TrieNode root) {
    TrieNode node = root;
    int idx = 0;
    while (idx < str.length() - 1) {
      char character = str.charAt(idx);
      node = node.children.get(character);
      if (node.count == 1)
        break;

      idx++;
    }

    return str.substring(0, idx + 1);
  }

  class Trie {
    TrieNode root = new TrieNode();

    public void insert(String str) {
      TrieNode node = root;
      for (int i = 0; i < str.length(); i++) {
        char character = str.charAt(i);
        if (!node.children.containsKey(character))
          node.children.put(character, new TrieNode());
        node = node.children.get(character);
        node.count++;
      }
    }
  }

  class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    int count = 0;
  }
}
