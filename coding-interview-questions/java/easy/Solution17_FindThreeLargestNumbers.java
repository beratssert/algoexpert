import java.util.*;

class Program {
  // O(n) time | O(1) space - n is the length of the array.
  public static int[] findThreeLargestNumbers(int[] array) {
    int[] largestNums = { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE };
    for (int num : array) {
      findThreeLargestNumbers(largestNums, num);
    }
    return largestNums;
  }

  public static void findThreeLargestNumbers(int[] largestNums, int num) {
    if (num > largestNums[2]) {
      updateArray(largestNums, num, 2);
    } else if (num > largestNums[1]) {
      updateArray(largestNums, num, 1);
    } else if (num > largestNums[0]) {
      updateArray(largestNums, num, 0);
    }
  }

  public static void updateArray(int[] array, int num, int idx) {
    for (int i = 0; i <= idx; i++) {
      if (i == idx) {
        array[i] = num;
      } else {
        array[i] = array[i + 1];
      }
    }
  }
}
