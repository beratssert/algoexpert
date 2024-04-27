import java.util.*;

class Program {
  // O(n + m) time | O(c) space - n is the number of the characters, m is the
  // length of the document, and c is the number of the unique characters in the
  // characters string.
  public static boolean generateDocument(String characters, String document) {
    HashMap<Character, Integer> charactersCount = new HashMap<Character, Integer>();
    for (int i = 0; i < characters.length(); i++) {
      char letter = characters.charAt(i);
      charactersCount.put(letter, charactersCount.getOrDefault(letter, 0) + 1);
    }

    for (int i = 0; i < document.length(); i++) {
      char letter = document.charAt(i);
      if (!charactersCount.containsKey(letter) || charactersCount.get(letter) == 0) {
        return false;
      }
      charactersCount.put(letter, charactersCount.get(letter) - 1);
    }

    return true;
  }

  // O(m * (m + n)) time | O(1) space - m is the length of the document, n is the
  // number of the characters.
  // public static boolean generateDocument(String characters, String document) {
  // for (int i = 0; i < document.length(); i++) {
  // char letter = document.charAt(i);
  // int charactersFrequency = getFrequency(letter, characters);
  // int documentFrequency = getFrequency(letter, document);
  // if (documentFrequency > charactersFrequency) {
  // return false;
  // }
  // }

  // return true;
  // }

  // public static int getFrequency(char letter, String string) {
  // int freq = 0;
  // for (int i = 0; i < string.length(); i++) {
  // if (string.charAt(i) == letter) {
  // freq++;
  // }
  // }

  // return freq;
  // }

  // O(c * (n + m)) time | O(c) space - n is the number of the characters, m is
  // the length of the document, and c is the number of the unique characters in
  // the characters string.
  // public static boolean generateDocument(String characters, String document) {
  // Set<Character> alreadyCounted = new HashSet<Character>();

  // for (int i = 0; i < document.length(); i++) {
  // char letter = document.charAt(i);
  // if (alreadyCounted.contains(letter)) {
  // continue;
  // }

  // int charactersFreq = getFrequency(letter, characters);
  // int documentFreq = getFrequency(letter, document);
  // if (documentFreq > charactersFreq) {
  // return false;
  // }

  // alreadyCounted.add(letter);
  // }

  // return true;
  // }

  // public static int getFrequency(char letter, String string) {
  // int freq = 0;
  // for (int i = 0; i < string.length(); i++) {
  // if (string.charAt(i) == letter) {
  // freq++;
  // }
  // }

  // return freq;
  // }
}
