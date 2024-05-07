class Program {
  // O(n) time | O(d) space - n is the number of the nodes, and d is the depth of
  // the tree.
  public static boolean validateBst(BST tree) {
    return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public static boolean validateBst(BST tree, int min, int max) {
    if (tree == null)
      return true;

    if (tree.value < min || tree.value >= max) {
      return false;
    }

    boolean isLeftValid = validateBst(tree.left, min, tree.value);
    boolean isRightValid = validateBst(tree.right, tree.value, max);

    return isLeftValid && isRightValid;
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
