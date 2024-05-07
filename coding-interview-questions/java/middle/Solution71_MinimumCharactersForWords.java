import java.util.*;

class Program {
  // O(nl) time | O(nl) space - n is the number of the words, and l is the longest
  // word
  // O(c) time | O(c) space - c is all characters in the input string
  public char[] minimumCharactersForWords(String[] words) {
    HashMap<Character, Integer> counts = new HashMap<>();
    for (String word : words) {
      HashMap<Character, Integer> wordCounts = getCounts(word);
      for (Map.Entry<Character, Integer> entry : wordCounts.entrySet()) {
        if (counts.containsKey(entry.getKey())) {
          counts.put(entry.getKey(), Math.max(entry.getValue(), counts.get(entry.getKey())));
        } else {
          counts.put(entry.getKey(), entry.getValue());
        }
      }
    }

    return mapToArray(counts);
  }

  public HashMap<Character, Integer> getCounts(String word) {
    HashMap<Character, Integer> counts = new HashMap<>();
    for (int i = 0; i < word.length(); i++) {
      char letter = word.charAt(i);
      if (counts.containsKey(letter)) {
        counts.put(letter, counts.get(letter) + 1);
      } else {
        counts.put(letter, 1);
      }
    }
    return counts;
  }

  public char[] mapToArray(HashMap<Character, Integer> counts) {
    ArrayList<Character> chars = new ArrayList<>();
    for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
      for (int i = 0; i < entry.getValue(); i++) {
        chars.add(entry.getKey());
      }
    }

    char[] charArr = new char[chars.size()];
    for (int i = 0; i < charArr.length; i++) {
      charArr[i] = chars.get(i);
    }

    return charArr;
  }
}
