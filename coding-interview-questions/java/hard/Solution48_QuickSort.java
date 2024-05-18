import java.util.*;

class Program {
  // Best: O(nlogn) time | O(logn) space
  // Average: O(nlogn) time | O(logn) space
  // Worst: O(n^2) time | O(logn) space - n is the length of the array
  public static int[] quickSort(int[] array) {
    quickSort(array, 0, array.length - 1);
    return array;
  }

  public static void quickSort(int[] array, int startIdx, int endIdx) {
    if (endIdx <= startIdx)
      return;

    int pivot = array[startIdx];
    int left = startIdx + 1;
    int right = endIdx;
    while (right >= left) {
      if (array[left] > pivot && array[right] < pivot)
        swap(left, right, array);

      if (array[left] <= pivot)
        left++;
      if (array[right] >= pivot)
        right--;
    }

    swap(startIdx, right, array);

    boolean isLeftSubarraySmaller = right - 1 - startIdx < endIdx - (right + 1);
    if (isLeftSubarraySmaller) {
      quickSort(array, startIdx, right - 1);
      quickSort(array, right + 1, endIdx);
    } else {
      quickSort(array, right + 1, endIdx);
      quickSort(array, startIdx, right - 1);
    }
  }

  public static void swap(int left, int right, int[] array) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
