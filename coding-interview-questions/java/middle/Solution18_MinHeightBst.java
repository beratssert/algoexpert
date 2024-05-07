import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the number of the nodes.
  public static BST minHeightBst(List<Integer> array) {
    return minHeightBst(array, 0, array.size() - 1);
  }

  public static BST minHeightBst(List<Integer> array, int startIdx, int endIdx) {
    if (endIdx < startIdx)
      return null;

    int midIdx = (startIdx + endIdx) / 2;
    BST bst = new BST(array.get(midIdx));

    bst.left = minHeightBst(array, startIdx, midIdx - 1);
    bst.right = minHeightBst(array, midIdx + 1, endIdx);

    return bst;
  }

  // O(n) time | O(n) space - n is the number of the nodes.
  // public static BST minHeightBst(List<Integer> array) {
  // return minHeightBst(array, null, 0, array.size() - 1);
  // }

  // public static BST minHeightBst(List<Integer> array, BST bst, int startIdx,
  // int endIdx) {
  // if (endIdx < startIdx)
  // return null;

  // int midIdx = (startIdx + endIdx) / 2;
  // BST newBst = new BST(array.get(midIdx));
  // if (bst == null) {
  // bst = newBst;
  // } else {
  // if (newBst.value < bst.value) {
  // bst.left = newBst;
  // bst = bst.left;
  // } else {
  // bst.right = newBst;
  // bst = bst.right;
  // }
  // }

  // minHeightBst(array, bst, startIdx, midIdx - 1);
  // minHeightBst(array, bst, midIdx + 1, endIdx);

  // return bst;
  // }

  // O(nlogn) time | O(n) space - n is the number of the nodes
  // public static BST minHeightBst(List<Integer> array) {
  // return minHeightBst(array, null, 0, array.size() - 1);
  // }

  // public static BST minHeightBst(List<Integer> array, BST bst, int startIdx,
  // int endIdx) {
  // if (endIdx < startIdx)
  // return null;

  // int midIdx = (startIdx + endIdx) / 2;
  // int value = array.get(midIdx);
  // if (bst == null) {
  // bst = new BST(value);
  // } else {
  // bst.insert(value);
  // }

  // minHeightBst(array, bst, startIdx, midIdx - 1);
  // minHeightBst(array, bst, midIdx + 1, endIdx);

  // return bst;
  // }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
      left = null;
      right = null;
    }

    public void insert(int value) {
      if (value < this.value) {
        if (left == null) {
          left = new BST(value);
        } else {
          left.insert(value);
        }
      } else {
        if (right == null) {
          right = new BST(value);
        } else {
          right.insert(value);
        }
      }
    }
  }
}
