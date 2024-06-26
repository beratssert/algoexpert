import java.util.*;

class Program {
  // Do not edit the class below except
  // for the depthFirstSearch method.
  // Feel free to add new properties
  // and methods to the class.
  static class Node {
    String name;
    List<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }

    // O(v+e) time | O(v) space - v is the number of vertices (nodes)
    // e is the number of edges.
    public List<String> depthFirstSearch(List<String> array) {
      array.add(this.name);
      for (int i = 0; i < this.children.size(); i++) {
        this.children.get(i).depthFirstSearch(array);
      }
      return array;
    }

    public Node addChild(String name) {
      Node child = new Node(name);
      children.add(child);
      return this;
    }
  }
}
