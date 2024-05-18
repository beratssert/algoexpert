import java.util.*;

class Program {
  // O(nlogn) time | O(1) space - n is the length of the array.
  public static int[] heapSort(int[] array) {
    buildMaxHeap(array);
    for (int endIdx = array.length - 1; endIdx > 0; endIdx--) {
      swap(0, endIdx, array);
      shiftDown(0, endIdx - 1, array);
    }

    return array;
  }

  public static void buildMaxHeap(int[] array) {
    int firstParentIdx = (array.length - 1) / 2;
    for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
      shiftDown(currentIdx, array.length - 1, array);
    }
  }

  public static void shiftDown(int currentIdx, int endIdx, int[] array) {
    int childOneIdx = currentIdx * 2 + 1;
    while (childOneIdx <= endIdx) {
      int childTwoIdx = currentIdx * 2 + 2;
      int idxToSwap;
      if (childTwoIdx <= endIdx && array[childTwoIdx] > array[childOneIdx]) {
        idxToSwap = childTwoIdx;
      } else {
        idxToSwap = childOneIdx;
      }

      if (array[idxToSwap] > array[currentIdx]) {
        swap(currentIdx, idxToSwap, array);
        currentIdx = idxToSwap;
        childOneIdx = currentIdx * 2 + 1;
      } else {
        return;
      }
    }
  }

  public static void swap(int idx1, int idx2, int[] array) {
    int temp = array[idx1];
    array[idx1] = array[idx2];
    array[idx2] = temp;
  }
}
