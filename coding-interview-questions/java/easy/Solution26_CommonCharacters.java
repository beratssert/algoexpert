import java.util.*;

class Program {
  // O(n * m) time | O(c) space - n is the number od the strings, m is the length
  // of the longest string, and c is the unique characters across all strings.
  public String[] commonCharacters(String[] strings) {
    HashMap<Character, Integer> charCounts = new HashMap<Character, Integer>();
    for (String string : strings) {
      HashSet<Character> uniqeChars = new HashSet<Character>();
      for (int i = 0; i < string.length(); i++) {
        uniqeChars.add(string.charAt(i));
      }

      for (char character : uniqeChars) {
        charCounts.put(character, charCounts.getOrDefault(character, 0) + 1);
      }
    }

    ArrayList<Character> common = new ArrayList<Character>();
    for (Map.Entry<Character, Integer> characterCount : charCounts.entrySet()) {
      Character character = characterCount.getKey();
      Integer count = characterCount.getValue();
      if (count == strings.length) {
        common.add(character);
      }
    }

    String[] commonChars = new String[common.size()];
    for (int i = 0; i < commonChars.length; i++) {
      commonChars[i] = common.get(i).toString();
    }

    return commonChars;
  }
}
