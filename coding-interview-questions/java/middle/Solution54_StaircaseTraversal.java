import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the height of the stairs
  public int staircaseTraversal(int height, int maxSteps) {
    ArrayList<Integer> memoization = new ArrayList<>();
    memoization.add(1);

    int totalWays = 0;
    for (int currentHeight = 1; currentHeight < height + 1; currentHeight++) {
      int endWindow = currentHeight - 1;
      int startWindow = endWindow - maxSteps;

      if (startWindow >= 0)
        totalWays -= memoization.get(startWindow);

      totalWays += memoization.get(endWindow);
      memoization.add(totalWays);
    }

    return totalWays;
  }

  // O(n * k) time | O(n) space - n is the height, k is the max step
  // public int staircaseTraversal(int height, int maxSteps) {
  // int[] memoization = new int[height + 1];
  // memoization[0] = 1;
  // memoization[1] = 1;

  // for (int currentHeight = 2; currentHeight < height + 1; currentHeight++) {
  // int totalWays = 0;
  // for (int step = 1; step <= Math.min(currentHeight, maxSteps); step++) {
  // totalWays += memoization[currentHeight - step];
  // }

  // memoization[currentHeight] = totalWays;
  // }

  // return memoization[memoization.length - 1];
  // }

  // O(n*k) time | O(n) space - n is the height, k is the max step
  // public int staircaseTraversal(int height, int maxSteps) {
  // HashMap<Integer, Integer> memoization = new HashMap<>();
  // memoization.put(0, 1);
  // memoization.put(1, 1);
  // return staircaseTraversal(height, maxSteps, memoization);
  // }

  // public int staircaseTraversal(int height, int maxSteps, HashMap<Integer,
  // Integer> memoization) {
  // if (memoization.containsKey(height))
  // return memoization.get(height);

  // int totalWays = 0;
  // for (int step = 1; step <= Math.min(maxSteps, height); step++) {
  // totalWays += staircaseTraversal(height - step, maxSteps, memoization);
  // }

  // memoization.put(height, totalWays);

  // return totalWays;
  // }

  // O(k^n) time | O(n) space - n is the height, k is the max steps
  // public int staircaseTraversal(int height, int maxSteps) {
  // if (height <= 1)
  // return 1;

  // int totalWays = 0;
  // for (int step = 1; step <= Math.min(maxSteps, height); step++) {
  // totalWays += staircaseTraversal(height - step, maxSteps);
  // }

  // return totalWays;
  // }
}
