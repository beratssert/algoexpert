import java.util.*;

class Program {
  // O(v+e) time | O(v) space - v is the vertices, and e is the edges of the
  // graph.
  public boolean twoColorable(int[][] edges) {
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    Boolean[] color = new Boolean[edges.length];
    color[0] = true;
    while (!stack.isEmpty()) {
      int node = stack.pop();
      for (int connection : edges[node]) {
        if (color[connection] == null) {
          color[connection] = !color[node];
          stack.push(connection);
        } else if (color[connection] == color[node]) {
          return false;
        }
      }
    }

    return true;
  }
}
