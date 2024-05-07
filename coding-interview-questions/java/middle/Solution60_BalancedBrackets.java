import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the length of the string
  public static boolean balancedBrackets(String str) {
    Stack<Character> brackets = new Stack<>();
    HashMap<Character, Character> matches = new HashMap<>();
    matches.put('}', '{');
    matches.put(']', '[');
    matches.put(')', '(');

    for (int i = 0; i < str.length(); i++) {
      char letter = str.charAt(i);
      if (letter == '[' || letter == '(' || letter == '{')
        brackets.push(letter);
      else if (letter == ']' || letter == ')' || letter == '}') {
        if (brackets.isEmpty())
          return false;

        char bracket = brackets.pop();
        if (bracket != matches.get(letter))
          return false;
      }
    }

    return brackets.isEmpty();
  }
}
