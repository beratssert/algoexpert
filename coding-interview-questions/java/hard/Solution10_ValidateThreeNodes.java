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

  // Average: O(d) time | O(1) space - d is the distance between nodeOne and
  // nodeThree
  // Worst: O(h) time | O(1) space - h is the height of the tree.
  public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
    BST searchOne = nodeOne;
    BST searchThree = nodeThree;

    while (true) {
      boolean foundNodeThreeFromOne = searchOne == nodeThree;
      boolean foundNodeOneFromThree = searchThree == nodeOne;
      boolean foundNodeTwo = (searchOne == nodeTwo) || (searchThree == nodeTwo);
      boolean finishedSearching = searchOne == null && searchThree == null;

      if (foundNodeOneFromThree || foundNodeThreeFromOne || foundNodeTwo || finishedSearching)
        break;

      if (searchOne != null)
        searchOne = nodeTwo.value < searchOne.value ? searchOne.left : searchOne.right;

      if (searchThree != null)
        searchThree = nodeTwo.value < searchThree.value ? searchThree.left : searchThree.right;
    }

    boolean foundNodeFromOther = searchOne == nodeThree || searchThree == nodeOne;
    boolean foundNodeTwo = searchOne == nodeTwo || searchThree == nodeTwo;
    if (!foundNodeTwo || foundNodeFromOther)
      return false;

    return searchForTarget(nodeTwo, searchOne == nodeTwo ? nodeThree : nodeOne);
  }

  public boolean searchForTarget(BST node, BST target) {
    while (node != null && node != target) {
      if (target.value < node.value)
        node = node.left;
      else
        node = node.right;
    }

    return node == target;
  }

  // O(h) time | O(1) space - h is the height of the tree
  // public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
  // if (isDescendant(nodeOne, nodeTwo))
  // return isDescendant(nodeTwo, nodeThree);

  // else if (isDescendant(nodeThree, nodeTwo))
  // return isDescendant(nodeTwo, nodeOne);

  // return false;
  // }

  // public boolean isDescendant(BST node, BST target) {
  // while (node != null && node != target) {
  // if (target.value < node.value)
  // node = node.left;
  // else
  // node = node.right;
  // }

  // return node == target;
  // }
}
