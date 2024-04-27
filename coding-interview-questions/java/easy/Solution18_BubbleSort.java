class Program {
  // Average: O(n^2) time | O(1) space - n is the length of the array.
  public static int[] bubbleSort(int[] array) {
    boolean isOrdered = false;
    int counter = 0;
    while (!isOrdered) {
      isOrdered = true;
      for (int i = 0; i < array.length - 1 - counter; i++) {
        if (array[i] > array[i + 1]) {
          swap(array, i, i + 1);
          isOrdered = false;
        }
      }

      counter++;
    }
    return array;
  }

  public static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
