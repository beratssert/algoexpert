import java.util.*;

class Program {
  // O(n^2) time | O(n) space - n is the number of the coordinates.
  public static int rectangleMania(List<Integer[]> coords) {
    HashSet<String> coordinates = getCoordinates(coords);
    return getNumberOfRectangles(coords, coordinates);
  }

  private static HashSet<String> getCoordinates(List<Integer[]> coords) {
    HashSet<String> coordinates = new HashSet<>();
    for (Integer[] coord : coords) {
      String stringfyCoord = stringfyCoordinate(coord);
      coordinates.add(stringfyCoord);
    }

    return coordinates;
  }

  private static int getNumberOfRectangles(List<Integer[]> coords, HashSet<String> coordinates) {
    int numberOfRectangles = 0;
    for (Integer[] coord1 : coords) {
      for (Integer[] coord2 : coords) {
        if (!isInUpperRightCorner(coord1, coord2))
          continue;

        String possibleTopLeftCorner = stringfyCoordinate(new Integer[] { coord1[0], coord2[1] });
        String possibleBelowRightCorner = stringfyCoordinate(new Integer[] { coord2[0], coord1[1] });
        if (coordinates.contains(possibleTopLeftCorner) && coordinates.contains(possibleBelowRightCorner))
          numberOfRectangles++;
      }
    }

    return numberOfRectangles;
  }

  private static boolean isInUpperRightCorner(Integer[] coord1, Integer[] coord2) {
    return coord2[0] > coord1[0] && coord2[1] > coord1[1];
  }

  private static String stringfyCoordinate(Integer[] coord) {
    return coord[0] + "-" + coord[1];
  }
}
