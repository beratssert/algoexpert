import java.util.*;

class Program {
  // Avg: O(n^2) time | O(n^2) space
  // Worst: O(n^3) time | O(n^2) space - n is the length of the array
  public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
    List<Integer[]> quadruplets = new ArrayList<>();
    HashMap<Integer, List<Integer[]>> allPairSums = new HashMap<>();
    for (int i = 1; i < array.length - 1; i++) {
      for (int j = i + 1; j < array.length; j++) {
        int pairSum = array[j] + array[i];
        int diff = targetSum - pairSum;
        if (allPairSums.containsKey(diff)) {
          for (Integer[] pair : allPairSums.get(diff)) {
            Integer[] quadPair = new Integer[4];
            quadPair[0] = pair[0];
            quadPair[1] = pair[1];
            quadPair[2] = array[i];
            quadPair[3] = array[j];

            quadruplets.add(quadPair);
          }
        }
      }

      for (int j = 0; j < i; j++) {
        int pairSum = array[i] + array[j];
        if (allPairSums.containsKey(pairSum)) {
          Integer[] pairs = new Integer[] { array[i], array[j] };
          allPairSums.get(pairSum).add(pairs);
        } else {
          List<Integer[]> pairs = new ArrayList<>();
          pairs.add(new Integer[] { array[i], array[j] });
          allPairSums.put(pairSum, pairs);
        }
      }
    }

    return quadruplets;
  }
}
