import java.util.*;

class Program {
  // O(n) time | O(1) space
  public static List<Integer> moveElementToEnd(
      List<Integer> array, int toMove) {
    int left = 0;
    int right = array.size() - 1;
    while (left < right) {
      while (array.get(right) == toMove && left < right) {
        right--;
      }

      if (array.get(left) == toMove) {
        int temp = array.get(right);
        array.set(right, array.get(left));
        array.set(left, temp);
      }

      left++;
    }

    return array;
  }
}
