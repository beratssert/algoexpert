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
  // tree
  public int sumBsts(BinaryTree tree) {
    return getTreeInfo(tree).totalBstSum;
  }

  public TreeInfo getTreeInfo(BinaryTree tree) {
    if (tree == null)
      return new TreeInfo(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, 0);

    TreeInfo leftTreeInfo = getTreeInfo(tree.left);
    TreeInfo rightTreeInfo = getTreeInfo(tree.right);

    int minValue = Math.min(tree.value, Math.min(leftTreeInfo.minValue, rightTreeInfo.minValue));
    int maxValue = Math.max(tree.value, Math.max(leftTreeInfo.maxValue, rightTreeInfo.maxValue));

    boolean satisfiesBst = tree.value > leftTreeInfo.maxValue && tree.value <= rightTreeInfo.minValue;
    boolean isBst = satisfiesBst && leftTreeInfo.isBst && rightTreeInfo.isBst;

    int bstSize = 0;
    int bstSum = 0;

    int totalBstSum = leftTreeInfo.totalBstSum + rightTreeInfo.totalBstSum;

    if (isBst) {
      bstSize = 1 + leftTreeInfo.bstSize + rightTreeInfo.bstSize;
      bstSum = tree.value + leftTreeInfo.bstSum + rightTreeInfo.bstSum;

      if (bstSize >= 3)
        totalBstSum = bstSum;
    }

    return new TreeInfo(isBst, maxValue, minValue, bstSize, bstSum, totalBstSum);
  }

  class TreeInfo {
    private boolean isBst;
    private int minValue;
    private int maxValue;
    private int bstSum;
    private int totalBstSum;
    private int bstSize;

    TreeInfo(boolean isBst, int maxValue, int minValue, int bstSize, int bstSum, int totalBstSum) {
      this.isBst = isBst;
      this.maxValue = maxValue;
      this.minValue = minValue;
      this.bstSize = bstSize;
      this.bstSum = bstSum;
      this.totalBstSum = totalBstSum;
    }
  }
}
