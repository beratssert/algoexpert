class Program {
  // O(v + e) time | O(v) space - v is the vertices, and e is the edges of the
  // graph
  public boolean cycleInGraph(int[][] edges) {
    boolean[] inStack = new boolean[edges.length];
    boolean[] visited = new boolean[edges.length];

    for (int node = 0; node < edges.length; node++) {
      if (visited[node])
        continue;

      boolean cycleOccurs = isThereCycle(node, inStack, visited, edges);
      if (cycleOccurs)
        return true;
    }

    return false;
  }

  public boolean isThereCycle(int node, boolean[] inStack, boolean[] visited,
      int[][] edges) {
    visited[node] = true;
    inStack[node] = true;

    int[] connections = edges[node];
    for (int connection : connections) {
      if (inStack[connection])
        return true;

      if (visited[connection])
        continue;

      boolean cycleOccurs = isThereCycle(connection, inStack, visited, edges);
      if (cycleOccurs)
        return true;
    }

    inStack[node] = false;
    return false;
  }

  // O(v + e) time | O(v) space - v is the vertices, and e is the edges of the
  // graph
  // public final int WHITE = 0; // represent not visited vertice
  // public final int GREY = 1; // represent in-stack vertice
  // public final int BLACK = 2; // represent visited vertice, and cycle is not
  // found

  // public boolean cycleInGraph(int[][] edges) {
  // int[] colors = new int[edges.length];

  // for (int node = 0; node < edges.length; node++) {
  // if (colors[node] == BLACK)
  // continue;

  // boolean cycleOccurs = isThereCycle(node, colors, edges);
  // if (cycleOccurs)
  // return true;
  // }

  // return false;
  // }

  // public boolean isThereCycle(int node, int[] colors, int[][] edges) {
  // colors[node] = GREY;

  // int[] connections = edges[node];
  // for (int connection : connections) {
  // if (colors[connection] == GREY)
  // return true;

  // if (colors[connection] == BLACK)
  // continue;

  // boolean cycleOccurs = isThereCycle(connection, colors, edges);
  // if (cycleOccurs)
  // return true;
  // }

  // colors[node] = BLACK;
  // return false;
  // }
}
