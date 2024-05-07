import java.util.*;

class Program {
  // O(n) time | O(1) space - n is the length of the shorter string
  public boolean oneEdit(String stringOne, String stringTwo) {
    if (Math.abs(stringOne.length() - stringTwo.length()) > 1)
      return false;

    int idx1 = 0;
    int idx2 = 0;
    boolean editDone = false;
    while (idx1 < stringOne.length() && idx2 < stringTwo.length()) {
      if (stringOne.charAt(idx1) != stringTwo.charAt(idx2)) {
        if (editDone)
          return false;

        editDone = true;
        if (stringOne.length() > stringTwo.length()) {
          idx1++;
        } else if (stringTwo.length() > stringOne.length()) {
          idx2++;
        } else {
          idx1++;
          idx2++;
        }

      } else {
        idx1++;
        idx2++;
      }
    }

    return true;
  }

  // O(n + m) time | O(n + m) space | n, and m are the lengths of the strings
  // public boolean oneEdit(String stringOne, String stringTwo) {
  // int lengthOne = stringOne.length();
  // int lengthTwo = stringTwo.length();
  // if (Math.abs(lengthOne - lengthTwo) > 1)
  // return false;

  // for (int i = 0; i < Math.min(lengthOne, lengthTwo); i++) {
  // if (stringOne.charAt(i) != stringTwo.charAt(i)) {
  // if (lengthOne > lengthTwo)
  // return stringOne.substring(i + 1).equals(stringTwo.substring(i));
  // else if (lengthTwo > lengthOne)
  // return stringOne.substring(i).equals(stringTwo.substring(i + 1));
  // else
  // return stringOne.substring(i + 1).equals(stringTwo.substring(i + 1));
  // }
  // }

  // return true;
  // }
}
