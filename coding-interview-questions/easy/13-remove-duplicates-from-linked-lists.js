// O(n) time | O(1) space - where n is the number of the nodes
function removeDuplicatesFromLinkedList(linkedList) {
  let currentNode = linkedList;
  while (currentNode !== null) {
    let nextNode = currentNode.next;
    while (nextNode?.value === currentNode.value) {
      nextNode = nextNode.next;
    }

    currentNode.next = nextNode;
    currentNode = nextNode;
  }

  return linkedList;
}

// O(n) time | O(n) space

// function removeDuplicatesFromLinkedList(linkedList) {
//   const currentNode = linkedList;
//   removeDuplicates(linkedList, currentNode);
//   return linkedList;
// }

// function removeDuplicates(node, currentNode) {
//   if (node === null) return;
//   if (node.value !== node?.next?.value) {
//     currentNode.next = node.next;
//     currentNode = node.next;
//   }
//   removeDuplicates(node.next, currentNode);
// }
