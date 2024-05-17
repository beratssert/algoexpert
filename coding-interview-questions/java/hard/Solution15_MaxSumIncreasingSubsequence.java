import java.util.*;

class Program {
  // O(n^2) time | O(n) space - n is the total number of the elements in the array
  public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
    Integer[] seq = new Integer[array.length];

    int[] sums = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      sums[i] = array[i];
    }

    int maxSumIdx = 0;
    for (int i = 0; i < array.length; i++) {
      int currentNum = array[i];
      for (int j = 0; j < i; j++) {
        int otherNum = array[j];
        if (currentNum > otherNum && currentNum + sums[j] >= sums[i]) {
          sums[i] = currentNum + sums[j];
          seq[i] = j;
        }
      }

      maxSumIdx = sums[i] >= sums[maxSumIdx] ? i : maxSumIdx;
    }

    List<List<Integer>> result = new ArrayList<>();
    result.add(List.of(sums[maxSumIdx]));
    result.add(getSequenceNumbers(maxSumIdx, seq, array));

    return result;
  }

  public static List<Integer> getSequenceNumbers(int maxSumIdx, Integer[] seq, int[] array) {
    List<Integer> seqNums = new ArrayList<>();

    Integer idx = maxSumIdx;
    while (idx != null) {
      seqNums.add(array[idx]);
      idx = seq[idx];
    }

    Collections.reverse(seqNums);
    return seqNums;
  }
}
