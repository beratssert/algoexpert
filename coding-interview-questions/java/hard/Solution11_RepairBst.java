import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  // O(n) time | O(h) space - n is the number of the nodes, h is the height of the
  // tree
  public BST repairBst(BST tree) {
    BST nodeOne = null, nodeTwo = null, prevNode = null;
    Stack<BST> nodes = new Stack<>();
    BST currentNode = tree;
    while (currentNode != null || !nodes.isEmpty()) {
      while (currentNode != null) {
        nodes.add(currentNode);
        currentNode = currentNode.left;
      }

      currentNode = nodes.pop();
      if (prevNode != null && prevNode.value > currentNode.value) {
        if (nodeOne == null)
          nodeOne = prevNode;

        nodeTwo = currentNode;
      }

      prevNode = currentNode;
      currentNode = currentNode.right;
    }

    swap(nodeOne, nodeTwo);
    return tree;
  }

  public void swap(BST nodeOne, BST nodeTwo) {
    int temp = nodeOne.value;
    nodeOne.value = nodeTwo.value;
    nodeTwo.value = temp;
  }

  // O(n) time | O(h) space - n is the number of the nodes, h is the height of the
  // tree
  // BST nodeOne = null;
  // BST nodeTwo = null;
  // BST prevNode = null;

  // public BST repairBst(BST tree) {
  // inOrderTraverse(tree);
  // swap(nodeOne, nodeTwo);
  // return tree;
  // }

  // public void inOrderTraverse(BST node) {
  // if (node == null)
  // return;

  // inOrderTraverse(node.left);

  // if (prevNode != null && prevNode.value > node.value) {
  // if (nodeOne == null)
  // nodeOne = prevNode;

  // nodeTwo = node;
  // }

  // prevNode = node;

  // inOrderTraverse(node.right);
  // }

  // public void swap(BST nodeOne, BST nodeTwo) {
  // int temp = nodeOne.value;
  // nodeOne.value = nodeTwo.value;
  // nodeTwo.value = temp;
  // }
}
