import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the length of the array
  public int[] sortedSquaredArray(int[] array) {
    int[] squares = new int[array.length];

    int leftIdx = 0;
    int rightIdx = array.length - 1;
    for (int i = squares.length - 1; i >= 0; i--) {
      int leftNum = array[leftIdx];
      int rightNum = array[rightIdx];
      if (Math.abs(leftNum) < Math.abs(rightNum)) {
        squares[i] = rightNum * rightNum;
        rightIdx--;
      } else {
        squares[i] = leftNum * leftNum;
        leftIdx++;
      }
    }
    return squares;
  }

  // O(nlogn) time | O(n) space - n is the length of the arrray
  // public int[] sortedSquaredArray(int[] array) {
  // int[] squares = new int[array.length];
  // for (int i = 0; i < array.length; i++) {
  // squares[i] = array[i] * array[i];
  // }
  // Arrays.sort(squares);

  // return squares;
  // }
}
