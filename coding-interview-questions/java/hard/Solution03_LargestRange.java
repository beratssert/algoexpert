import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the length of the array
  public static int[] largestRange(int[] array) {
    int[] largestRange = new int[2];
    int longestLength = 0;
    Map<Integer, Boolean> isVisited = new HashMap<>();
    for (int num : array) {
      isVisited.put(num, false);
    }

    for (int num : array) {
      if (isVisited.get(num))
        continue;

      isVisited.put(num, true);
      int currentLength = 1;
      int left = num - 1;
      int right = num + 1;
      while (isVisited.containsKey(left)) {
        currentLength++;
        isVisited.put(left, true);
        left--;
      }

      while (isVisited.containsKey(right)) {
        currentLength++;
        isVisited.put(right, true);
        right++;
      }

      if (currentLength > longestLength) {
        longestLength = currentLength;
        largestRange[0] = left + 1;
        largestRange[1] = right - 1;
      }
    }

    return largestRange;
  }
}
