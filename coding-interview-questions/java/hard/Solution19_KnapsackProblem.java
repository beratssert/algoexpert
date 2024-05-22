import java.util.*;

class Program {
  // O(nc) time | O(nc) space - n is the number of the items in the elements, c is
  // the capacity.
  public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
    int[][] values = new int[items.length + 1][capacity + 1];

    for (int i = 1; i < values.length; i++) {
      int value = items[i - 1][0];
      int weight = items[i - 1][1];
      for (int c = 0; c < values[0].length; c++) {
        if (weight > c)
          values[i][c] = values[i - 1][c];
        else
          values[i][c] = Math.max(values[i - 1][c], values[i - 1][c - weight] + value);
      }
    }

    List<List<Integer>> knapsack = new ArrayList<>();
    knapsack.add(Arrays.asList(values[items.length][capacity]));
    knapsack.add(getKnapsackItems(values, items));

    return knapsack;
  }

  public static List<Integer> getKnapsackItems(int[][] values, int[][] items) {
    List<Integer> indices = new ArrayList<>();

    int i = values.length - 1;
    int c = values[0].length - 1;
    while (i > 0) {
      if (c == 0)
        break;

      if (values[i][c] != values[i - 1][c]) {
        indices.add(i - 1);
        c -= items[i - 1][1];
      }

      i--;
    }

    Collections.reverse(indices);
    return indices;
  }
}
