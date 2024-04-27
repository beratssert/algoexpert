import java.util.*;

class Program {
  // Average: O(logn) time | O(1) space
  // Worst: O(n) time | o(1) space
  public static int findClosestValueInBst(BST tree, int target) {
    BST node = tree;
    int closestValue = tree.value;
    while (node != null) {
      int value = node.value;
      if (Math.abs(target - value) < Math.abs(target - closestValue)) {
        closestValue = value;
      }
      if (target > value) {
        node = node.right;
      } else if (target < value) {
        node = node.left;
      } else {
        break;
      }
    }

    return closestValue;
  }

  // Average: O(logn) time | O(logn) space
  // Worst: O(n) time | o(n) space
  // public static int findClosestValueInBst(BST tree, int target) {
  // return findClosestValueInBst(tree, target, tree.value);
  // }

  // public static int findClosestValueInBst(BST tree, int target, int
  // closestValue) {
  // BST node = tree;
  // if (Math.abs(target - node.value) < Math.abs(target - closestValue)) {
  // closestValue = node.value;
  // }
  // if (target > node.value && node.right != null) {
  // return findClosestValueInBst(node.right, target, closestValue);
  // } else if (target < node.value && node.left != null) {
  // return findClosestValueInBst(node.left, target, closestValue);
  // }
  // return closestValue;
  // }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
