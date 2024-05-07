class Program {
  // O(nm) time | O(min(n, m)) space - n and m are the lengths of the each string.
  public static int levenshteinDistance(String str1, String str2) {
    String small = str1.length() < str2.length() ? str1 : str2;
    String big = str1.length() >= str2.length() ? str1 : str2;
    int[] evenRows = new int[small.length() + 1];
    int[] oddRows = new int[small.length() + 1];

    for (int j = 0; j < evenRows.length; j++) {
      evenRows[j] = j;
    }

    for (int row = 1; row < big.length() + 1; row++) {
      int current[];
      int prev[];

      if (row % 2 == 0) {
        current = evenRows;
        prev = oddRows;
      } else {
        current = oddRows;
        prev = evenRows;
      }

      current[0] = row;

      for (int col = 1; col < small.length() + 1; col++) {
        if (small.charAt(col - 1) == big.charAt(row - 1)) {
          current[col] = prev[col - 1];
        } else {
          current[col] = Math.min(Math.min(current[col - 1], prev[col]), prev[col - 1])
              + 1;
        }
      }
    }

    return big.length() % 2 == 0 ? evenRows[small.length()] : oddRows[small.length()];
  }

  // O(nm) time | O(nm) space - n and m are the lengths of the each string.
  // public static int levenshteinDistance(String str1, String str2) {
  // int[][] edits = new int[str1.length() + 1][str2.length() + 1];
  // for (int i = 1; i < edits.length; i++) {
  // edits[i][0] = edits[i - 1][0] + 1;
  // }

  // for (int i = 1; i < edits[0].length; i++) {
  // edits[0][i] = edits[0][i - 1] + 1;
  // }

  // for (int row = 1; row < edits.length; row++) {
  // for (int col = 1; col < edits[row].length; col++) {
  // if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
  // edits[row][col] = edits[row - 1][col - 1];
  // } else {
  // edits[row][col] = 1 + Math.min(Math.min(edits[row][col - 1], edits[row -
  // 1][col]), edits[row - 1][col - 1]);
  // }
  // }
  // }

  // return edits[edits.length - 1][edits[0].length - 1];
  // }
}
