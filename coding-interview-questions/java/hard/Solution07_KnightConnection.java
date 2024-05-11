import java.util.*;

class Program {
  // O(nm) time | O(nm) space - n is the horizontal distance, and m is the
  // vertical distance between nights
  public int knightConnection(int[] knightA, int[] knightB) {
    int[][] possibleMoves = { { -2, 1 }, { -2, -1 }, { 2, 1 }, { 2, -1 }, { 1, 2 }, { -1, 2 }, { 1, -2 }, { -1, -2 } };
    Queue<int[]> positions = new LinkedList<>();
    int[] pos = new int[] { knightA[0], knightA[1], 0 };
    positions.add(pos);

    Set<String> visited = new HashSet<>();
    visited.add(positonToStr(knightA));

    while (true) {
      int[] currentPosition = positions.poll();

      if (currentPosition[0] == knightB[0] && currentPosition[1] == knightB[1]) {
        return (int) Math.ceil((double) currentPosition[2] / 2);
      }

      for (int[] move : possibleMoves) {
        int[] position = new int[] { currentPosition[0] + move[0], currentPosition[1] + move[1] };

        if (!visited.contains(positonToStr(position))) {
          int[] positionToAdd = new int[] { position[0], position[1], currentPosition[2] + 1 };
          positions.add(positionToAdd);
          visited.add(positonToStr(position));
        }
      }

    }
  }

  public String positonToStr(int[] position) {
    return position[0] + ", " + position[1];
  }
}
