class Program {
  // O(n) time | O(1) space - n is the length of the array.
  public static int longestPeak(int[] array) {
    int longestLength = 0;
    int idx = 1;
    while (idx < array.length - 1) {
      boolean isPeak = array[idx] > array[idx - 1] && array[idx] > array[idx + 1];
      if (!isPeak) {
        idx++;
        continue;
      }

      int leftIdx = idx - 2;
      while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
        leftIdx--;
      }

      int rightIdx = idx + 2;
      while (rightIdx < array.length && array[rightIdx] < array[rightIdx - 1]) {
        rightIdx++;
      }

      int currentLength = rightIdx - leftIdx - 1;
      longestLength = Math.max(currentLength, longestLength);

      idx = rightIdx;
    }

    return longestLength;
  }
}
