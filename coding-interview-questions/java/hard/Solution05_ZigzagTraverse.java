import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the total number of elements in the array
  public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
    List<Integer> result = new ArrayList<>();
    int height = array.size() - 1;
    int width = array.get(0).size() - 1;
    int row = 0;
    int col = 0;
    boolean goingDown = true;
    while (row >= 0 && row <= height && col >= 0 && col <= width) {
      result.add(array.get(row).get(col));
      if (goingDown) {
        if (col == 0 || row == height) {
          goingDown = false;
          if (row == height)
            col++;
          else
            row++;
        } else {
          row++;
          col--;
        }
      } else {
        if (row == 0 || col == width) {
          goingDown = true;
          if (col == width)
            row++;
          else
            col++;
        } else {
          row--;
          col++;
        }
      }
    }

    return result;
  }
}
