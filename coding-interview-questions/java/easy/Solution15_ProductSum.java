import java.util.*;

class Program {
  // O(n) time | O(d) space - n is the total number of elements, including
  // subelements.
  // d is the greatest depth of the "special" arrays in the array.
  public static int productSum(List<Object> array) {
    // Write your code here.
    return getSum(array, 1);
  }

  public static int getSum(List<Object> array, int depth) {
    int sum = 0;
    for (Object object : array) {
      if (object instanceof ArrayList) {
        @SuppressWarnings("unchecked")
        ArrayList<Object> ls = (ArrayList<Object>) object;
        sum += getSum(ls, depth + 1);
      } else {
        sum += (int) object;
      }
    }

    return depth * sum;
  }
}
