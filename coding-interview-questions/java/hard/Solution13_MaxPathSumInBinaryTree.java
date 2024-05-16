import java.util.*;

class Program {
  // O(n) time | O(h) = O(logn) space - n is the number of the nodes, h is the
  // height of the tree.
  public static int maxPathSum(BinaryTree tree) {
    return findMaxSum(tree)[1];
  }

  public static int[] findMaxSum(BinaryTree tree) {
    if (tree == null)
      return new int[] { 0, Integer.MIN_VALUE };

    int[] leftSums = findMaxSum(tree.left);
    int[] rightSums = findMaxSum(tree.right);
    int maxBranch = Math.max(leftSums[0], rightSums[0]);

    int value = tree.value;
    int maxBranchSum = Math.max(value, maxBranch + value);
    int maxNodesSum = Math.max(leftSums[0] + value + rightSums[0], maxBranchSum);
    int maxPathSum = Math.max(maxNodesSum, Math.max(leftSums[1], rightSums[1]));

    return new int[] { maxBranchSum, maxPathSum };
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
