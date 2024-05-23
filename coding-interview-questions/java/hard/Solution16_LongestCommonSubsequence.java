import java.util.*;

class Program {
  // O(nm) time | O(nm) space - n and m is the lengths of the str1 and str2.
  public static List<Character> longestCommonSubsequence(String str1, String str2) {
    int[][] lcsLength = new int[str1.length() + 1][str2.length() + 1];
    for (int i = 1; i < str1.length() + 1; i++) {
      for (int j = 1; j < str2.length() + 1; j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          lcsLength[i][j] = lcsLength[i - 1][j - 1] + 1;
        } else {
          lcsLength[i][j] = Math.max(lcsLength[i - 1][j], lcsLength[i][j - 1]);
        }
      }
    }

    return buildSequence(lcsLength, str1);
  }

  public static List<Character> buildSequence(int[][] lcsLength, String str) {
    List<Character> sequence = new ArrayList<>();

    int row = lcsLength.length - 1;
    int col = lcsLength[0].length - 1;
    while (row != 0 && col != 0) {
      if (lcsLength[row][col] == lcsLength[row - 1][col]) {
        row--;
      } else if (lcsLength[row][col] == lcsLength[row][col - 1]) {
        col--;
      } else {
        sequence.add(str.charAt(row - 1));
        row--;
        col--;
      }
    }

    Collections.reverse(sequence);
    return sequence;
  }

  // O(nm * min(n, m)) time | O(nm * min(n, m)) space - m and n is the lengths of
  // the str1 and str2.
  // public static List<Character> longestCommonSubsequence(String str1, String
  // str2) {
  // List<List<List<Character>>> lcs = new ArrayList<>();
  // for (int i = 0; i < str1.length() + 1; i++) {
  // lcs.add(new ArrayList<List<Character>>());
  // for (int j = 0; j < str2.length() + 1; j++) {
  // lcs.get(i).add(new ArrayList<Character>());
  // }
  // }

  // for (int i = 1; i < str1.length() + 1; i++) {
  // for (int j = 1; j < str2.length() + 1; j++) {
  // if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
  // List<Character> diagonal = new ArrayList<Character>(lcs.get(i - 1).get(j -
  // 1));
  // diagonal.add(str1.charAt(i - 1));
  // lcs.get(i).set(j, diagonal);
  // } else {
  // List<Character> left = lcs.get(i).get(j - 1);
  // List<Character> up = lcs.get(i - 1).get(j);
  // lcs.get(i).set(j, left.size() > up.size() ? left : up);
  // }
  // }

  // }

  // return lcs.get(str1.length()).get(str2.length());
  // }
}
