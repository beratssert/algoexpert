import java.util.*;

class Program {
  // O(n^2) time | O(n) space - n is the number of the points
  public int minimumAreaRectangle(int[][] points) {
    HashSet<String> pointsSet = pointsSet(points);
    int minArea = Integer.MAX_VALUE;
    for (int i = 0; i < points.length; i++) {
      int[] point1 = points[i];
      int p1x = point1[0];
      int p1y = point1[1];
      for (int j = 0; j < i; j++) {
        int[] point2 = points[j];
        int p2x = point2[0];
        int p2y = point2[1];

        if (p1x == p2x || p1y == p2y)
          continue;

        boolean oppositePoint1 = pointsSet.contains(pointToStr(p1x, p2y));
        boolean oppositePoint2 = pointsSet.contains(pointToStr(p2x, p1y));

        if (oppositePoint1 && oppositePoint2) {
          int area = Math.abs(p2y - p1y) * Math.abs(p2x - p1x);
          minArea = Math.min(minArea, area);
        }

      }
    }

    return minArea == Integer.MAX_VALUE ? 0 : minArea;
  }

  public HashSet<String> pointsSet(int[][] points) {
    HashSet<String> set = new HashSet<>();
    for (int[] point : points) {
      String str = pointToStr(point[0], point[1]);
      set.add(str);
    }

    return set;
  }

  public String pointToStr(int x, int y) {
    return x + ":" + y;
  }
}
