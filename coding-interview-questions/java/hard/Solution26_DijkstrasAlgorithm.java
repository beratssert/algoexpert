import java.util.*;

class Program {
  // O(v^2 + e) time | O(v) space - v is the number of vertices, and e is the
  // number of edges. We can also use Heap data structures to store minimum
  // distances, this makes our algorithm more efficent O((v+e) * logv) time | O(v)
  // space
  public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
    int numberOfVertices = edges.length;
    HashSet<Integer> visited = new HashSet<>();
    int[] minDistances = new int[numberOfVertices];
    Arrays.fill(minDistances, Integer.MAX_VALUE);
    minDistances[start] = 0;

    while (visited.size() != numberOfVertices) {
      int[] vertexInfo = getVertexWithMinDistance(minDistances, visited);
      int vertex = vertexInfo[0];
      int distance = vertexInfo[1];

      if (distance == Integer.MAX_VALUE)
        break;

      visited.add(vertex);

      for (int[] info : edges[vertex]) {
        if (visited.contains(info[0]))
          continue;

        int totalDistance = distance + info[1];
        minDistances[info[0]] = Math.min(totalDistance, minDistances[info[0]]);
      }
    }

    return getMinDistances(minDistances);
  }

  public int[] getVertexWithMinDistance(int[] minDistances, Set<Integer> visited) {
    int distance = Integer.MAX_VALUE;
    int vertex = -1;

    for (int i = 0; i < minDistances.length; i++) {
      if (visited.contains(i))
        continue;

      if (minDistances[i] <= distance) {
        distance = minDistances[i];
        vertex = i;
      }
    }

    return new int[] { vertex, distance };
  }

  public int[] getMinDistances(int[] minDistances) {
    int[] mins = new int[minDistances.length];
    for (int i = 0; i < mins.length; i++) {
      mins[i] = minDistances[i] == Integer.MAX_VALUE ? -1 : minDistances[i];
    }

    return mins;
  }
}
