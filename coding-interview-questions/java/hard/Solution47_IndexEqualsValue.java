import java.util.*;

class Program {
  // O(logn) time | O(1) space - n is the length of the array.
  public int indexEqualsValue(int[] array) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int middle = (left + right) / 2;
      int middleValue = array[middle];

      if (middleValue < middle)
        left = middle + 1;
      else if (middleValue == middle && middle == 0)
        return middle;
      else if (middleValue == middle && array[middle - 1] != middle - 1)
        return middle;
      else
        right = middle - 1;
    }

    return -1;
  }

  // O(logn) time | O(logn) space - n is the length of the array.
  // public int indexEqualsValue(int[] array) {
  // return indexEqualsValue(array, 0, array.length - 1);
  // }

  // public int indexEqualsValue(int[] array, int left, int right) {
  // if (left > right)
  // return -1;

  // int middle = (left + right) / 2;
  // int middleValue = array[middle];

  // if (middleValue < middle)
  // return indexEqualsValue(array, middle + 1, right);

  // if (middleValue == middle && middle == 0)
  // return middle;
  // else if (middleValue == middle && array[middle - 1] != middle - 1)
  // return middle;
  // else
  // return indexEqualsValue(array, left, middle - 1);
  // }

  // O(n) time | O(1) space - n is the length of the array.
  // public int indexEqualsValue(int[] array) {
  // for (int i = 0; i < array.length; i++) {
  // if (i == array[i])
  // return i;
  // }

  // return -1;
  // }
}
