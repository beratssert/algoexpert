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

  // Average: O(n) time | O(h) space - n is the number of the nodes, h is the
  // height of the tree.
  public int binaryTreeDiameter(BinaryTree tree) {
    return getTreeInfo(tree).diameter;
  }

  public TreeInfo getTreeInfo(BinaryTree tree) {
    if (tree == null)
      return new TreeInfo(0, 0);

    TreeInfo left = getTreeInfo(tree.left);
    TreeInfo right = getTreeInfo(tree.right);

    int maxPath = left.height + right.height;
    int maxDiameter = Math.max(left.diameter, right.diameter);
    int diameter = Math.max(maxPath, maxDiameter);
    int height = 1 + Math.max(left.height, right.height);

    return new TreeInfo(height, diameter);
  }

  static class TreeInfo {
    public int height;
    public int diameter;

    TreeInfo(int height, int diameter) {
      this.height = height;
      this.diameter = diameter;
    }
  }
}
