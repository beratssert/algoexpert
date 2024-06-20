import java.util.*;

class Program {
  // O(n) time | O(min(n, a)) space - n is the length of the str, and a is the
  // number of unique chars in the alphabet
  public static String longestSubstringWithoutDuplication(String str) {
    HashMap<Character, Integer> lastSeen = new HashMap<>();
    int[] subStrIdx = new int[] { 0, 1 };
    int startingIdx = 0;
    for (int i = 0; i < str.length(); i++) {
      char character = str.charAt(i);
      if (lastSeen.containsKey(character))
        startingIdx = Math.max(startingIdx, lastSeen.get(character) + 1);

      if (subStrIdx[1] - subStrIdx[0] < i + 1 - startingIdx) {
        subStrIdx[0] = startingIdx;
        subStrIdx[1] = i + 1;
      }

      lastSeen.put(character, i);
    }

    return str.substring(subStrIdx[0], subStrIdx[1]);
  }
}
