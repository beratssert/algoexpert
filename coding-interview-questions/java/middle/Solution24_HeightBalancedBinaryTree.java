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
  static class TreeInfo {
    public boolean isBalanced;
    public int height;

    TreeInfo(boolean isBalanced, int height) {
      this.isBalanced = isBalanced;
      this.height = height;
    }
  }

  public boolean heightBalancedBinaryTree(BinaryTree tree) {
    TreeInfo treeInfo = getTreeInfo(tree);
    return treeInfo.isBalanced;
  }

  public TreeInfo getTreeInfo(BinaryTree node) {
    if (node == null)
      return new TreeInfo(true, 0);

    TreeInfo leftTreeInfo = getTreeInfo(node.left);
    TreeInfo rightTreeInfo = getTreeInfo(node.right);

    boolean isBalanced = leftTreeInfo.isBalanced && rightTreeInfo.isBalanced
        && Math.abs(leftTreeInfo.height - rightTreeInfo.height) <= 1;
    int height = Math.max(leftTreeInfo.height, rightTreeInfo.height) + 1;

    return new TreeInfo(isBalanced, height);
  }
}
