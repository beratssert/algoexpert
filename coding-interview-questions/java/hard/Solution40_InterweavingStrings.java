import java.util.*;

class Program {
  // O(nm) time | O(nm) space - n is the length of the string one, and m is the
  // length of string two.
  public static boolean interweavingStrings(
      String one, String two, String three) {
    if (three.length() != one.length() + two.length())
      return false;

    Boolean[][] cache = new Boolean[one.length() + 1][two.length() + 1];
    return areInterweavingStrings(one, two, three, 0, 0, cache);
  }

  public static boolean areInterweavingStrings(String one, String two, String three, int idxOne, int idxTwo,
      Boolean[][] cache) {
    if (cache[idxOne][idxTwo] != null)
      return cache[idxOne][idxTwo];

    int idxThree = idxOne + idxTwo;
    if (idxThree == three.length())
      return true;

    if (idxOne < one.length() && one.charAt(idxOne) == three.charAt(idxThree)) {
      cache[idxOne][idxTwo] = areInterweavingStrings(one, two, three, idxOne + 1, idxTwo, cache);
      if (cache[idxOne][idxTwo])
        return true;
    }

    if (idxTwo < two.length() && two.charAt(idxTwo) == three.charAt(idxThree)) {
      cache[idxOne][idxTwo] = areInterweavingStrings(one, two, three, idxOne, idxTwo + 1, cache);
      return cache[idxOne][idxTwo];
    }

    cache[idxOne][idxTwo] = false;
    return false;
  }

  // O(2^(n + m)) time | O(n + m) space - n and m are the lengths of the one and
  // two input strings, respectively.
  // public static boolean interweavingStrings(
  // String one, String two, String three) {
  // if (three.length() != one.length() + two.length())
  // return false;

  // return areInterweavingStrings(one, two, three, 0, 0);
  // }

  // public static boolean areInterweavingStrings(String one, String two, String
  // three, int idxOne, int idxTwo) {
  // int idxThree = idxOne + idxTwo;
  // if (idxThree == three.length())
  // return true;

  // if (idxOne < one.length() && one.charAt(idxOne) == three.charAt(idxThree)) {
  // if (areInterweavingStrings(one, two, three, idxOne + 1, idxTwo))
  // return true;
  // }

  // if (idxTwo < two.length() && two.charAt(idxTwo) == three.charAt(idxThree)) {
  // return areInterweavingStrings(one, two, three, idxOne, idxTwo + 1);
  // }

  // return false;
  // }
}
