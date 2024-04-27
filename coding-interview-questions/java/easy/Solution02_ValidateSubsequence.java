import java.util.*;

class Program {
  // O(n) time | O(1) space - n is the length of the array
  public static boolean isValidSubsequence(
      List<Integer> array, List<Integer> sequence) {
    int idx = 0;
    for (int num : array) {
      if (idx == sequence.size()) {
        break;
      }

      if (sequence.get(idx).equals(num)) {
        idx++;
      }
    }

    return idx == sequence.size();
  }

  // O(n) time | O(1) space - n is the length of the array
  // public static boolean isValidSubsequence(
  // List<Integer> array, List<Integer> sequence) {
  // int seqIdx = 0;
  // int arrIdx = 0;

  // while (seqIdx < sequence.size() && arrIdx < array.size()) {
  // if (array.get(arrIdx).equals(sequence.get(seqIdx))) {
  // seqIdx++;
  // }
  // arrIdx++;
  // }

  // return seqIdx == sequence.size();
  // }
}