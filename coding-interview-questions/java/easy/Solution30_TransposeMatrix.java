class Program {
  // O(w * h) time | O(w * h) space - w is the width of the matrix, and h is the
  // height of the matrix.
  public int[][] transposeMatrix(int[][] matrix) {
    int[][] transpose = new int[matrix[0].length][matrix.length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        transpose[j][i] = matrix[i][j];
      }
    }

    return transpose;
  }
}
