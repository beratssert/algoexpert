import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the number of the buildings
  public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
    int maxArea = 0;
    Stack<Integer> buildingIdx = new Stack<>();

    ArrayList<Integer> extendedBuildings = new ArrayList<>(buildings);
    extendedBuildings.add(0);
    for (int i = 0; i < extendedBuildings.size(); i++) {
      int height = extendedBuildings.get(i);
      while (!buildingIdx.isEmpty() && extendedBuildings.get(buildingIdx.peek()) >= height) {
        int currentHeight = extendedBuildings.get(buildingIdx.pop());
        int currentWidth = buildingIdx.isEmpty() ? i : i - buildingIdx.peek() - 1;
        int area = currentHeight * currentWidth;
        if (area > maxArea)
          maxArea = area;
      }

      buildingIdx.add(i);
    }

    return maxArea;
  }

  // O(n^2) time | O(1) space - n is the number of the buildings.
  // public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
  // int maxArea = 0;
  // for (int i = 0; i < buildings.size(); i++) {
  // int buildingHeight = buildings.get(i);

  // int left = i;
  // while (left > 0 && buildings.get(left - 1) >= buildingHeight) {
  // left--;
  // }

  // int right = i;
  // while (right < buildings.size() - 1 && buildings.get(right + 1) >=
  // buildingHeight) {
  // right++;
  // }

  // int area = (right - left + 1) * buildingHeight;
  // if (area > maxArea)
  // maxArea = area;
  // }

  // return maxArea;
  // }
}
