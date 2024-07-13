import java.util.*;

class Program {
  // O(n) time | O(h) space - n is the number of the nodes, and h is the height of
  // the tree.
  public static int allKindsOfNodeDepths(BinaryTree root) {
    return getTreeInfo(root).sumOfAllDepths;
  }

  public static TreeInfo getTreeInfo(BinaryTree node) {
    if (node == null)
      return new TreeInfo(0, 0, 0);

    TreeInfo left = getTreeInfo(node.left);
    TreeInfo right = getTreeInfo(node.right);

    int sumOfLeftDepths = left.sumOfDepths + left.numNodes;
    int sumOfRightDepths = right.sumOfDepths + right.numNodes;

    int numNodes = 1 + left.numNodes + right.numNodes;
    int sumOfDepths = sumOfLeftDepths + sumOfRightDepths;
    int sumOfAllDepths = sumOfDepths + left.sumOfAllDepths + right.sumOfAllDepths;

    return new TreeInfo(numNodes, sumOfDepths, sumOfAllDepths);
  }

  static class TreeInfo {
    protected int numNodes;
    protected int sumOfDepths;
    protected int sumOfAllDepths;

    public TreeInfo(int numNodes, int sumOfDepths, int sumOfAllDepths) {
      this.numNodes = numNodes;
      this.sumOfDepths = sumOfDepths;
      this.sumOfAllDepths = sumOfAllDepths;
    }
  }

  static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
      left = null;
      right = null;
    }
  }

  // O(n) time | O(n) space - n is the number of the nodes in the tree.
  // public static int allKindsOfNodeDepths(BinaryTree root) {
  // HashMap<BinaryTree, Integer> nodeCounts = new HashMap<>();
  // HashMap<BinaryTree, Integer> nodeDepths = new HashMap<>();
  // getNodeCounts(root, nodeCounts);
  // getNodeDepths(root, nodeCounts, nodeDepths);
  // return sumAllDepths(root, nodeDepths);
  // }

  // public static void getNodeCounts(BinaryTree node, HashMap<BinaryTree,
  // Integer> nodeCounts) {
  // nodeCounts.put(node, 1);
  // if (node.left != null) {
  // getNodeCounts(node.left, nodeCounts);
  // nodeCounts.put(node, nodeCounts.get(node.left) + nodeCounts.get(node));
  // }

  // if (node.right != null) {
  // getNodeCounts(node.right, nodeCounts);
  // nodeCounts.put(node, nodeCounts.get(node.right) + nodeCounts.get(node));
  // }
  // }

  // public static void getNodeDepths(BinaryTree node, HashMap<BinaryTree,
  // Integer> nodeCounts,
  // HashMap<BinaryTree, Integer> nodeDepths) {
  // nodeDepths.put(node, 0);
  // if (node.left != null) {
  // getNodeDepths(node.left, nodeCounts, nodeDepths);
  // nodeDepths.put(node, nodeDepths.get(node) + nodeDepths.get(node.left) +
  // nodeCounts.get(node.left));
  // }

  // if (node.right != null) {
  // getNodeDepths(node.right, nodeCounts, nodeDepths);
  // nodeDepths.put(node, nodeDepths.get(node) + nodeDepths.get(node.right) +
  // nodeCounts.get(node.right));
  // }
  // }

  // public static int sumAllDepths(BinaryTree node, HashMap<BinaryTree, Integer>
  // nodeDepths) {
  // if (node == null)
  // return 0;

  // return sumAllDepths(node.left, nodeDepths) + sumAllDepths(node.right,
  // nodeDepths) + nodeDepths.get(node);
  // }

  // static class BinaryTree {
  // int value;
  // BinaryTree left;
  // BinaryTree right;

  // public BinaryTree(int value) {
  // this.value = value;
  // left = null;
  // right = null;
  // }
  // }

  // Average: O(nlogn) time | O(h) space - when the tree is balanced.
  // Worst: O(n^2) time | O(h) space - n is the number of the nodes, and h is the
  // height of the tree.
  // public static int allKindsOfNodeDepths(BinaryTree root) {
  // int depth = 0;

  // Stack<BinaryTree> stack = new Stack<>();
  // stack.add(root);
  // while (!stack.isEmpty()) {
  // BinaryTree node = stack.pop();
  // if (node == null)
  // continue;

  // depth += nodeDepth(node, 0);
  // stack.add(node.left);
  // stack.add(node.right);
  // }

  // return depth;
  // }

  // public static int nodeDepth(BinaryTree node, int depth) {
  // if (node == null)
  // return 0;

  // return depth + nodeDepth(node.left, depth + 1) + nodeDepth(node.right, depth
  // + 1);
  // }

  // static class BinaryTree {
  // int value;
  // BinaryTree left;
  // BinaryTree right;

  // public BinaryTree(int value) {
  // this.value = value;
  // left = null;
  // right = null;
  // }
  // }
}
