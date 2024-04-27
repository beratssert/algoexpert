import java.util.*;

class Program {
  // This is the class of the input root. Do not edit it.
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  // O(n) time | O(n) space - n is the number of the nodes.
  public static List<Integer> branchSums(BinaryTree root) {
    List<Integer> sums = new ArrayList<>();
    branchSums(root, sums, 0);
    return sums;
  }

  public static void branchSums(BinaryTree tree, List<Integer> sums, int sum) {
    if (tree == null)
      return;

    int newSum = sum + tree.value;
    if (tree.left == null && tree.right == null) {
      sums.add(newSum);
      return;
    }

    branchSums(tree.left, sums, newSum);
    branchSums(tree.right, sums, newSum);
  }
}
