import java.util.*;

class Program {
  // O(t - s) time | O(t - s) space - t is the target, and s is the startingHand.
  // Normally, time and space complexities are stoppingPoint - startingHand
  // ((target - 4) - startingHand). It refers target - startingHand.
  public float blackjackProbability(int target, int startingHand) {
    HashMap<Integer, Float> memo = new HashMap<>();
    return blackjackProbability(target, startingHand, memo);
  }

  public float blackjackProbability(int target, int currentHand, HashMap<Integer, Float> memo) {
    if (currentHand > target)
      return 1;
    if (currentHand >= target - 4)
      return 0;
    if (memo.containsKey(currentHand))
      return memo.get(currentHand);

    float totalPossibilities = 0;
    for (int drawn = 1; drawn <= 10; drawn++) {
      totalPossibilities += 0.1 * blackjackProbability(target, currentHand + drawn, memo);
    }

    memo.put(currentHand, totalPossibilities);

    return totalPossibilities;
  }
}
