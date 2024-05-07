import java.util.*;

class Program {
  // O(n) time | O(d) = O(logn) space - n is the number of the nodes, d is the
  // depth of the tree.
  // public static void invertBinaryTree(BinaryTree tree) {
  // if (tree == null)
  // return;

  // swapNodes(tree);
  // invertBinaryTree(tree.left);
  // invertBinaryTree(tree.right);
  // }

  public static void swapNodes(BinaryTree tree) {
    BinaryTree temp = tree.left;
    tree.left = tree.right;
    tree.right = temp;
  }

  // O(n) time | O(n) space - n is the number of the nodes.
  public static void invertBinaryTree(BinaryTree tree) {
    ArrayDeque<BinaryTree> queue = new ArrayDeque<>();
    queue.addLast(tree);

    while (queue.size() > 0) {
      BinaryTree node = queue.pollFirst();
      swapNodes(node);

      if (node.left != null)
        queue.addLast(node.left);

      if (node.right != null)
        queue.addLast(node.right);
    }
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
