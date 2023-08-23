// Average: O(log(n)) time | O(1) space - where n is the number of the nodes of the deepest stack
// Worst: O(n) time | O(1) space - where n is the number of nodes
function findClosestValueInBst(tree, target) {
  let node = tree;
  let closest = node.value;
  while (node !== null) {
    if (Math.abs(target - closest) > Math.abs(target - node.value))
      closest = node.value;

    if (target > node.value) {
      node = node.right;
    } else if (target < node.value) {
      node = node.left;
    } else {
      break;
    }
  }

  return closest;
}
