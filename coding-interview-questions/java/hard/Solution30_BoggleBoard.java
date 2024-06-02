import java.util.*;

class Program {
  // O(nm + wh*8^m) time | O(wh + mn) - n is the number of the words, m is the
  // length of the longest word, w is the width of the board, and h is the height
  // of the board.
  public static List<String> boggleBoard(char[][] board, String[] words) {
    Trie wordsTrie = new Trie(words);
    Set<String> wordsFound = new HashSet<>();
    boolean[][] visited = new boolean[board.length][board[0].length];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        explore(i, j, board, visited, wordsFound, wordsTrie.root);
      }
    }

    return new ArrayList<String>(wordsFound);
  }

  public static void explore(int i, int j, char[][] board, boolean[][] visited, Set<String> wordsFound,
      TrieNode wordsTrieNode) {
    if (visited[i][j])
      return;

    char letter = board[i][j];
    if (!wordsTrieNode.children.containsKey(letter))
      return;

    visited[i][j] = true;
    wordsTrieNode = wordsTrieNode.children.get(letter);
    if (wordsTrieNode.children.containsKey('*')) {
      wordsFound.add(wordsTrieNode.word);
    }

    Stack<int[]> neighbours = getNeighbours(i, j, board);
    while (!neighbours.isEmpty()) {
      int[] neighbour = neighbours.pop();
      explore(neighbour[0], neighbour[1], board, visited, wordsFound, wordsTrieNode);
    }

    visited[i][j] = false;
  }

  public static Stack<int[]> getNeighbours(int i, int j, char[][] board) {
    Stack<int[]> neighbours = new Stack<>();

    if (i > 0)
      neighbours.add(new int[] { i - 1, j });
    if (i > 0 && j < board[0].length - 1)
      neighbours.add(new int[] { i - 1, j + 1 });
    if (j < board[0].length - 1)
      neighbours.add(new int[] { i, j + 1 });
    if (i < board.length - 1 && j < board[0].length - 1)
      neighbours.add(new int[] { i + 1, j + 1 });
    if (i < board.length - 1)
      neighbours.add(new int[] { i + 1, j });
    if (i < board.length - 1 && j > 0)
      neighbours.add(new int[] { i + 1, j - 1 });
    if (j > 0)
      neighbours.add(new int[] { i, j - 1 });
    if (i > 0 && j > 0)
      neighbours.add(new int[] { i - 1, j - 1 });

    return neighbours;
  }
}

class Trie {
  protected TrieNode root = new TrieNode();
  protected char endWord = '*';

  public Trie(String[] words) {
    for (String word : words) {
      add(word);
    }
  }

  public void add(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char letter = word.charAt(i);
      if (!node.children.containsKey(letter)) {
        TrieNode newNode = new TrieNode();
        node.children.put(letter, newNode);
      }

      node = node.children.get(letter);
    }

    node.children.put(endWord, null);
    node.word = word;
  }
}

class TrieNode {
  Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  String word = "";
}