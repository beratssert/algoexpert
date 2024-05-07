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

  // O(n) time | O(h) space - n is the number of the nodes, and h is the height of
  // the tree.
  public boolean symmetricalTree(BinaryTree tree) {
    return isMirrored(tree.left, tree.right);
  }

  public boolean isMirrored(BinaryTree left, BinaryTree right) {
    if (left != null && right != null && left.value == right.value)
      return isMirrored(left.left, right.right) && isMirrored(left.right, right.left);

    return left == right;
  }

  // O(n) time | O(h) space - n is the number of the nodes, and h is the height of
  // the tree
  // public boolean symmetricalTree(BinaryTree tree) {
  // Stack<BinaryTree> leftStack = new Stack<>();
  // leftStack.add(tree.left);

  // Stack<BinaryTree> rightStack = new Stack<>();
  // rightStack.add(tree.right);

  // while (!leftStack.isEmpty()) {
  // BinaryTree left = leftStack.pop();
  // BinaryTree right = rightStack.pop();

  // if (left == null && right == null)
  // continue;

  // if (left == null || right == null || left.value != right.value)
  // return false;

  // leftStack.add(left.left);
  // leftStack.add(left.right);
  // rightStack.add(right.right);
  // rightStack.add(right.left);
  // }

  // return true;
  // }
}
