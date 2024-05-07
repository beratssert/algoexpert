import java.util.*;

class Program {
  // O(nlogn + mlogm) time | O(1) space
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    Arrays.sort(arrayOne);
    Arrays.sort(arrayTwo);

    int minDifference = Integer.MAX_VALUE;
    int[] pair = new int[2];

    int idxOne = 0;
    int idxTwo = 0;
    while (idxOne < arrayOne.length && idxTwo < arrayTwo.length) {
      int numeOne = arrayOne[idxOne];
      int numeTwo = arrayTwo[idxTwo];
      int difference;
      if (numeOne > numeTwo) {
        difference = numeOne - numeTwo;
        idxTwo++;
      } else if (numeTwo > numeOne) {
        difference = numeTwo - numeOne;
        idxOne++;
      } else {
        return new int[] { numeOne, numeTwo };
      }

      if (difference < minDifference) {
        minDifference = difference;
        pair = new int[] { numeOne, numeTwo };
      }
    }

    return pair;
  }

  // O(n * m ) time | O(1) space
  // public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
  // int minDifference = Integer.MAX_VALUE;
  // int[] pair = new int[2];
  // for (int numOne : arrayOne) {
  // for (int numTwo : arrayTwo) {
  // int difference = Math.abs(numOne - numTwo);
  // if (difference < minDifference) {
  // minDifference = difference;
  // pair[0] = numOne;
  // pair[1] = numTwo;
  // }
  // }
  // }

  // return pair;
  // }
}
