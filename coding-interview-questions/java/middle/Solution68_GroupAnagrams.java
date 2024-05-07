import java.util.*;

class Program {
  // O(wnlogn) time | O(wn) space - w is the number of the words in the input
  // words string, n is the longest word.
  public static List<List<String>> groupAnagrams(List<String> words) {
    HashMap<String, List<String>> anagrams = new HashMap<>();
    for (String word : words) {
      char[] chars = word.toCharArray();
      Arrays.sort(chars);
      String sortedWord = new String(chars);
      if (anagrams.containsKey(sortedWord))
        anagrams.get(sortedWord).add(word);
      else
        anagrams.put(sortedWord, new ArrayList<>(Arrays.asList(word)));
    }

    return new ArrayList<>(anagrams.values());
  }

}
