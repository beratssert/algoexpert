import java.util.*;

class Program {
  // O(logn) time | O(1) space - n is the length of the array.
  public static int binarySearch(int[] array, int target) {
    return binarySearch(array, target, 0, array.length - 1);
  }

  public static int binarySearch(int[] array, int target, int start, int end) {
    while (start <= end) {
      int middle = (start + end) / 2;
      int num = array[middle];
      if (target == num) {
        return middle;
      } else if (target < num) {
        end = middle - 1;
      } else {
        start = middle + 1;
      }
    }

    return -1;
  }

  // O(logn) time | O(logn) space - n is the length of the array.
  // public static int binarySearch(int[] array, int target) {
  // return binarySearch(array, target, 0, array.length - 1);
  // }

  // public static int binarySearch(int[] array, int target, int start, int end) {
  // if (start > end)
  // return -1;

  // int middle = (start + end) / 2;
  // int num = array[middle];
  // if (target == num) {
  // return middle;
  // } else if (target < num) {
  // return binarySearch(array, target, start, middle - 1);
  // } else {
  // return binarySearch(array, target, middle + 1, end);
  // }
  // }
}
