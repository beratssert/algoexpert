import java.util.*;

class Program {
  // O(n) time | O(h) space - n is the number of the nodes
  // h is the height of the tree.
  // public static int nodeDepths(BinaryTree root) {
  // return calculateNodeDepths(root, 0);
  // }

  // public static int calculateNodeDepths(BinaryTree node, int depth) {
  // if (node == null)
  // return 0;
  // return depth + calculateNodeDepths(node.left, depth + 1) +
  // calculateNodeDepths(node.right, depth + 1);
  // }

  // O(n) time | O(h) space - n is the number of the nodes
  // h is the height of the tree.
  public static int nodeDepths(BinaryTree root) {
    int depthSum = 0;
    List<Level> stack = new ArrayList<Level>();
    stack.add(new Level(root, 0));
    while (stack.size() > 0) {
      Level top = stack.remove(stack.size() - 1);
      BinaryTree node = top.root;
      int depth = top.depth;
      if (node == null)
        continue;
      depthSum += depth;
      stack.add(new Level(node.left, depth + 1));
      stack.add(new Level(node.right, depth + 1));
    }

    return depthSum;
  }

  static class Level {
    BinaryTree root;
    int depth;

    Level(BinaryTree root, int depth) {
      this.root = root;
      this.depth = depth;
    }
  }

  static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
      left = null;
      right = null;
    }
  }
}
