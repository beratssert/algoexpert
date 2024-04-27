class Program {
  // Best: O(n^2) time | O(1) space
  // Average: O(n^2) time | O(1) space
  // Worst: O(n^2) time | O(1) space
  public static int[] selectionSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      int minIdx = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[minIdx]) {
          minIdx = j;
        }
      }

      swap(array, minIdx, i);
    }

    return array;
  }

  public static void swap(int[] array, int minIdx, int idx) {
    int temp = array[idx];
    array[idx] = array[minIdx];
    array[minIdx] = temp;
  }
}
