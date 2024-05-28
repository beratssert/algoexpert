import java.util.*;

class Program {
  // O(n^2) time | O(n) space - n is the length of the prices
  public ArrayList<Integer> juiceBottling(int[] prices) {
    int quantity = prices.length;
    int[] maxProfit = new int[quantity];
    int[] dividingPoints = new int[quantity];

    for (int qty = 0; qty < quantity; qty++) {
      for (int dividingPoint = 0; dividingPoint < qty + 1; dividingPoint++) {
        int profit = prices[dividingPoint] + maxProfit[qty - dividingPoint];

        if (profit > maxProfit[qty]) {
          maxProfit[qty] = profit;
          dividingPoints[qty] = dividingPoint;
        }
      }
    }

    return getSolution(dividingPoints);
  }

  public ArrayList<Integer> getSolution(int[] dividingPoints) {
    ArrayList<Integer> solution = new ArrayList<>();

    int idx = dividingPoints.length - 1;
    while (idx > 0) {
      solution.add(dividingPoints[idx]);
      idx -= dividingPoints[idx];
    }

    return solution;
  }

  // O(n^3) time | O(n^2) space - n is the length of the prices
  // public ArrayList<Integer> juiceBottling(int[] prices) {
  // int quantity = prices.length;
  // int[] maxProfit = new int[quantity];
  // List<ArrayList<Integer>> solutions = new ArrayList<>();
  // for (int i = 0; i < quantity; i++) {
  // solutions.add(new ArrayList<>());
  // }

  // for (int qty = 0; qty < quantity; qty++) {
  // for (int dividingPoint = 0; dividingPoint < qty + 1; dividingPoint++) {
  // int profit = prices[dividingPoint] + maxProfit[qty - dividingPoint];

  // if (profit > maxProfit[qty]) {
  // maxProfit[qty] = profit;
  // ArrayList<Integer> newSolution = new ArrayList<>();
  // newSolution.add(dividingPoint);
  // newSolution.addAll(solutions.get(qty - dividingPoint));
  // solutions.set(qty, newSolution);
  // }
  // }
  // }

  // return solutions.get(quantity - 1);
  // }
}
