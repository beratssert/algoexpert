import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the total number of the elements in the matrix
  // (width * height) elements
  public int maximumSumSubmatrix(int[][] matrix, int size) {
    int[][] sumMatrix = getMatrixSums(matrix);

    int maxSum = Integer.MIN_VALUE;
    for (int row = size - 1; row < sumMatrix.length; row++) {
      for (int col = size - 1; col < sumMatrix[row].length; col++) {
        int sum = sumMatrix[row][col];

        boolean touchesTop = row - size < 0;
        if (!touchesTop)
          sum -= sumMatrix[row - size][col];

        boolean touchesLeft = col - size < 0;
        if (!touchesLeft)
          sum -= sumMatrix[row][col - size];

        if (!touchesLeft && !touchesTop)
          sum += sumMatrix[row - size][col - size];

        maxSum = Math.max(sum, maxSum);
      }
    }

    return maxSum;
  }

  public int[][] getMatrixSums(int[][] matrix) {
    int[][] sums = new int[matrix.length][matrix[0].length];
    sums[0][0] = matrix[0][0];

    for (int i = 1; i < sums[0].length; i++)
      sums[0][i] = sums[0][i - 1] + matrix[0][i];

    for (int i = 1; i < sums.length; i++)
      sums[i][0] = sums[i - 1][0] + matrix[i][0];

    for (int i = 1; i < sums.length; i++) {
      for (int j = 1; j < sums[i].length; j++) {
        sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i][j];
      }
    }

    return sums;
  }
}
