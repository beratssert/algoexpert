import java.util.*;

class Program {
  // O(e + v) time | O(v) space - v is the number of vertices, and e is the number
  // of edges in the graph.
  public boolean twoEdgeConnectedGraph(int[][] edges) {
    if (edges.length == 0)
      return true;

    int[] arrivalTimes = new int[edges.length];
    Arrays.fill(arrivalTimes, -1);

    if (getArrivalTimeFromAncestor(0, -1, 0, arrivalTimes, edges) == -1)
      return false;

    return areAllVericesVisited(arrivalTimes);
  }

  public boolean areAllVericesVisited(int[] arrivalTimes) {
    for (int arrivalTime : arrivalTimes) {
      if (arrivalTime == -1)
        return false;
    }

    return true;
  }

  public int getArrivalTimeFromAncestor(int currentVertex, int parent, int currentTime, int[] arrivalTimes,
      int[][] edges) {

    arrivalTimes[currentVertex] = currentTime;
    int minimumArrivalTime = currentTime;

    for (int destination : edges[currentVertex]) {
      if (arrivalTimes[destination] == -1)
        minimumArrivalTime = Math.min(minimumArrivalTime,
            getArrivalTimeFromAncestor(destination, currentVertex, currentTime + 1, arrivalTimes, edges));
      else if (destination != parent)
        minimumArrivalTime = Math.min(minimumArrivalTime, arrivalTimes[destination]);
    }

    if (minimumArrivalTime == currentTime && parent != -1)
      return -1;

    return minimumArrivalTime;
  }
}
