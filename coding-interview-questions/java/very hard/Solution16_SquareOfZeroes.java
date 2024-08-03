import java.util.*;

class Program {
  // O(n^2) time | O(n^2) space - is the height or weight of the nxn input matrix.
  public static boolean squareOfZeroes(List<List<Integer>> matrix) {
    MatrixInfo[][] infoMatrix = computeNumberOfZeros(matrix);
    int size = matrix.size();
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        MatrixInfo info = infoMatrix[row][col];
        if (info.numOfZerosBelow > 1 && info.numOfZerosRight > 1) {
          int small = Math.min(info.numOfZerosBelow, info.numOfZerosRight);
          int bottomRow = row + small - 1;
          int rightCol = col + small - 1;
          if (isSquareOfZeros(row, col, bottomRow, rightCol, infoMatrix))
            return true;
        }
      }
    }

    return false;
  }

  public static MatrixInfo[][] computeNumberOfZeros(List<List<Integer>> matrix) {
    int size = matrix.size();
    MatrixInfo[][] infoMatrix = new MatrixInfo[size][size];

    for (int row = size - 1; row >= 0; row--) {
      for (int col = size - 1; col >= 0; col--) {
        int num = matrix.get(row).get(col);
        int numOfZeros = num == 1 ? 0 : 1;
        infoMatrix[row][col] = new MatrixInfo(numOfZeros, numOfZeros);

        if (num == 0 && col < size - 1) {
          infoMatrix[row][col].numOfZerosRight += infoMatrix[row][col + 1].numOfZerosRight;
        }

        if (num == 0 && row < size - 1) {
          infoMatrix[row][col].numOfZerosBelow += infoMatrix[row + 1][col].numOfZerosBelow;
        }
      }
    }

    return infoMatrix;
  }

  public static boolean isSquareOfZeros(int r1, int c1, int r2, int c2, MatrixInfo[][] infoMatrix) {
    int requiredNumberOfZerosForSquare = r2 - r1 + 1;
    boolean top = infoMatrix[r1][c1].numOfZerosRight >= requiredNumberOfZerosForSquare;
    boolean bottom = infoMatrix[r2][c1].numOfZerosRight >= requiredNumberOfZerosForSquare;
    boolean left = infoMatrix[r1][c1].numOfZerosBelow >= requiredNumberOfZerosForSquare;
    boolean right = infoMatrix[r1][c2].numOfZerosBelow >= requiredNumberOfZerosForSquare;

    return top && bottom && left && right;
  }

  static class MatrixInfo {
    protected int numOfZerosBelow;
    protected int numOfZerosRight;

    public MatrixInfo(int numOfZerosBelow, int numOfZerosRight) {
      this.numOfZerosBelow = numOfZerosBelow;
      this.numOfZerosRight = numOfZerosRight;
    }
  }

  // O(n^3) time | O(n^2) space - n is the height or weight of the nxn input
  // matrix.
  // public static boolean squareOfZeroes(List<List<Integer>> matrix) {
  // MatrixInfo[][] infoMatrix = computeNumberOfZeros(matrix);
  // int size = matrix.size();
  // for (int topRow = 0; topRow < size; topRow++) {
  // for (int leftCol = 0; leftCol < size; leftCol++) {
  // int squareLength = 1;
  // while (squareLength < size - leftCol && squareLength < size - topRow) {
  // int rightCol = leftCol + squareLength;
  // int bottomRow = topRow + squareLength;

  // if (isSquareOfZeros(topRow, leftCol, bottomRow, rightCol, infoMatrix))
  // return true;

  // squareLength++;
  // }
  // }
  // }

  // return false;
  // }

  // public static MatrixInfo[][] computeNumberOfZeros(List<List<Integer>> matrix)
  // {
  // int size = matrix.size();
  // MatrixInfo[][] infoMatrix = new MatrixInfo[size][size];

  // for (int row = size - 1; row >= 0; row--) {
  // for (int col = size - 1; col >= 0; col--) {
  // int num = matrix.get(row).get(col);
  // int numOfZeros = num == 1 ? 0 : 1;
  // infoMatrix[row][col] = new MatrixInfo(numOfZeros, numOfZeros);

  // if (num == 0 && col < size - 1) {
  // infoMatrix[row][col].numOfZerosRight += infoMatrix[row][col +
  // 1].numOfZerosRight;
  // }

  // if (num == 0 && row < size - 1) {
  // infoMatrix[row][col].numOfZerosBelow += infoMatrix[row +
  // 1][col].numOfZerosBelow;
  // }
  // }
  // }

  // return infoMatrix;
  // }

  // public static boolean isSquareOfZeros(int r1, int c1, int r2, int c2,
  // MatrixInfo[][] infoMatrix) {
  // int squareLength = r2 - r1;
  // boolean top = infoMatrix[r1][c1].numOfZerosRight > squareLength;
  // boolean bottom = infoMatrix[r2][c1].numOfZerosRight > squareLength;
  // boolean left = infoMatrix[r1][c1].numOfZerosBelow > squareLength;
  // boolean right = infoMatrix[r1][c2].numOfZerosBelow > squareLength;

  // return top && bottom && left && right;
  // }

  // static class MatrixInfo {
  // protected int numOfZerosBelow;
  // protected int numOfZerosRight;

  // public MatrixInfo(int numOfZerosBelow, int numOfZerosRight) {
  // this.numOfZerosBelow = numOfZerosBelow;
  // this.numOfZerosRight = numOfZerosRight;
  // }
  // }

  // O(n^4) time | O(1) space - n is the height or weight of the nxn input matrix.
  // public static boolean squareOfZeroes(List<List<Integer>> matrix) {
  // int size = matrix.size();
  // for (int topRow = 0; topRow < size; topRow++) {
  // for (int leftCol = 0; leftCol < size; leftCol++) {
  // int squareLength = 1;
  // while (squareLength < size - leftCol && squareLength < size - topRow) {
  // int rightCol = leftCol + squareLength;
  // int bottomRow = topRow + squareLength;

  // if (isSquareOfZeros(topRow, leftCol, bottomRow, rightCol, matrix))
  // return true;

  // squareLength++;
  // }
  // }
  // }

  // return false;
  // }

  // public static boolean isSquareOfZeros(int r1, int c1, int r2, int c2,
  // List<List<Integer>> matrix) {
  // for (int row = r1; row <= r2; row++) {
  // if (matrix.get(row).get(c1) == 1 || matrix.get(row).get(c2) == 1)
  // return false;
  // }

  // for (int col = c1; col <= c2; col++) {
  // if (matrix.get(r1).get(col) == 1 || matrix.get(r2).get(col) == 1)
  // return false;
  // }

  // return true;
  // }

  // O(n^4) time | O(n^3) space - n is the height or weight of the nxn input
  // matrix.
  // public static boolean squareOfZeroes(List<List<Integer>> matrix) {
  // int lastIdx = matrix.size() - 1;
  // HashMap<String, Boolean> cache = new HashMap<>();
  // return hasSquareOfZeros(0, 0, lastIdx, lastIdx, matrix, cache);
  // }

  // public static boolean hasSquareOfZeros(int r1, int c1, int r2, int c2,
  // List<List<Integer>> matrix,
  // HashMap<String, Boolean> cache) {
  // if (r1 >= r2 || c1 >= c2)
  // return false;

  // String key = r1 + "-" + c1 + "-" + r2 + "-" + c2;
  // if (cache.containsKey(key))
  // return cache.get(key);

  // cache.put(key,
  // isSquareOfZeros(r1, c1, r2, c2, matrix)
  // || hasSquareOfZeros(r1 + 1, c1 + 1, r2, c2, matrix, cache)
  // || hasSquareOfZeros(r1 + 1, c1, r2, c2 - 1, matrix, cache)
  // || hasSquareOfZeros(r1, c1 + 1, r2 - 1, c2, matrix, cache)
  // || hasSquareOfZeros(r1, c1, r2 - 1, c2 - 1, matrix, cache)
  // || hasSquareOfZeros(r1 + 1, c1 + 1, r2 - 1, c2 - 1, matrix, cache));

  // return cache.get(key);
  // }

  // public static boolean isSquareOfZeros(int r1, int c1, int r2, int c2,
  // List<List<Integer>> matrix) {
  // for (int row = r1; row <= r2; row++) {
  // if (matrix.get(row).get(c1) == 1 || matrix.get(row).get(c2) == 1)
  // return false;
  // }

  // for (int col = c1; col <= c2; col++) {
  // if (matrix.get(r1).get(col) == 1 || matrix.get(r2).get(col) == 1)
  // return false;
  // }

  // return true;
  // }
}
