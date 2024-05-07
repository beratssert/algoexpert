import java.util.Arrays;

class Program {
  // O(nd) time | O(n) space - n is the input n, d in the length of the denoms.
  public static int minNumberOfCoinsForChange(int n, int[] denoms) {
    int[] amounts = new int[n + 1];
    Arrays.fill(amounts, Integer.MAX_VALUE);
    amounts[0] = 0;

    for (int denom : denoms) {
      for (int amount = 1; amount < amounts.length; amount++) {
        if (denom <= amount) {
          int toCompare = amounts[amount - denom];
          if (toCompare != Integer.MAX_VALUE)
            toCompare += 1;

          amounts[amount] = Math.min(amounts[amount], toCompare);
        }
      }
    }

    return amounts[n] == Integer.MAX_VALUE ? -1 : amounts[n];
  }
}
