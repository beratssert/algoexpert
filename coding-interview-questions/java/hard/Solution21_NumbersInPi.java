import java.util.*;

class Program {
  // O(n^3 + m) time | O(n + m) space - n is the length of the String pi, and m is
  // the total numbers of the numbers
  public static int numbersInPi(String pi, String[] numbers) {
    HashSet<String> numbersStorage = new HashSet<>();
    for (String num : numbers) {
      numbersStorage.add(num);
    }

    HashMap<Integer, Integer> cache = new HashMap<>();
    int minSpace = getMinSpace(pi, numbersStorage, cache, 0);

    return minSpace == Integer.MAX_VALUE ? -1 : minSpace;
  }

  public static int getMinSpace(String pi, HashSet<String> numbersStorage,
      HashMap<Integer, Integer> cache, int idx) {
    if (idx == pi.length())
      return -1;

    if (cache.containsKey(idx))
      return cache.get(idx);

    int minSpace = Integer.MAX_VALUE;
    for (int i = idx; i < pi.length(); i++) {
      String prefix = pi.substring(idx, i + 1);
      if (numbersStorage.contains(prefix)) {
        int minSpaceOfSuffix = getMinSpace(pi, numbersStorage, cache, i + 1);
        minSpace = Math.min(minSpace, minSpaceOfSuffix == Integer.MAX_VALUE ? minSpaceOfSuffix : minSpaceOfSuffix + 1);
      }
    }

    cache.put(idx, minSpace);
    return minSpace;
  }

  // O(n^3 + m) time | O(n + m) space - n is the length of the String pi, and m is
  // the total numbers of the numbers
  // public static int numbersInPi(String pi, String[] numbers) {
  // HashSet<String> numbersStorage = new HashSet<>();
  // for (String num : numbers) {
  // numbersStorage.add(num);
  // }

  // HashMap<Integer, Integer> cache = new HashMap<>();
  // for (int i = pi.length() - 1; i >= 0; i--) {
  // getMinSpace(pi, numbersStorage, cache, i);
  // }

  // return cache.get(0) == Integer.MAX_VALUE ? -1 : cache.get(0);
  // }

  // public static int getMinSpace(String pi, HashSet<String> numbersStorage,
  // HashMap<Integer, Integer> cache, int idx) {
  // if (idx == pi.length())
  // return -1;

  // if (cache.containsKey(idx))
  // return cache.get(idx);

  // int minSpace = Integer.MAX_VALUE;
  // for (int i = idx; i < pi.length(); i++) {
  // String prefix = pi.substring(idx, i + 1);
  // if (numbersStorage.contains(prefix)) {
  // int minSpaceOfSuffix = getMinSpace(pi, numbersStorage, cache, i + 1);
  // minSpace = Math.min(minSpace, minSpaceOfSuffix == Integer.MAX_VALUE ?
  // minSpaceOfSuffix : minSpaceOfSuffix + 1);
  // }
  // }

  // cache.put(idx, minSpace);
  // return minSpace;
  // }
}
