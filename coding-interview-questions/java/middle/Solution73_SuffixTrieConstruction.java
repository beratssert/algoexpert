import java.util.*;

class Program {
  // Do not edit the class below except for the
  // populateSuffixTrieFrom and contains methods.
  // Feel free to add new properties and methods
  // to the class.
  static class TrieNode {
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  }

  static class SuffixTrie {
    TrieNode root = new TrieNode();
    char endSymbol = '*';

    public SuffixTrie(String str) {
      populateSuffixTrieFrom(str);
    }

    // O(n^2) time | O(n^2) space - n is the length of the string
    public void populateSuffixTrieFrom(String str) {
      for (int i = 0; i < str.length(); i++) {
        TrieNode node = root;
        for (int j = i; j < str.length(); j++) {
          char letter = str.charAt(j);
          if (!node.children.containsKey(letter))
            node.children.put(letter, new TrieNode());
          node = node.children.get(letter);
        }

        node.children.put(endSymbol, null);
      }
    }

    // O(n) time | O(1) space - n is the length of the string
    public boolean contains(String str) {
      TrieNode node = root;
      for (int i = 0; i < str.length(); i++) {
        char letter = str.charAt(i);
        if (!node.children.containsKey(letter))
          return false;
        node = node.children.get(letter);
      }

      return node.children.containsKey(endSymbol);
    }
  }
}
