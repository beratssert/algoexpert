import java.util.*;

class Program {
  // O(n^2 + m) time | O(n + m) time - n is the length of the str, and m is the
  // length of the pattern.
  public static String[] patternMatcher(String pattern, String str) {
    if (pattern.length() > str.length())
      return new String[] {};

    String[] newPattern = getNewPattern(pattern);
    boolean isSwapped = !(newPattern[0].equals(pattern.charAt(0) + ""));
    HashMap<String, Integer> counts = new HashMap<>();
    counts.put("x", 0);
    counts.put("y", 0);
    int firstYOccurence = countPatternsAndGetFirstY(newPattern, counts);

    if (firstYOccurence > 0) {
      for (int lenOfX = 1; lenOfX < str.length(); lenOfX++) {
        double lenOfY = (str.length() - lenOfX * counts.get("x")) / counts.get("y");
        if (lenOfY <= 0 || lenOfY % 1 != 0)
          continue;

        int yIdx = firstYOccurence * lenOfX;
        String x = str.substring(0, lenOfX);
        String y = str.substring(yIdx, yIdx + (int) lenOfY);

        String potentialMatch = buildPotentialMatch(newPattern, x, y);

        if (potentialMatch.equals(str))
          return isSwapped ? new String[] { y, x } : new String[] { x, y };
      }
    } else {
      double lenOfX = str.length() / counts.get("x");
      if (lenOfX % 1 == 0) {
        String x = str.substring(0, (int) lenOfX);
        String potentialMatch = buildPotentialMatch(newPattern, x, "");

        if (potentialMatch.equals(str))
          return isSwapped ? new String[] { "", x } : new String[] { x, "" };
      }
    }

    return new String[] {};
  }

  public static String[] getNewPattern(String pattern) {
    String[] newPattern = new String[pattern.length()];
    boolean willBeSwaped = pattern.charAt(0) == 'y';
    for (int i = 0; i < pattern.length(); i++) {
      if (pattern.charAt(i) == 'y')
        newPattern[i] = willBeSwaped ? "x" : "y";
      else
        newPattern[i] = willBeSwaped ? "y" : "x";
    }

    return newPattern;
  }

  public static int countPatternsAndGetFirstY(String[] pattern, HashMap<String, Integer> counts) {
    int occurance = -1;
    for (int i = 0; i < pattern.length; i++) {
      counts.put(pattern[i], counts.get(pattern[i]) + 1);
      if (pattern[i] == "y" && occurance == -1)
        occurance = i;
    }

    return occurance;
  }

  public static String buildPotentialMatch(String[] pattern, String x, String y) {
    StringBuilder potentialMatch = new StringBuilder();
    for (String string : pattern) {
      if (string.equals("x"))
        potentialMatch.append(x);
      else
        potentialMatch.append(y);
    }

    return potentialMatch.toString();
  }
}
