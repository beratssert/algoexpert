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

  // O(n) time | O(h) space - n is the number of the nodes, h is the height of the
  // tree.
  static class Subtree {
    public int currentSum;
    public boolean isSplittable;

    Subtree(int currentSum, boolean isSplittable) {
      this.currentSum = currentSum;
      this.isSplittable = isSplittable;
    }
  }

  public int splitBinaryTree(BinaryTree tree) {
    int sumTree = getSumTree(tree);

    if (sumTree % 2 != 0)
      return 0;

    int desiredSum = sumTree / 2;
    return trySubtree(tree, desiredSum).isSplittable ? desiredSum : 0;
  }

  public Subtree trySubtree(BinaryTree tree, int desiredSum) {
    if (tree == null)
      return new Subtree(0, false);

    Subtree left = trySubtree(tree.left, desiredSum);
    Subtree right = trySubtree(tree.right, desiredSum);

    int currentSum = tree.value + left.currentSum + right.currentSum;
    boolean isSplittable = left.isSplittable || right.isSplittable || currentSum == desiredSum;

    return new Subtree(currentSum, isSplittable);
  }

  public int getSumTree(BinaryTree tree) {
    if (tree == null)
      return 0;

    return tree.value + getSumTree(tree.left) + getSumTree(tree.right);
  }
}
