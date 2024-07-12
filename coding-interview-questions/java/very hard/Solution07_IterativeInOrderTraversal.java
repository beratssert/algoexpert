import java.util.function.Function;

class Program {
  // O(n) time | O(1) space - n is the number of the nodes in the tree.
  public static void iterativeInOrderTraversal(BinaryTree tree, Function<BinaryTree, Void> callback) {
    BinaryTree previousNode = null;
    BinaryTree currentNode = tree;
    while (currentNode != null) {
      BinaryTree nextNode = null;
      if (previousNode == currentNode.parent) {
        if (currentNode.left != null)
          nextNode = currentNode.left;
        else {
          callback.apply(currentNode);
          nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
        }
      } else if (previousNode == currentNode.left) {
        callback.apply(currentNode);
        nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
      } else {
        nextNode = currentNode.parent;
      }

      previousNode = currentNode;
      currentNode = nextNode;
    }
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;
    public BinaryTree parent;

    public BinaryTree(int value) {
      this.value = value;
    }

    public BinaryTree(int value, BinaryTree parent) {
      this.value = value;
      this.parent = parent;
    }
  }
}
