import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the all numbers in the matrix.
  public static List<Integer> riverSizes(int[][] matrix) {
    List<Integer> sizes = new ArrayList<>();
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (visited[i][j])
          continue;

        traverseGraph(i, j, sizes, visited, matrix);
      }
    }

    return sizes;
  }

  public static void traverseGraph(int row, int col, List<Integer> sizes, boolean[][] visited, int[][] matrix) {
    int currentSize = 0;
    Stack<Integer[]> nodesToExplore = new Stack<>();
    nodesToExplore.push(new Integer[] { row, col });
    while (!nodesToExplore.isEmpty()) {
      Integer[] node = nodesToExplore.pop();
      Integer i = node[0];
      Integer j = node[1];
      if (visited[i][j])
        continue;

      visited[i][j] = true;

      if (matrix[i][j] == 0)
        continue;

      currentSize++;
      List<Integer[]> nonVisitedNeighbours = getNonvisitedNeighbours(i, j, matrix, visited);
      nodesToExplore.addAll(nonVisitedNeighbours);
    }

    if (currentSize > 0)
      sizes.add(currentSize);
  }

  public static List<Integer[]> getNonvisitedNeighbours(int i, int j, int[][] matrix, boolean[][] visited) {
    List<Integer[]> unvisetedNodes = new ArrayList<>();
    if (i > 0 && !visited[i - 1][j])
      unvisetedNodes.add(new Integer[] { i - 1, j });

    if (i < matrix.length - 1 && !visited[i + 1][j])
      unvisetedNodes.add(new Integer[] { i + 1, j });

    if (j > 0 && !visited[i][j - 1])
      unvisetedNodes.add(new Integer[] { i, j - 1 });

    if (j < matrix[i].length - 1 && !visited[i][j + 1])
      unvisetedNodes.add(new Integer[] { i, j + 1 });

    return unvisetedNodes;
  }
}
