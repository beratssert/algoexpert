import java.util.*;

class Program {
  // O(n^2) time | O(n) space - n is the number of the points.
  public int lineThroughPoints(int[][] points) {
    int maxPointsInSameLine = 1;
    for (int i = 0; i < points.length - 1; i++) {
      int[] p1 = points[i];
      HashMap<String, Integer> numberOfPointsThatSharesSameSlope = new HashMap<>();
      for (int j = i + 1; j < points.length; j++) {
        int[] p2 = points[j];
        int[] slope = getSlope(p1, p2);
        String hashableSlope = getHashableSlope(slope);
        if (!numberOfPointsThatSharesSameSlope.containsKey(hashableSlope))
          numberOfPointsThatSharesSameSlope.put(hashableSlope, 1);

        numberOfPointsThatSharesSameSlope.put(hashableSlope, numberOfPointsThatSharesSameSlope.get(hashableSlope) + 1);
      }

      maxPointsInSameLine = Math.max(maxPointsInSameLine, Collections.max(numberOfPointsThatSharesSameSlope.values()));
    }

    return maxPointsInSameLine;
  }

  public int[] getSlope(int[] p1, int[] p2) {
    int p1x = p1[0];
    int p1y = p1[1];
    int p2x = p2[0];
    int p2y = p2[1];

    int[] slope = new int[] { 1, 0 };
    if (p1x != p2x) {
      int xDiff = p2x - p1x;
      int yDiff = p2y - p1y;
      int gcd = gcd(Math.abs(xDiff), Math.abs(yDiff));
      xDiff /= gcd;
      yDiff /= gcd;
      if (xDiff < 0) {
        xDiff *= -1;
        yDiff *= -1;
      }

      slope = new int[] { yDiff, xDiff };
    }

    return slope;
  }

  public int gcd(int num1, int num2) {
    while (true) {
      if (num1 == 0)
        return num2;

      if (num2 == 0)
        return num1;

      int temp = num1;
      num1 = num2;
      num2 = temp % num2;
    }
  }

  public String getHashableSlope(int[] slope) {
    return slope[0] + ":" + slope[1];
  }
}
