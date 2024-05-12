import java.util.*;

class Program {
  // O(n^2) time | O(n) space - n is the number of the points
  public int countSquares(int[][] points) {
    HashSet<String> pointsSet = new HashSet<>();
    for (int[] point : points) {
      pointsSet.add(pointToString(point));
    }

    int count = 0;
    for (int[] pointA : points) {
      for (int[] pointB : points) {
        if (pointA == pointB)
          continue;
        double midX = (pointA[0] + pointB[0]) / 2.0;
        double midY = (pointA[1] + pointB[1]) / 2.0;

        double xDistanceFromMid = pointA[0] - midX;
        double yDistanceFromMid = pointA[1] - midY;

        double[] pointC = new double[] { midX + yDistanceFromMid, midY - xDistanceFromMid };
        double[] pointD = new double[] { midX - yDistanceFromMid, midY + xDistanceFromMid };

        if (pointsSet.contains(pointToString(pointC)) && pointsSet.contains(pointToString(pointD)))
          count++;
      }
    }

    return count / 4;
  }

  public String pointToString(int[] point) {
    return point[0] + ", " + point[1];
  }

  public String pointToString(double[] point) {
    if (point[0] % 1 == 0 && point[1] % 1 == 0)
      return (int) point[0] + ", " + (int) point[1];
    return point[0] + ", " + point[1];
  }
}
