import java.util.*;

class Program {
  // O(n * m) time | O(n * m) space - n is the length of the words array, m is the
  // longest length of the word.
  public ArrayList<ArrayList<String>> semordnilap(String[] words) {
    ArrayList<ArrayList<String>> semordnilapPairs = new ArrayList<>();
    HashSet<String> wordsSet = new HashSet<String>(Arrays.asList(words));

    for (String word : words) {
      String reversedWord = new StringBuilder(word).reverse().toString();
      if (wordsSet.contains(reversedWord) && !reversedWord.equals(word)) {
        ArrayList<String> pair = new ArrayList<>();
        pair.add(word);
        pair.add(reversedWord);
        semordnilapPairs.add(pair);
        wordsSet.remove(reversedWord);
        wordsSet.remove(word);
      }
    }

    return semordnilapPairs;
  }

}
