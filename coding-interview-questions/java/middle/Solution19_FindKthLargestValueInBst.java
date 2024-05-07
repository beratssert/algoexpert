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

  // O(h + k) time | O(h) space - h is the height of the tree and k is the input.
  static class TreeInfo {
    public int nodesVisited;
    public int latestVisitedNodeValue;

    TreeInfo(int nodesVisited, int latestVisitedNodeValue) {
      this.nodesVisited = nodesVisited;
      this.latestVisitedNodeValue = latestVisitedNodeValue;
    }
  }

  public int findKthLargestValueInBst(BST tree, int k) {
    TreeInfo treeInfo = new TreeInfo(0, -1);
    reverseInorderTraverse(tree, k, treeInfo);
    return treeInfo.latestVisitedNodeValue;
  }

  public void reverseInorderTraverse(BST node, int k, TreeInfo treeInfo) {
    if (node == null || treeInfo.nodesVisited == k)
      return;

    reverseInorderTraverse(node.right, k, treeInfo);
    if (treeInfo.nodesVisited < k) {
      treeInfo.nodesVisited += 1;
      treeInfo.latestVisitedNodeValue = node.value;
      reverseInorderTraverse(node.left, k, treeInfo);
    }

  }

  // O(n) time | O(n) space - n is the number of the nodes.
  // public int findKthLargestValueInBst(BST tree, int k) {
  // ArrayList<Integer> nodes = new ArrayList<>();
  // findKthLargestValueInBst(tree, nodes);
  // return nodes.get(nodes.size() - k);
  // }

  // public void findKthLargestValueInBst(BST tree, ArrayList<Integer> nodes) {
  // if (tree.left != null)
  // findKthLargestValueInBst(tree.left, nodes);

  // nodes.add(tree.value);

  // if (tree.right != null)
  // findKthLargestValueInBst(tree.right, nodes);
  // }

}
