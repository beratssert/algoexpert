import java.util.*;

class Program {
  // O(eloge) time | O(e + v) space - e is the number of the edges, and v is the
  // number of the vertices in the graph.
  public int[][][] kruskalsAlgorithm(int[][][] edges) {
    List<int[]> edgeList = new ArrayList<>();
    for (int vertex = 0; vertex < edges.length; vertex++) {
      for (int[] edge : edges[vertex]) {
        if (edge[0] > vertex)
          edgeList.add(new int[] { vertex, edge[0], edge[1] });
      }
    }

    edgeList.sort((edge1, edge2) -> edge1[2] - edge2[2]);

    int[] parents = new int[edges.length];
    int[] ranks = new int[edges.length];
    List<List<int[]>> mst = new ArrayList<>();
    for (int i = 0; i < edges.length; i++) {
      parents[i] = i;
      mst.add(i, new ArrayList<>());
    }

    for (int[] edge : edgeList) {
      int rootOne = find(edge[0], parents);
      int rootTwo = find(edge[1], parents);

      if (rootOne != rootTwo) {
        union(rootOne, rootTwo, parents, ranks);
        mst.get(edge[0]).add(new int[] { edge[1], edge[2] });
        mst.get(edge[1]).add(new int[] { edge[0], edge[2] });
      }
    }

    int[][][] result = new int[mst.size()][][];
    for (int i = 0; i < result.length; i++) {
      result[i] = new int[mst.get(i).size()][];
      for (int j = 0; j < result[i].length; j++) {
        result[i][j] = mst.get(i).get(j);
      }
    }

    return result;
  }

  public int find(int node, int[] parents) {
    if (node != parents[node])
      parents[node] = find(parents[node], parents);

    return parents[node];
  }

  public void union(int node1, int node2, int[] parents, int[] ranks) {
    if (ranks[node1] < ranks[node2])
      parents[node1] = node2;
    else if (ranks[node2] < ranks[node1])
      parents[node2] = node1;
    else {
      parents[node2] = node1;
      ranks[node1] += 1;
    }
  }
}
