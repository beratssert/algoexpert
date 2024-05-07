import java.util.*;

import jdk.javadoc.internal.doclets.formats.html.markup.Comment;

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

  // O(n) time | O(h) space - n is the number of the nodes of the smaller tree,
  // and h is the height of the smaller tree.
  public BinaryTree mergeBinaryTrees(BinaryTree tree1, BinaryTree tree2) {
    if (tree1 == null)
      return tree2;

    if (tree2 == null)
      return tree1;

    tree1.value += tree2.value;
    tree1.left = mergeBinaryTrees(tree1.left, tree2.left);
    tree1.right = mergeBinaryTrees(tree1.right, tree2.right);

    return tree1;
  }

  // O(n) time | O(h) space - n is the number of the nodes of the smaller tree,
  // and h is the height of the smaller tree.
  // public BinaryTree mergeBinaryTrees(BinaryTree tree1, BinaryTree tree2) {
  // if (tree1 == null)
  // return tree2;

  // Stack<BinaryTree> tree1Stack = new Stack<>();
  // tree1Stack.push(tree1);
  // Stack<BinaryTree> tree2Stack = new Stack<>();
  // tree2Stack.push(tree2);

  // while (tree1Stack.size() > 0) {
  // BinaryTree node1 = tree1Stack.pop();
  // BinaryTree node2 = tree2Stack.pop();

  // if (node2 == null)
  // continue;

  // node1.value += node2.value;

  // if (node1.left == null) {
  // node1.left = node2.left;
  // } else {
  // tree1Stack.push(node1.left);
  // tree2Stack.push(node2.left);
  // }

  // if (node1.right == null) {
  // node1.right = node2.right;
  // } else {
  // tree1Stack.push(node1.right);
  // tree2Stack.push(node2.right);
  // }

  // }

  // return tree1;
  // }
}
