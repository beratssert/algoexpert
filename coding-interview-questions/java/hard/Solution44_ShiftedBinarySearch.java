import java.util.*;

class Program {
  // O(logn) time | O(1) space - n is the length of the input array.
  public static int shiftedBinarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int middle = (left + right) / 2;
      int potentialMatch = array[middle];
      int leftNum = array[left];
      int rightNum = array[right];

      if (target == potentialMatch)
        return middle;

      if (leftNum < potentialMatch) {
        if (target < potentialMatch && target >= leftNum)
          right = middle - 1;
        else
          left = middle + 1;
      } else {
        if (target > potentialMatch && target <= rightNum)
          left = middle + 1;
        else
          right = middle - 1;
      }
    }

    return -1;
  }

  // O(logn) time | O(logn) space - n is the lenght of the input array/
  // public static int shiftedBinarySearch(int[] array, int target) {
  // return shiftedBinarySearch(array, target, 0, array.length - 1);
  // }

  // public static int shiftedBinarySearch(int[] array, int target, int left, int
  // right) {
  // if (left > right)
  // return -1;

  // int middle = (left + right) / 2;
  // int potentialMatch = array[middle];
  // int leftNum = array[left];
  // int rightNum = array[right];

  // if (target == potentialMatch)
  // return middle;

  // if (leftNum < potentialMatch) {
  // if (target < potentialMatch && target >= leftNum)
  // return shiftedBinarySearch(array, target, left, middle - 1);

  // return shiftedBinarySearch(array, target, middle + 1, right);
  // } else {
  // if (target > potentialMatch && target <= rightNum)
  // return shiftedBinarySearch(array, target, middle + 1, right);

  // return shiftedBinarySearch(array, target, left, middle - 1);
  // }
  // }
}
