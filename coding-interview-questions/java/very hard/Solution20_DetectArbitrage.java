import java.util.*;

class Program {
  // O(n^3) time | O(n^2) space - n is the number of the currencies.
  public boolean detectArbitrage(ArrayList<ArrayList<Double>> exchangeRates) {
    ArrayList<ArrayList<Double>> logExchangeRates = convertToLogMatrix(exchangeRates);
    return isFoundNegativeWeightCycle(logExchangeRates, 0);
  }

  private ArrayList<ArrayList<Double>> convertToLogMatrix(ArrayList<ArrayList<Double>> exchangeRates) {
    ArrayList<ArrayList<Double>> logExchangeRates = new ArrayList<>();
    for (int i = 0; i < exchangeRates.size(); i++) {
      ArrayList<Double> rates = exchangeRates.get(i);
      logExchangeRates.add(new ArrayList<>());
      for (Double rate : rates) {
        logExchangeRates.get(i).add(-Math.log10(rate));
      }
    }

    return logExchangeRates;
  }

  private boolean isFoundNegativeWeightCycle(ArrayList<ArrayList<Double>> graph, int start) {
    double[] distancesFromStart = new double[graph.size()];
    Arrays.fill(distancesFromStart, Double.MAX_VALUE);
    distancesFromStart[start] = 0;

    for (int i = 0; i < graph.size() - 1; i++) {
      if (!relaxEdgesAndUpdateDistances(graph, distancesFromStart))
        return false;
    }

    return relaxEdgesAndUpdateDistances(graph, distancesFromStart);
  }

  private boolean relaxEdgesAndUpdateDistances(ArrayList<ArrayList<Double>> graph, double[] distances) {
    boolean updated = false;
    for (int sourceIdx = 0; sourceIdx < graph.size(); sourceIdx++) {
      ArrayList<Double> edges = graph.get(sourceIdx);
      for (int destinationIdx = 0; destinationIdx < edges.size(); destinationIdx++) {
        double weight = edges.get(destinationIdx);
        double distance = distances[sourceIdx] + weight;
        if (distance < distances[destinationIdx]) {
          updated = true;
          distances[destinationIdx] = distance;
        }
      }
    }

    return updated;
  }
}
