// O(n) time | O(n) space - where n is the number of the nodes
function branchSums(root) {
  let resultSums = [];
  branchSumsHelper(root, resultSums, 0);
  return resultSums;
}

function branchSumsHelper(tree, resultSums, sum) {
  if (tree === null) return;
  sum += tree.value;
  if (tree.left === null && tree.right === null) {
    resultSums.push(sum);
    return;
  }
  branchSumsHelper(tree.left, resultSums, sum);
  branchSumsHelper(tree.right, resultSums, sum);
}
