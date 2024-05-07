import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the length of the input string
  public String reverseWordsInString(String string) {
    Stack<String> words = new Stack<>();

    int start = 0;
    int idx = 0;
    while (idx < string.length()) {
      char letter = string.charAt(idx);
      if (letter == ' ') {
        words.push(string.substring(start, idx));
        start = idx;
      } else if (string.charAt(start) == ' ') {
        words.push(" ");
        start++;
      }

      idx++;
    }

    words.push(string.substring(start, idx));

    StringBuilder str = new StringBuilder();
    while (!words.isEmpty()) {
      str.append(words.pop());
    }

    return str.toString();
  }
}
