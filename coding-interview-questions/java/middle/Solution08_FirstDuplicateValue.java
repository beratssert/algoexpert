import java.util.*;

class Program {
  // O(n) time | O(1) space
  public int firstDuplicateValue(int[] array) {
    for (int num : array) {
      int absNum = Math.abs(num);
      if (array[absNum - 1] < 0)
        return absNum;
      array[absNum - 1] *= -1;
    }

    return -1;
  }

  // O(n) time | O(n) space - n is the length of the array.
  // public int firstDuplicateValue(int[] array) {
  // HashSet<Integer> occurance = new HashSet<>();
  // for (int num : array) {
  // if (occurance.contains(num))
  // return num;

  // occurance.add(num);
  // }

  // return -1;
  // }

  // O(n^2) time | O(1) space
  // public int firstDuplicateValue(int[] array) {
  // int minIdx = array.length;
  // for (int i = 0; i < array.length - 1; i++) {
  // int num = array[i];
  // for (int j = i + 1; j < array.length; j++) {
  // if (num == array[j]) {
  // minIdx = Math.min(minIdx, j);
  // }
  // }
  // }

  // return minIdx == array.length ? -1 : array[minIdx];
  // }
}
