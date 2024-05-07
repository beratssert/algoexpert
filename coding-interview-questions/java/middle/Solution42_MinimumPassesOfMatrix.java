import java.util.*;

class Program {
  // O(w*h) time | O(w*h) space - w is the width of the matrix, and h is the
  // height of the matrix.
  public int minimumPassesOfMatrix(int[][] matrix) {
    int passes = getMinPasses(matrix);
    return isContainNegative(matrix) ? -1 : passes - 1;
  }

  public int getMinPasses(int[][] matrix) {
    Queue<Integer[]> currentQueue = getPositivePositions(matrix);

    int passes = 0;
    while (!currentQueue.isEmpty()) {
      Queue<Integer[]> nextQueue = currentQueue;
      currentQueue = new LinkedList<>();
      while (!nextQueue.isEmpty()) {
        Integer[] currentPosition = nextQueue.poll();
        List<Integer[]> neighbours = getNeighbours(currentPosition, matrix);
        for (Integer[] neighbourPosition : neighbours) {
          if (matrix[neighbourPosition[0]][neighbourPosition[1]] < 0) {
            matrix[neighbourPosition[0]][neighbourPosition[1]] *= -1;
            currentQueue.add(neighbourPosition);
          }
        }
      }

      passes++;
    }

    return passes;
  }

  public Queue<Integer[]> getPositivePositions(int[][] matrix) {
    Queue<Integer[]> positives = new LinkedList<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] > 0)
          positives.add(new Integer[] { i, j });
      }
    }
    return positives;
  }

  public ArrayList<Integer[]> getNeighbours(Integer[] position, int[][] matrix) {
    ArrayList<Integer[]> neighbours = new ArrayList<>();

    int row = position[0];
    int col = position[1];
    if (row > 0) {
      neighbours.add(new Integer[] { row - 1, col });
    }
    if (row < matrix.length - 1) {
      neighbours.add(new Integer[] { row + 1, col });
    }
    if (col > 0) {
      neighbours.add(new Integer[] { row, col - 1 });
    }
    if (col < matrix[row].length - 1) {
      neighbours.add(new Integer[] { row, col + 1 });
    }

    return neighbours;
  }

  public boolean isContainNegative(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] < 0)
          return true;
      }
    }

    return false;
  }
}
