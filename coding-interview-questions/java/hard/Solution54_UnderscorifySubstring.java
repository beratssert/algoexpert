import java.util.*;

class Program {
  // O(n + m) time | O(n) space - n is the length of the string, and m is the
  // length of the substring.
  // ------------------------------------
  // O(n(n + m)) time -> since we traverse string and try to find substring in the
  // string, we can think the time complexity as that. However, if we deep dive
  // the details of the algorithm we can notice that the time comlexity will be
  // O(n + m).
  public static String underscorifySubstring(String str, String substring) {
    ArrayList<int[]> locations = fixCollapse(getLocations(str, substring));
    return underScorify(str, locations);
  }

  public static ArrayList<int[]> getLocations(String str, String subString) {
    ArrayList<int[]> locations = new ArrayList<>();
    int startingIdx = 0;
    while (startingIdx < str.length()) {
      int foundIdx = str.indexOf(subString, startingIdx);
      if (foundIdx == -1)
        break;

      int[] subLocation = new int[] { foundIdx, foundIdx + subString.length() };
      locations.add(subLocation);
      startingIdx = foundIdx + 1;
    }

    return locations;
  }

  public static ArrayList<int[]> fixCollapse(ArrayList<int[]> locations) {
    if (locations.isEmpty())
      return locations;

    ArrayList<int[]> fixedLocations = new ArrayList<>();
    fixedLocations.add(locations.get(0));
    int[] previous = locations.get(0);
    for (int i = 1; i < locations.size(); i++) {
      int[] current = locations.get(i);
      if (current[0] <= previous[1]) {
        previous[1] = current[1];
      } else {
        fixedLocations.add(current);
        previous = current;
      }
    }

    return fixedLocations;
  }

  public static String underScorify(String str, ArrayList<int[]> locations) {
    StringBuilder finalStr = new StringBuilder();
    int strIdx = 0;
    int locationIdx = 0;
    int i = 0;
    while (strIdx < str.length() && locationIdx < locations.size()) {
      if (strIdx == locations.get(locationIdx)[i]) {
        finalStr.append("_");
        i = 1 - i; // 0 -> 1 || 1 -> 0\
        locationIdx = i == 0 ? locationIdx + 1 : locationIdx;
      }

      finalStr.append(str.charAt(strIdx));
      strIdx++;
    }

    if (strIdx < str.length())
      finalStr.append(str.substring(strIdx));
    else if (locationIdx < locations.size())
      finalStr.append("_");

    return finalStr.toString();
  }
}
