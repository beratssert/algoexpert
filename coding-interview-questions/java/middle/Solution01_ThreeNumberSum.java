import java.util.*;

class Program {
  // O(n^2) time | O(n) space
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    Arrays.sort(array);

    ArrayList<Integer[]> triplets = new ArrayList<Integer[]>();
    for (int i = 0; i < array.length - 2; i++) {
      int leftIdx = i + 1;
      int rightIdx = array.length - 1;
      while (leftIdx < rightIdx) {
        int sum = array[i] + array[leftIdx] + array[rightIdx];
        if (sum == targetSum) {
          triplets.add(new Integer[] { array[i], array[leftIdx], array[rightIdx] });
          leftIdx++;
          rightIdx--;
        } else if (sum < targetSum) {
          leftIdx++;
        } else if (sum > targetSum) {
          rightIdx--;
        }
      }
    }
    return triplets;
  }
}
