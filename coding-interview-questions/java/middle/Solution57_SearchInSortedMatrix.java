import java.util.*;

class Program {
  // O(w + h) time | O(1) space - w is the width, and h is the height of the
  // matrix
  public static int[] searchInSortedMatrix(int[][] matrix, int target) {
    int row = 0;
    int col = matrix[0].length - 1;
    while (row < matrix.length && col >= 0) {
      if (target < matrix[row][col])
        col--;
      else if (target > matrix[row][col])
        row++;
      else
        return new int[] { row, col };
    }

    return new int[] { -1, -1 };
  }
}
