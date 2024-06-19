import java.util.*;

class Program {
  // Best: O(n) time | O(1) space
  // Avg: O(n) time | O(1) space
  // Worst: O(n^2) time | O(1) space - n is the length of the array.
  public static int quickselect(int[] array, int k) {
    return quickselect(array, 0, array.length - 1, k - 1);
  }

  public static int quickselect(int[] array, int staringIdx, int endingIdx, int position) {
    while (true) {
      int pivotIdx = staringIdx;
      int leftIdx = staringIdx + 1;
      int rightIdx = endingIdx;
      while (leftIdx <= rightIdx) {
        if (array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx])
          swap(leftIdx, rightIdx, array);
        if (array[leftIdx] < array[pivotIdx])
          leftIdx++;
        if (array[rightIdx] > array[pivotIdx])
          rightIdx--;
      }

      swap(pivotIdx, rightIdx, array);
      if (rightIdx == position)
        return array[rightIdx];
      else if (rightIdx > position)
        endingIdx = rightIdx - 1;
      else
        staringIdx = rightIdx + 1;
    }
  }

  public static void swap(int left, int right, int[] array) {
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
}
