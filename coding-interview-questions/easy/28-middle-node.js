// O(n) time | O(1) space - n is the length of the linkedList.
function middleNode(linkedList) {
  let slowNode = linkedList;
  let fastNode = linkedList;

  while (fastNode && fastNode.next) {
    slowNode = slowNode.next;
    fastNode = fastNode.next.next;
  }

  return slowNode;
}

// O(n) time | O(1) space
// function middleNode(linkedList) {
//   let counter = 0;
//   let node = linkedList;
//   while (node) {
//     counter++;
//     node = node.next;
//   }

//   let middleNode = linkedList;
//   for (let i = 0; i < Math.floor(counter / 2); i++) {
//     middleNode = middleNode.next;
//   }

//   return middleNode;
// }
