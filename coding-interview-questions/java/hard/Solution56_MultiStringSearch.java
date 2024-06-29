import java.util.*;

class Program {
  // O(ns + bs) time | O(ns) space - b is the length of the big string, n is the
  // number of small strings, and s is the length of the longest small string.
  public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
    Trie trie = new Trie();
    for (String string : smallStrings) {
      trie.insert(string);
    }

    HashSet<String> containedStrings = new HashSet<>();
    for (int i = 0; i < bigString.length(); i++) {
      findSmallStringIn(bigString, i, trie, containedStrings);
    }

    List<Boolean> result = new ArrayList<>();
    for (String str : smallStrings) {
      result.add(containedStrings.contains(str));
    }

    return result;
  }

  public static void findSmallStringIn(String string, int startingIdx, Trie trie, HashSet<String> containedString) {
    TrieNode node = trie.root;
    for (int i = startingIdx; i < string.length(); i++) {
      char letter = string.charAt(i);
      if (!node.children.containsKey(letter))
        break;

      node = node.children.get(letter);
      if (node.children.containsKey(trie.endingSign))
        containedString.add(node.word);
    }
  }

  static class Trie {
    protected TrieNode root = new TrieNode();
    protected char endingSign = '*';

    public void insert(String str) {
      TrieNode node = root;
      for (int i = 0; i < str.length(); i++) {
        char letter = str.charAt(i);
        if (!node.children.containsKey(letter))
          node.children.put(letter, new TrieNode());

        node = node.children.get(letter);
      }

      node.children.put(endingSign, null);
      node.word = str;
    }
  }

  static class TrieNode {
    private HashMap<Character, TrieNode> children = new HashMap<>();
    protected String word;
  }

  // O(b^2 + ns) time | O(b^2 + n) space - b is the length of the big string, n is
  // the number of small strings, and s is the length of the longest small string.
  // public static List<Boolean> multiStringSearch(String bigString, String[]
  // smallStrings) {
  // SuffixTrie trie = new SuffixTrie(bigString);
  // List<Boolean> result = new ArrayList<>();
  // for (String str : smallStrings) {
  // result.add(trie.contains(str));
  // }

  // return result;
  // }

  // static class SuffixTrie {
  // TrieNode root = new TrieNode();

  // public SuffixTrie(String string) {
  // populateSuffixTreeFrom(string);
  // }

  // private void populateSuffixTreeFrom(String string) {
  // for (int i = 0; i < string.length(); i++) {
  // insertSubstringStartingAt(string, i);
  // }
  // }

  // private void insertSubstringStartingAt(String string, int idx) {
  // TrieNode node = root;
  // for (int i = idx; i < string.length(); i++) {
  // char letter = string.charAt(i);
  // if (!node.children.containsKey(letter))
  // node.children.put(letter, new TrieNode());

  // node = node.children.get(letter);
  // }
  // }

  // public boolean contains(String str) {
  // TrieNode node = root;
  // for (int i = 0; i < str.length(); i++) {
  // char letter = str.charAt(i);
  // if (!node.children.containsKey(letter))
  // return false;

  // node = node.children.get(letter);
  // }

  // return true;
  // }
  // }

  // static class TrieNode {
  // private HashMap<Character, TrieNode> children = new HashMap<>();
  // }

  // O(bns) time | O(n) space - b is the length of the big string, n is the number
  // of small strings, and s is the length of the longest small string.
  // public static List<Boolean> multiStringSearch(String bigString, String[]
  // smallStrings) {
  // boolean[] resultsArray = new boolean[smallStrings.length];
  // for (int i = 0; i < smallStrings.length; i++) {
  // resultsArray[i] = contains(bigString, smallStrings[i]);
  // }

  // ArrayList<Boolean> results = new ArrayList<>();
  // for (Boolean result : resultsArray) {
  // results.add(result);
  // }

  // return results;
  // }

  // public static boolean contains(String bigString, String smallString) {
  // for (int i = 0; i < bigString.length(); i++) {
  // if (i + smallString.length() > bigString.length())
  // return false;

  // if (containsHelper(bigString, smallString, i))
  // return true;
  // }

  // return false;
  // }

  // public static boolean containsHelper(String bigString, String smallString,
  // int startingIdx) {
  // int leftBigIdx = startingIdx;
  // int righBigIdx = startingIdx + smallString.length() - 1;
  // int leftSmallIdx = 0;
  // int rightSmallIdx = smallString.length() - 1;
  // while (leftBigIdx <= righBigIdx) {
  // if (bigString.charAt(leftBigIdx) != smallString.charAt(leftSmallIdx)
  // || bigString.charAt(righBigIdx) != smallString.charAt(rightSmallIdx))
  // return false;

  // leftBigIdx++;
  // righBigIdx--;
  // leftSmallIdx++;
  // rightSmallIdx--;
  // }

  // return true;
  // }
}
