import java.util.*;

class Program {
  // O(low * high * n) time | O(low * high) space - low is the input low, high is
  // the input high, and n is the number of the measuring cups.
  public boolean ambiguousMeasurements(
      int[][] measuringCups, int low, int high) {
    HashMap<String, Boolean> cache = new HashMap<>();
    return canMeasureInRange(measuringCups, low, high, cache);
  }

  public boolean canMeasureInRange(int[][] measuringCups, int low, int high, HashMap<String, Boolean> cache) {
    String memoizationKey = low + ":" + high;
    if (cache.containsKey(memoizationKey))
      return cache.get(memoizationKey);

    if (low <= 0 && high <= 0)
      return false;

    boolean canMesure = false;
    for (int[] cup : measuringCups) {
      if (cup[0] >= low && cup[1] <= high) {
        canMesure = true;
        break;
      }

      canMesure = canMeasureInRange(measuringCups, low - cup[0], high - cup[1], cache);
      if (canMesure)
        break;
    }

    cache.put(memoizationKey, canMesure);
    return canMesure;
  }
}
