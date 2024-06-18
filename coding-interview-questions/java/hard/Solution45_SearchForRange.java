import java.util.*;

class Program {
  // O(logn) time | O(1) space - n is the length of the input array.
  public static int[] searchForRange(int[] array, int target) {
    int[] finalRange = new int[] { -1, -1 };
    searchForRange(array, target, 0, array.length - 1, finalRange, true);
    searchForRange(array, target, 0, array.length - 1, finalRange, false);
    return finalRange;
  }

  public static void searchForRange(int[] array, int target, int left, int right, int[] finalRange, boolean goLeft) {
    while (left <= right) {
      int middle = (left + right) / 2;
      int middleNum = array[middle];

      if (target < middleNum)
        right = middle - 1;
      else if (target > middleNum)
        left = middle + 1;
      else {
        if (goLeft) {
          if (middle == 0 || array[middle - 1] != target) {
            finalRange[0] = middle;
            return;
          } else {
            right = middle - 1;
          }
        } else {
          if (middle == array.length - 1 || array[middle + 1] != target) {
            finalRange[1] = middle;
            return;
          } else {
            left = middle + 1;
          }
        }
      }
    }
  }

  // // O(logn) time | O(logn) space - n is the length of the input array.
  // public static int[] searchForRange(int[] array, int target) {
  // int[] finalRange = new int[] { -1, -1 };
  // searchForRange(array, target, 0, array.length - 1, finalRange, true);
  // searchForRange(array, target, 0, array.length - 1, finalRange, false);
  // return finalRange;
  // }

  // public static void searchForRange(int[] array, int target, int left, int
  // right, int[] finalRange, boolean goLeft) {
  // if (left > right)
  // return;

  // int middle = (left + right) / 2;
  // int middleNum = array[middle];

  // if (target < middleNum)
  // searchForRange(array, target, left, middle - 1, finalRange, goLeft);
  // else if (target > middleNum)
  // searchForRange(array, target, middle + 1, right, finalRange, goLeft);
  // else {
  // if (goLeft) {
  // if (middle == 0 || array[middle - 1] != target) {
  // finalRange[0] = middle;
  // } else {
  // searchForRange(array, target, left, middle - 1, finalRange, goLeft);
  // }
  // } else {
  // if (middle == array.length - 1 || array[middle + 1] != target) {
  // finalRange[1] = middle;
  // } else {
  // searchForRange(array, target, middle + 1, right, finalRange, goLeft);
  // }
  // }
  // }
  // }
}
