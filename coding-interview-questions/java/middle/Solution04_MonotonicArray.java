class Program {
  // O(n) time | O(1) space - n is the length of the array.
  public static boolean isMonotonic(int[] array) {
    boolean isNonDecreasing = true;
    boolean isNonIncreasing = true;
    for (int i = 1; i < array.length; i++) {
      if (array[i] < array[i - 1]) {
        isNonDecreasing = false;
      }

      if (array[i] > array[i - 1]) {
        isNonIncreasing = false;
      }
    }

    return isNonDecreasing || isNonIncreasing;
  }

  // O(n) time | O(1) space - n is the length of the array.
  // public static boolean isMonotonic(int[] array) {
  // if (array.length <= 2)
  // return true;

  // int direction = array[1] - array[0];
  // for (int i = 2; i < array.length; i++) {
  // if (direction == 0) {
  // direction = array[i] - array[i - 1];
  // continue;
  // }

  // if (breaksDirection(direction, array[i - 1], array[i])) {
  // return false;
  // }
  // }

  // return true;
  // }

  // public static boolean breaksDirection(int direction, int prevNum, int
  // currentNum) {
  // if (direction < 0)
  // return currentNum > prevNum;
  // return currentNum < prevNum;
  // }
}