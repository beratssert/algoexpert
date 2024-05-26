import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the length of the array.
  public int maximizeExpression(int[] array) {
    if (array.length < 4)
      return 0;

    int length = array.length;

    int[] maxOfA = new int[length];
    maxOfA[0] = array[0];
    int[] maxOfAMinusB = createMaxArray(length, 1);
    int[] maxOfAMinusBPlusC = createMaxArray(length, 2);
    int[] maxOfAMinusBPlusCMinusD = createMaxArray(length, 3);

    for (int i = 1; i < length; i++) {
      int max = Math.max(maxOfA[i - 1], array[i]);
      maxOfA[i] = max;
    }

    for (int i = 1; i < length; i++) {
      int max = Math.max(maxOfAMinusB[i - 1], maxOfA[i - 1] - array[i]);
      maxOfAMinusB[i] = max;
    }

    for (int i = 2; i < length; i++) {
      int max = Math.max(maxOfAMinusBPlusC[i - 1], maxOfAMinusB[i - 1] + array[i]);
      maxOfAMinusBPlusC[i] = max;
    }

    for (int i = 3; i < length; i++) {
      int max = Math.max(maxOfAMinusBPlusCMinusD[i - 1], maxOfAMinusBPlusC[i - 1] - array[i]);
      maxOfAMinusBPlusCMinusD[i] = max;
    }

    return maxOfAMinusBPlusCMinusD[length - 1];
  }

  public int[] createMaxArray(int length, int idx) {
    int[] arr = new int[length];
    for (int i = 0; i < idx; i++) {
      arr[i] = Integer.MIN_VALUE;
    }

    return arr;
  }

  // O(n^4) time | O(1) space - n is the length of the array.
  // public int maximizeExpression(int[] array) {
  // if (array.length < 4)
  // return 0;

  // int max = Integer.MIN_VALUE;
  // for (int i = 0; i < array.length; i++) {
  // int a = array[i];
  // for (int j = i + 1; j < array.length; j++) {
  // int b = array[j];
  // for (int k = j + 1; k < array.length; k++) {
  // int c = array[k];
  // for (int l = k + 1; l < array.length; l++) {
  // int d = array[l];
  // int result = a - b + c - d;
  // max = Math.max(max, result);
  // }
  // }
  // }
  // }

  // return max;
  // }
}
