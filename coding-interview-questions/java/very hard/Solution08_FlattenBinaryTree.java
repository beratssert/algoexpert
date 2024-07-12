import java.util.*;

class Program {
  // O(n) time | O(d) space - n is the number of the nodes, and d is the maximum
  // depth in the tree.
  public static BinaryTree flattenBinaryTree(BinaryTree root) {
    BinaryTree leftMost = flattenTree(root)[0];
    return leftMost;
  }

  public static BinaryTree[] flattenTree(BinaryTree node) {
    BinaryTree leftMost = null;
    BinaryTree rightMost = null;
    if (node.left == null)
      leftMost = node;
    else {
      BinaryTree[] leftAndRightMostNodes = flattenTree(node.left);
      connectNodes(leftAndRightMostNodes[1], node);
      leftMost = leftAndRightMostNodes[0];
    }

    if (node.right == null)
      rightMost = node;
    else {
      BinaryTree[] leftAndRightMostNodes = flattenTree(node.right);
      connectNodes(node, leftAndRightMostNodes[0]);
      rightMost = leftAndRightMostNodes[1];
    }

    return new BinaryTree[] { leftMost, rightMost };
  }

  public static void connectNodes(BinaryTree left, BinaryTree right) {
    left.right = right;
    right.left = left;
  }

  // This is the class of the input root. Do not edit it.
  static class BinaryTree {
    int value;
    BinaryTree left = null;
    BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  // O(n) time | O(n) space - n is the number of the nodes in the tree.
  // public static BinaryTree flattenBinaryTree(BinaryTree root) {
  // List<BinaryTree> inOrderList = new ArrayList<>();
  // inOrderTraverse(root, inOrderList);

  // for (int i = 0; i < inOrderList.size() - 1; i++) {
  // BinaryTree left = inOrderList.get(i);
  // BinaryTree right = inOrderList.get(i + 1);
  // left.right = right;
  // right.left = left;
  // }

  // return inOrderList.get(0);
  // }

  // public static void inOrderTraverse(BinaryTree node, List<BinaryTree> list) {
  // if (node == null)
  // return;

  // inOrderTraverse(node.left, list);
  // list.add(node);
  // inOrderTraverse(node.right, list);
  // }

  // // This is the class of the input root. Do not edit it.
  // static class BinaryTree {
  // int value;
  // BinaryTree left = null;
  // BinaryTree right = null;

  // public BinaryTree(int value) {
  // this.value = value;
  // }
  // }
}
