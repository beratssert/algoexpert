import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the length of the number string
  public String bestDigits(String number, int numDigits) {
    Stack<Character> nums = new Stack<>();
    int countForRemoving = numDigits;

    for (int i = 0; i < number.length(); i++) {
      char characterNum = number.charAt(i);
      while (countForRemoving > 0 && !nums.isEmpty() && characterNum > nums.peek()) {
        countForRemoving--;
        nums.pop();
      }

      nums.push(characterNum);
    }

    while (countForRemoving > 0) {
      countForRemoving--;
      nums.pop();
    }

    StringBuilder str = new StringBuilder();
    for (Character character : nums) {
      str.append(character);
    }

    return str.toString();
  }
}
