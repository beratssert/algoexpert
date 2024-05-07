import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the number of buildings
  public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
    ArrayList<Integer> indices = new ArrayList<>();
    int idx = direction.equals("WEST") ? 0 : buildings.length - 1;
    int idxDirection = direction.equals("WEST") ? 1 : -1;

    int max = 0;
    while (idx >= 0 && idx < buildings.length) {
      int height = buildings[idx];
      if (height > max) {
        max = height;
        indices.add(idx);
      }

      idx += idxDirection;
    }

    if (direction.equals("EAST"))
      Collections.reverse(indices);

    return indices;
  }

  // O(n) time | O(n) space - n is the number of the buildings
  // public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
  // Stack<Integer> indices = new Stack<>();
  // int idx = direction.equals("EAST") ? 0 : buildings.length - 1;
  // int idxDirection = direction.equals("EAST") ? 1 : -1;

  // while (idx >= 0 && idx < buildings.length) {
  // int height = buildings[idx];
  // while (!indices.isEmpty() && height >= buildings[indices.peek()]) {
  // indices.pop();
  // }

  // indices.push(idx);
  // idx += idxDirection;
  // }

  // ArrayList<Integer> list = new ArrayList<>(indices);
  // if (direction.equals("WEST"))
  // Collections.reverse(list);

  // return list;
  // }
}
