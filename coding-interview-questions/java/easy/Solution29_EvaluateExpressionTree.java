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
  // the binary tree.
  public int evaluateExpressionTree(BinaryTree tree) {
    int possibleOperator = tree.value;
    if (possibleOperator > 0) {
      return tree.value;
    }

    int left = evaluateExpressionTree(tree.left);
    int right = evaluateExpressionTree(tree.right);

    return getResult(left, right, possibleOperator);
  }

  public int getResult(int left, int right, int operator) {
    int result = 0;
    if (operator == -1) {
      result = left + right;
    } else if (operator == -2) {
      result = left - right;
    } else if (operator == -3) {
      result = left / right;
    } else if (operator == -4) {
      result = left * right;
    }

    return result;
  }
}
