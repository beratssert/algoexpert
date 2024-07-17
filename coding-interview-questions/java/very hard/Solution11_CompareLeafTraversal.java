import java.util.*;

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

  // O(n + m) time | O(h1 + h2) space - n and m is the number of the nodes in the
  // trees, and h1 and h2 is the heights of the trees, respectively.
  public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
    Stack<BinaryTree> tree1Nodes = new Stack<>();
    tree1Nodes.add(tree1);

    Stack<BinaryTree> tree2Nodes = new Stack<>();
    tree2Nodes.add(tree2);

    while (!tree1Nodes.isEmpty() && !tree2Nodes.isEmpty()) {
      BinaryTree leaf1 = getLeafNode(tree1Nodes);
      BinaryTree leaf2 = getLeafNode(tree2Nodes);

      if (leaf1.value != leaf2.value)
        return false;
    }

    return tree1Nodes.isEmpty() && tree2Nodes.isEmpty();
  }

  public BinaryTree getLeafNode(Stack<BinaryTree> nodes) {
    while (!nodes.isEmpty()) {
      BinaryTree node = nodes.pop();
      if (node.left == null && node.right == null)
        return node;

      if (node.right != null)
        nodes.add(node.right);

      if (node.left != null)
        nodes.add(node.left);
    }

    return null;
  }

  // // This is an input class. Do not edit.
  // static class BinaryTree {
  // public int value;
  // public BinaryTree left = null;
  // public BinaryTree right = null;

  // public BinaryTree(int value) {
  // this.value = value;
  // }
  // }

  // O(n + m) time | O(n + m) space - n and m is the number of the nodes in the
  // trees, respectively.
  // public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
  // List<Integer> tree1LeafValues = new ArrayList<>();
  // List<Integer> tree2LeafValues = new ArrayList<>();
  // getLeafValues(tree1, tree1LeafValues);
  // getLeafValues(tree2, tree2LeafValues);

  // if (tree1LeafValues.size() != tree2LeafValues.size())
  // return false;

  // for (int i = 0; i < tree1LeafValues.size(); i++) {
  // if (tree1LeafValues.get(i) != tree2LeafValues.get(i))
  // return false;
  // }

  // return true;
  // }

  // public void getLeafValues(BinaryTree tree, List<Integer> list) {
  // if (tree.left == null && tree.right == null) {
  // list.add(tree.value);
  // return;
  // }

  // if (tree.left != null)
  // getLeafValues(tree.left, list);

  // if (tree.right != null)
  // getLeafValues(tree.right, list);
  // }
}
