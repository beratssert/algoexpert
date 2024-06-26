import java.util.*;

class Program {
  // O(n * m) time | O(n * m) space - n is the length of the strings, and m is the
  // length of the longest string.
  public String longestMostFrequentPrefix(String[] strings) {
    Trie trie = new Trie();
    for (String string : strings) {
      trie.insert(string);
    }

    return trie.maxPrefixFullString.substring(0, trie.maxPrefixLength);
  }

  class Trie {
    TrieNode root = new TrieNode();
    int maxPrefixCount = 0;
    int maxPrefixLength = 0;
    String maxPrefixFullString = "";

    public void insert(String str) {
      TrieNode node = root;
      for (int i = 0; i < str.length(); i++) {
        Character character = str.charAt(i);
        if (!node.children.containsKey(character))
          node.children.put(character, new TrieNode());

        node = node.children.get(character);
        node.count++;

        if (node.count > maxPrefixCount) {
          maxPrefixCount = node.count;
          maxPrefixLength = i + 1;
          maxPrefixFullString = str;
        } else if (node.count == maxPrefixCount && i + 1 > maxPrefixLength) {
          maxPrefixLength = i + 1;
          maxPrefixFullString = str;
        }
      }
    }
  }

  class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    int count = 0;
  }
}
