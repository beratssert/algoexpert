import java.util.*;

class Program {
  // O(nlogn) time | O(n) space - n is the length of the array.
  public static List<Integer> longestIncreasingSubsequence(int[] array) {
    int[] sequences = new int[array.length];
    int[] indices = new int[array.length + 1];
    Arrays.fill(indices, -1);

    int length = 0;
    for (int i = 0; i < array.length; i++) {
      int num = array[i];
      int newLength = binarySearch(1, length, indices, array, num);
      sequences[i] = indices[newLength - 1];
      indices[newLength] = i;
      length = Math.max(length, newLength);
    }

    return buildSubsequenceList(array, sequences, indices[length]);
  }

  public static int binarySearch(int start, int end, int[] indices, int[] array, int num) {
    while (start <= end) {
      int middle = (start + end) / 2;
      if (array[indices[middle]] < num)
        start = middle + 1;
      else
        end = middle - 1;
    }

    return start;
  }

  public static List<Integer> buildSubsequenceList(int[] array, int[] sequences, int idx) {
    List<Integer> sequence = new ArrayList<>();
    while (idx != -1) {
      sequence.add(array[idx]);
      idx = sequences[idx];
    }

    Collections.reverse(sequence);
    return sequence;
  }

  // // O(n^2) time | O(n) space - n is the length of the array.
  // public static List<Integer> longestIncreasingSubsequence(int[] array) {
  // int[] sequenceLengths = new int[array.length];
  // Arrays.fill(sequenceLengths, 1);

  // int[] sequenceTrackingIdxs = new int[array.length];
  // Arrays.fill(sequenceTrackingIdxs, -1);

  // int maxSequenceLengthIdx = 0;
  // for (int i = 0; i < array.length; i++) {
  // for (int j = 0; j < i; j++) {
  // if (array[j] < array[i] && sequenceLengths[j] + 1 >= sequenceLengths[i]) {
  // sequenceLengths[i] = sequenceLengths[j] + 1;
  // sequenceTrackingIdxs[i] = j;
  // }
  // }

  // if (sequenceLengths[i] >= sequenceLengths[maxSequenceLengthIdx])
  // maxSequenceLengthIdx = i;
  // }

  // return buildSubsequenceList(array, sequenceTrackingIdxs,
  // maxSequenceLengthIdx);
  // }

  // public static List<Integer> buildSubsequenceList(int[] array, int[]
  // sequences, int idx) {
  // List<Integer> sequence = new ArrayList<>();
  // while (idx != -1) {
  // sequence.add(array[idx]);
  // idx = sequences[idx];
  // }

  // Collections.reverse(sequence);
  // return sequence;
  // }
}
