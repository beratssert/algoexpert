import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the total number of elements in the array.
  public static List<Integer> spiralTraverse(int[][] array) {
    ArrayList<Integer> traversedArray = new ArrayList<>();

    int endRow = array.length - 1;
    int endCol = array[0].length - 1;
    int startRow = 0;
    int startCol = 0;

    while (startCol <= endCol && startRow <= endRow) {
      for (int col = startCol; col <= endCol; col++) {
        traversedArray.add(array[startRow][col]);
      }

      for (int row = startRow + 1; row <= endRow; row++) {
        traversedArray.add(array[row][endCol]);
      }

      for (int col = endCol - 1; col >= startCol; col--) {
        if (startRow == endRow)
          break;
        traversedArray.add(array[endRow][col]);
      }

      for (int row = endRow - 1; row > startRow; row--) {
        if (startCol == endCol)
          break;
        traversedArray.add(array[row][startCol]);
      }

      startCol++;
      startRow++;
      endCol--;
      endRow--;
    }

    return traversedArray;
  }

  // O(n) time | O(n) space - n is the total number of elements in the array.
  // public static List<Integer> spiralTraverse(int[][] array) {
  // ArrayList<Integer> traversedArray = new ArrayList<>();
  // fillArray(array, 0, array[0].length - 1, 0, array.length - 1,
  // traversedArray);
  // return traversedArray;
  // }

  // public static void fillArray(int[][] array, int startCol, int endCol, int
  // startRow, int endRow,
  // ArrayList<Integer> traversedArray) {
  // if (startCol > endCol || startRow > endRow)
  // return;
  // for (int col = startCol; col <= endCol; col++) {
  // traversedArray.add(array[startRow][col]);
  // }

  // for (int row = startRow + 1; row <= endRow; row++) {
  // traversedArray.add(array[row][endCol]);
  // }

  // for (int col = endCol - 1; col >= startCol; col--) {
  // if (startRow == endRow)
  // return;
  // traversedArray.add(array[endRow][col]);
  // }

  // for (int row = endRow - 1; row > startRow; row--) {
  // if (startCol == endCol)
  // return;
  // traversedArray.add(array[row][startCol]);
  // }

  // fillArray(array, startCol + 1, endCol - 1, startRow + 1, endRow - 1,
  // traversedArray);
  // }
}
