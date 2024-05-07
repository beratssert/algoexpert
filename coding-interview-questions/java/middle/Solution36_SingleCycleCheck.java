class Program {
  // O(n) time | O(1) space - n is the length of the array.
  public static boolean hasSingleCycle(int[] array) {
    int visitedNumbers = 0;
    int idx = 0;
    while (visitedNumbers < array.length) {
      if (visitedNumbers > 0 && idx == 0)
        return false;
      visitedNumbers++;
      idx = getNewIdx(idx, array);
    }

    return idx == 0;
  }

  public static int getNewIdx(int idx, int[] array) {
    int newIdx = (idx + array[idx]) % array.length;
    return newIdx < 0 ? (newIdx + array.length) : newIdx;
  }
}
