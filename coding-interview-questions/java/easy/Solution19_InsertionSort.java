
class Program {
  // Best: O(n) time | O(1) sapce
  // Average: O(n^2) time | O(1) space
  // Worst: O(n^2) time | O(1) space
  public static int[] insertionSort(int[] array) {
    if (array.length == 0) {
      return new int[] {};
    }

    for (int i = 1; i < array.length; i++) {
      int j = i;
      while (j > 0 && array[j - 1] > array[j]) {
        swap(array, j);
        j--;
      }
    }

    return array;
  }

  public static void swap(int[] array, int i) {
    int temp = array[i];
    array[i] = array[i - 1];
    array[i - 1] = temp;
  }
}
