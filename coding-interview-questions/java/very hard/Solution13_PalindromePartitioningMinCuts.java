import java.util.*;

class Program {
  // O(n^2) time | O(n^2) space - n is the length of the input str.
  public static int palindromePartitioningMinCuts(String str) {
    boolean[][] isPalindromeSubstring = new boolean[str.length()][str.length()];
    for (int i = 0; i < str.length(); i++) {
      isPalindromeSubstring[i][i] = true;
    }

    for (int length = 2; length < str.length() + 1; length++) {
      for (int i = 0; i < str.length() - length + 1; i++) {
        int j = i + length - 1;
        if (length == 2)
          isPalindromeSubstring[i][j] = str.charAt(i) == str.charAt(j);
        else
          isPalindromeSubstring[i][j] = str.charAt(i) == str.charAt(j) && isPalindromeSubstring[i + 1][j - 1];
      }
    }

    int[] cuts = new int[str.length()];
    for (int i = 0; i < cuts.length; i++) {
      if (isPalindromeSubstring[0][i])
        cuts[i] = 0;
      else {
        cuts[i] = cuts[i - 1] + 1;
        for (int j = 1; j < i; j++) {
          if (isPalindromeSubstring[j][i] && cuts[j - 1] + 1 < cuts[i])
            cuts[i] = cuts[j - 1] + 1;
        }
      }
    }

    return cuts[cuts.length - 1];
  }

  // O(n^3) time | O(n^2) space - n is the length of the input str.
  // public static int palindromePartitioningMinCuts(String str) {
  // boolean[][] isPalindromeSubstring = new boolean[str.length()][str.length()];
  // for (int i = 0; i < str.length(); i++) {
  // for (int j = i; j < isPalindromeSubstring.length; j++) {
  // isPalindromeSubstring[i][j] = isPalindrome(i, j, str);
  // }
  // }

  // int[] cuts = new int[str.length()];
  // for (int i = 0; i < cuts.length; i++) {
  // if (isPalindromeSubstring[0][i])
  // cuts[i] = 0;
  // else {
  // cuts[i] = cuts[i - 1] + 1;
  // for (int j = 1; j < i; j++) {
  // if (isPalindromeSubstring[j][i] && cuts[j - 1] + 1 < cuts[i])
  // cuts[i] = cuts[j - 1] + 1;
  // }
  // }
  // }

  // return cuts[cuts.length - 1];
  // }

  // public static boolean isPalindrome(int start, int end, String str) {
  // while (start < end) {
  // if (str.charAt(start) != str.charAt(end))
  // return false;

  // start++;
  // end--;
  // }

  // return true;
  // }
}
