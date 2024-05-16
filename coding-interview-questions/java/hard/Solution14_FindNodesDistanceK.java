import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  // O(n) time | O(n) space - n is the number of the nodes
  public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
    HashMap<Integer, BinaryTree> parents = new HashMap<>();
    parents(tree, parents, null);

    BinaryTree targetNode = getTargetNode(target, tree, parents);

    return findNodesDistanceK(targetNode, parents, k);
  }

  public ArrayList<Integer> findNodesDistanceK(BinaryTree targetNode,
      HashMap<Integer, BinaryTree> parents, int k) {

    HashSet<Integer> seenValues = new HashSet<>();
    Queue<NodeInfo> nodes = new LinkedList<>();

    nodes.add(new NodeInfo(targetNode, 0));
    seenValues.add(targetNode.value);

    while (!nodes.isEmpty()) {
      NodeInfo currentNode = nodes.poll();

      if (currentNode.distance == k) {
        ArrayList<Integer> result = new ArrayList<>();
        for (NodeInfo info : nodes) {
          result.add(info.node.value);
        }

        result.add(currentNode.node.value);
        return result;
      }

      BinaryTree[] connectedNodes = new BinaryTree[] { currentNode.node.left, currentNode.node.right,
          parents.get(currentNode.node.value) };

      for (BinaryTree connectedNode : connectedNodes) {
        if (connectedNode != null && !seenValues.contains(connectedNode.value)) {
          nodes.add(new NodeInfo(connectedNode, currentNode.distance + 1));
          seenValues.add(connectedNode.value);
        }
      }
    }

    return new ArrayList<Integer>();
  }

  public void parents(BinaryTree tree, HashMap<Integer, BinaryTree> parents, BinaryTree parent) {
    if (tree != null) {
      parents.put(tree.value, parent);
      parents(tree.left, parents, tree);
      parents(tree.right, parents, tree);
    }
  }

  public BinaryTree getTargetNode(int target, BinaryTree tree, HashMap<Integer, BinaryTree> parents) {
    if (tree.value == target)
      return tree;

    BinaryTree parent = parents.get(target);
    if (parent.left != null && parent.left.value == target)
      return parent.left;

    return parent.right;
  }

  class NodeInfo {
    int distance;
    BinaryTree node;

    NodeInfo(BinaryTree node, int distance) {
      this.node = node;
      this.distance = distance;
    }
  }
}
