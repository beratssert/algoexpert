import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the all numbers in the matrix, width * height.
  public int largestIsland(int[][] matrix) {
    List<Integer> islandSizes = new ArrayList<>();
    int islandNumber = 2;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          islandSizes.add(getSizeAndUpdateIsland(i, j, matrix, islandNumber));
          islandNumber++;
        }
      }
    }

    int maxSize = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] != 1)
          continue;

        Stack<int[]> neighbours = getNeighbours(i, j, matrix);
        HashSet<Integer> islands = new HashSet<>();
        for (int[] neighbour : neighbours) {
          islands.add(matrix[neighbour[0]][neighbour[1]]);
        }

        int size = 1;
        for (Integer island : islands) {
          size += islandSizes.get(island - 2);
        }

        maxSize = Math.max(maxSize, size);
      }
    }

    return maxSize;
  }

  public int getSizeAndUpdateIsland(int i, int j, int[][] matrix, int islandNumber) {
    Stack<int[]> neighbours = new Stack<>();
    neighbours.add(new int[] { i, j });
    int size = 0;
    while (!neighbours.isEmpty()) {
      int[] neighbour = neighbours.pop();
      int row = neighbour[0];
      int col = neighbour[1];

      if (matrix[row][col] != 0)
        continue;

      matrix[row][col] = islandNumber;
      size++;

      neighbours.addAll(getNeighbours(row, col, matrix));
    }

    return size;
  }

  public Stack<int[]> getNeighbours(int i, int j, int[][] matrix) {
    Stack<int[]> neighbours = new Stack<>();
    if (i > 0 && matrix[i - 1][j] != 1)
      neighbours.add(new int[] { i - 1, j });
    if (i < matrix.length - 1 && matrix[i + 1][j] != 1)
      neighbours.add(new int[] { i + 1, j });
    if (j > 0 && matrix[i][j - 1] != 1)
      neighbours.add(new int[] { i, j - 1 });
    if (j < matrix[i].length - 1 && matrix[i][j + 1] != 1)
      neighbours.add(new int[] { i, j + 1 });

    return neighbours;
  }

  // O(n^2) time | O(n) space - n is the all numbers int the matrix
  // public int largestIsland(int[][] matrix) {
  // int maxSize = 0;
  // for (int i = 0; i < matrix.length; i++) {
  // for (int j = 0; j < matrix[i].length; j++) {
  // if (matrix[i][j] == 0)
  // continue;

  // maxSize = Math.max(maxSize, explore(i, j, matrix));
  // }
  // }

  // return maxSize;
  // }

  // public int explore(int i, int j, int[][] matrix) {
  // boolean[][] visited = new boolean[matrix.length][matrix[0].length];
  // Stack<int[]> neighbours = getNeighbours(i, j, matrix);
  // int size = 1;
  // while (!neighbours.isEmpty()) {
  // int[] neighbour = neighbours.pop();
  // int row = neighbour[0];
  // int col = neighbour[1];

  // if (visited[row][col])
  // continue;

  // visited[row][col] = true;
  // size++;

  // neighbours.addAll(getNeighbours(row, col, matrix));
  // }

  // return size;
  // }

  // public Stack<int[]> getNeighbours(int i, int j, int[][] matrix) {
  // Stack<int[]> neighbours = new Stack<>();
  // if (i > 0 && matrix[i - 1][j] != 1)
  // neighbours.add(new int[] { i - 1, j });
  // if (i < matrix.length - 1 && matrix[i + 1][j] != 1)
  // neighbours.add(new int[] { i + 1, j });
  // if (j > 0 && matrix[i][j - 1] != 1)
  // neighbours.add(new int[] { i, j - 1 });
  // if (j < matrix[i].length - 1 && matrix[i][j + 1] != 1)
  // neighbours.add(new int[] { i, j + 1 });

  // return neighbours;
  // }
}
