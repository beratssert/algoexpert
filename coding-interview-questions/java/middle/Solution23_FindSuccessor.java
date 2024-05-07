class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;
    public BinaryTree parent = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  // O(h) time | O(1) space - h is the height of the tree.
  public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
    if (node.right != null)
      return getLeftMostChild(node.right);

    return getRightMostParent(node);
  }

  public BinaryTree getLeftMostChild(BinaryTree node) {
    BinaryTree currentNode = node;
    while (currentNode.left != null) {
      currentNode = currentNode.left;
    }

    return currentNode;
  }

  public BinaryTree getRightMostParent(BinaryTree node) {
    BinaryTree currentNode = node;
    while (currentNode.parent != null && currentNode.parent.right == currentNode) {
      currentNode = currentNode.parent;
    }

    return currentNode.parent;
  }

  // O(n) time | O(n) space - n is the number of the nodes
  // public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
  // ArrayList<BinaryTree> nodes = new ArrayList<>();
  // fillNodes(tree, nodes);
  // for (int i = 0; i < nodes.size() - 1; i++) {
  // if (node == nodes.get(i))
  // return nodes.get(i + 1);
  // }
  // return null;

  // }

  // public void fillNodes(BinaryTree node, ArrayList<BinaryTree> nodes) {
  // if (node.left != null)
  // fillNodes(node.left, nodes);

  // nodes.add(node);

  // if (node.right != null)
  // fillNodes(node.right, nodes);
  // }
}
