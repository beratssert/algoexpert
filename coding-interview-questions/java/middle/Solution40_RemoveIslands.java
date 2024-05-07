import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the all numbers in the matrix.
  public int[][] removeIslands(int[][] matrix) {
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        boolean isRowInBorder = row == 0 || row == matrix.length - 1;
        boolean isColInBorder = col == 0 || col == matrix[row].length - 1;
        boolean isInBorder = isRowInBorder || isColInBorder;

        if (!isInBorder || matrix[row][col] != 1)
          continue;

        changeOnesInBorderToTwos(row, col, matrix);
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 1) {
          matrix[i][j] = 0;
        } else if (matrix[i][j] == 2) {
          matrix[i][j] = 1;
        }
      }
    }

    return matrix;
  }

  public void changeOnesInBorderToTwos(int row, int col, int[][] matrix) {
    Stack<Integer[]> possibleConnections = new Stack<>();
    possibleConnections.push(new Integer[] { row, col });
    while (!possibleConnections.isEmpty()) {
      Integer[] indices = possibleConnections.pop();
      Integer i = indices[0];
      Integer j = indices[1];

      matrix[i][j] = 2;
      List<Integer[]> neighbours = getNeighbours(i, j, matrix);
      possibleConnections.addAll(neighbours);
    }
  }

  public List<Integer[]> getNeighbours(int i, int j, int[][] matrix) {
    List<Integer[]> neighbours = new ArrayList<>();
    if (i > 0 && matrix[i - 1][j] == 1)
      neighbours.add(new Integer[] { i - 1, j });

    if (i < matrix.length - 1 && matrix[i + 1][j] == 1)
      neighbours.add(new Integer[] { i + 1, j });

    if (j > 0 && matrix[i][j - 1] == 1)
      neighbours.add(new Integer[] { i, j - 1 });

    if (j < matrix[i].length - 1 && matrix[i][j + 1] == 1)
      neighbours.add(new Integer[] { i, j + 1 });

    return neighbours;
  }

  // O(n) time | O(n) space - n is the all numbers of the matrix.
  // public int[][] removeIslands(int[][] matrix) {
  // boolean[][] isConnectedToBorder = new
  // boolean[matrix.length][matrix[0].length];
  // for (int row = 0; row < matrix.length; row++) {
  // for (int col = 0; col < matrix[row].length; col++) {
  // boolean isRowInBorder = row == 0 || row == matrix.length - 1;
  // boolean isColInBorder = col == 0 || col == matrix[row].length - 1;
  // boolean isInBorder = isRowInBorder || isColInBorder;

  // if (!isInBorder || matrix[row][col] != 1)
  // continue;

  // markConnectedOnesToBorder(row, col, isConnectedToBorder, matrix);
  // }
  // }

  // for (int i = 0; i < matrix.length; i++) {
  // for (int j = 0; j < matrix[i].length; j++) {
  // if (!isConnectedToBorder[i][j])
  // matrix[i][j] = 0;
  // }
  // }

  // return matrix;
  // }

  // public void markConnectedOnesToBorder(int row, int col, boolean[][]
  // isConnectedToBorder, int[][] matrix) {
  // Stack<Integer[]> possibleConnections = new Stack<>();
  // possibleConnections.push(new Integer[] { row, col });
  // while (!possibleConnections.isEmpty()) {
  // Integer[] indices = possibleConnections.pop();
  // Integer i = indices[0];
  // Integer j = indices[1];

  // if (isConnectedToBorder[i][j])
  // continue;

  // isConnectedToBorder[i][j] = true;
  // List<Integer[]> neighbours = getNeighbours(i, j, matrix);
  // possibleConnections.addAll(neighbours);
  // }
  // }

  // public List<Integer[]> getNeighbours(int i, int j, int[][] matrix) {
  // List<Integer[]> neighbours = new ArrayList<>();
  // if (i > 0 && matrix[i - 1][j] == 1)
  // neighbours.add(new Integer[] { i - 1, j });

  // if (i < matrix.length - 1 && matrix[i + 1][j] == 1)
  // neighbours.add(new Integer[] { i + 1, j });

  // if (j > 0 && matrix[i][j - 1] == 1)
  // neighbours.add(new Integer[] { i, j - 1 });

  // if (j < matrix[i].length - 1 && matrix[i][j + 1] == 1)
  // neighbours.add(new Integer[] { i, j + 1 });

  // return neighbours;
  // }
}
