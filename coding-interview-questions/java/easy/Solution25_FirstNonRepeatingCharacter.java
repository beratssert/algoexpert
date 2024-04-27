import java.util.*;

class Program {
  // O(n) time | O(1) space - n is the length of the string, constant space
  // because input string is only lowercase english alphabet letters.
  public int firstNonRepeatingCharacter(String string) {
    HashMap<Character, Integer> charCounts = new HashMap<>();
    for (int i = 0; i < string.length(); i++) {
      char letter = string.charAt(i);
      charCounts.put(letter, charCounts.getOrDefault(letter, 0) + 1);
    }

    for (int i = 0; i < string.length(); i++) {
      int freq = charCounts.get(string.charAt(i));
      if (freq == 1) {
        return i;
      }
    }

    return -1;
  }

  // O(n^2) time | O(1) space
  // public int firstNonRepeatingCharacter(String string) {
  // for (int i = 0; i < string.length(); i++) {
  // boolean isDuplicate = false;
  // for (int j = 0; j < string.length(); j++) {
  // if (string.charAt(i) == string.charAt(j) && i != j) {
  // isDuplicate = true;
  // }
  // }

  // if (!isDuplicate)
  // return i;
  // }

  // return -1;
  // }
}
