// O(n) time | O(h) space
// n is the number of nodes and h is the height of the tree.
function evaluateExpressionTree(tree) {
  if (tree.value > 0) return tree.value;

  const leftValue = evaluateExpressionTree(tree.left);
  const rightValue = evaluateExpressionTree(tree.right);

  if (tree.value === -1) return leftValue + rightValue;
  if (tree.value === -2) return leftValue - rightValue;
  if (tree.value === -3) return Math.trunc(leftValue / rightValue);
  return leftValue * rightValue;
}
