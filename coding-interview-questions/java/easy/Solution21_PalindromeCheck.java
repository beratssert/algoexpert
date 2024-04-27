class Program {
  // O(n) time | O(1) space
  public static boolean isPalindrome(String str) {
    int startIdx = 0;
    int endIdx = str.length() - 1;
    while (startIdx < endIdx) {
      if (str.charAt(endIdx) != str.charAt(startIdx)) {
        return false;
      }

      startIdx++;
      endIdx--;
    }

    return true;
  }

  // O(n) time | O(n) space
  // public static boolean isPalindrome(String str) {
  // StringBuilder reversedStr = new StringBuilder();
  // for (int i = str.length() - 1; i >= 0; i--) {
  // reversedStr.append(str.charAt(i));
  // }

  // return str.equals(reversedStr.toString());
  // }

  // O(n) time | O(n) space
  // public static boolean isPalindrome(String str) {
  // return isPalindrome(str, 0);
  // }

  // public static boolean isPalindrome(String str, int i) {
  // int endIdx = str.length() - i - 1;
  // return i >= endIdx ? true : str.charAt(i) == str.charAt(endIdx) &&
  // isPalindrome(str, i + 1);
  // }

  // O(n^2) time | O(1) space
  // public static boolean isPalindrome(String str) {
  // String reversedStr = "";
  // for (int i = str.length() - 1; i >= 0; i--) {
  // reversedStr += str.charAt(i);
  // }

  // return str.equals(reversedStr);
  // }
}
