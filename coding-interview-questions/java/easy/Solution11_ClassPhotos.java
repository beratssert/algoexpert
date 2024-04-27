import java.util.*;

class Program {
  // O(nlogn) time | O(1) space - n is the length of the arrays.
  public boolean classPhotos(
      ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
    Collections.sort(redShirtHeights);
    Collections.sort(blueShirtHeights);

    String backRow = redShirtHeights.get(0) > blueShirtHeights.get(0) ? "RED" : "BLUE";
    for (int i = 0; i < redShirtHeights.size(); i++) {
      int blueShirtHeight = blueShirtHeights.get(i);
      int redShirtHeight = redShirtHeights.get(i);

      if (backRow == "RED") {
        if (blueShirtHeight >= redShirtHeight)
          return false;
      } else {
        if (redShirtHeight >= blueShirtHeight)
          return false;
      }
    }

    return true;
  }
}
