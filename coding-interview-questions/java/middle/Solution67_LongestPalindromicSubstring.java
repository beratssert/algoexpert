import java.util.*;

class Program {
  // O(n^2) time | O(n) space - n is the length of the input string.
  public static String longestPalindromicSubstring(String str) {
    int[] palindrome = new int[] { 0, 1 };
    for (int i = 1; i < str.length(); i++) {
      int[] odd = getPalindrome(str, i - 1, i + 1);
      int[] even = getPalindrome(str, i - 1, i);

      int[] max = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
      palindrome = max[1] - max[0] > palindrome[1] - palindrome[0] ? max : palindrome;
    }

    return str.substring(palindrome[0], palindrome[1]);
  }

  public static int[] getPalindrome(String str, int left, int right) {
    while (left >= 0 && right < str.length()) {
      if (str.charAt(right) != str.charAt(left))
        break;
      left--;
      right++;
    }

    return new int[] { left + 1, right };
  }
}
