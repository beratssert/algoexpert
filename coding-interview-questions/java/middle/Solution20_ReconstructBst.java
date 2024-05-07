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

  // O(n) time | O(n) space - n is the length of the array.
  static class TreeInfo {
    public int rootIdx;

    TreeInfo(int rootIdx) {
      this.rootIdx = rootIdx;
    }
  }

  public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
    TreeInfo treeInfo = new TreeInfo(0);
    return constructBstFromRange(Integer.MIN_VALUE, Integer.MAX_VALUE,
        preOrderTraversalValues, treeInfo);
  }

  public BST constructBstFromRange(int lowerBound, int upperBound,
      ArrayList<Integer> preOrderTraversalValues,
      TreeInfo subtreeInfo) {
    if (subtreeInfo.rootIdx == preOrderTraversalValues.size())
      return null;

    int rootValue = preOrderTraversalValues.get(subtreeInfo.rootIdx);

    if (rootValue < lowerBound || rootValue >= upperBound)
      return null;

    subtreeInfo.rootIdx += 1;

    BST leftSubtree = constructBstFromRange(lowerBound, rootValue,
        preOrderTraversalValues, subtreeInfo);
    BST rightSubtree = constructBstFromRange(rootValue, upperBound,
        preOrderTraversalValues, subtreeInfo);

    BST node = new BST(rootValue);
    node.left = leftSubtree;
    node.right = rightSubtree;

    return node;
  }

  // O(n^2) time | O(n) space - n is the length of the array.
  // public BST reconstructBst(List<Integer> preOrderTraversalValues) {
  // if (preOrderTraversalValues.size() == 0)
  // return null;

  // int currentValue = preOrderTraversalValues.get(0);
  // int rigtSubtreeRootIdx = preOrderTraversalValues.size();

  // for (int i = 1; i < preOrderTraversalValues.size(); i++) {
  // int value = preOrderTraversalValues.get(i);
  // if (value >= currentValue) {
  // rigtSubtreeRootIdx = i;
  // break;
  // }
  // }

  // BST leftSubtree = reconstructBst(preOrderTraversalValues.subList(1,
  // rigtSubtreeRootIdx));
  // BST rightSubtree = reconstructBst(
  // preOrderTraversalValues.subList(rigtSubtreeRootIdx,
  // preOrderTraversalValues.size()));

  // BST node = new BST(currentValue);
  // node.left = leftSubtree;
  // node.right = rightSubtree;

  // return node;
  // }
}
