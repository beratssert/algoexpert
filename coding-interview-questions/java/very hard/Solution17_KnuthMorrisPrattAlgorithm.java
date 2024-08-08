import java.util.*;

class Program {
  // O(n + m) time | O(m) space - n is the length of the string, m is the length
  // of the substring.
  public static boolean knuthMorrisPrattAlgorithm(String string, String substring) {
    int[] pattern = buildPattern(substring);
    return doesMatch(string, substring, pattern);
  }

  public static int[] buildPattern(String subString) {
    int[] pattern = new int[subString.length()];
    Arrays.fill(pattern, -1);

    int i = 0;
    int j = 1;
    while (j < subString.length()) {
      if (subString.charAt(i) == subString.charAt(j)) {
        pattern[j] = i;
        i++;
        j++;
      } else if (i > 0)
        i = pattern[i - 1] + 1;
      else
        j++;
    }

    return pattern;
  }

  public static boolean doesMatch(String string, String substring, int[] pattern) {
    int idxOfStr = 0;
    int idxOfSubstr = 0;
    while (idxOfStr + substring.length() - idxOfSubstr <= string.length()) {
      if (string.charAt(idxOfStr) == substring.charAt(idxOfSubstr)) {
        idxOfStr++;
        idxOfSubstr++;
      } else if (idxOfSubstr > 0)
        idxOfSubstr = pattern[idxOfSubstr - 1] + 1;
      else
        idxOfStr++;

      if (idxOfSubstr == substring.length())
        return true;
    }

    return false;
  }
}
