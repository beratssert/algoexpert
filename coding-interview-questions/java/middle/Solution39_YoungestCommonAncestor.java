import java.util.*;

class Program {
  // O(h) time | O(1) space - h is the height of the tree.
  public static AncestralTree getYoungestCommonAncestor(
      AncestralTree topAncestor,
      AncestralTree descendantOne,
      AncestralTree descendantTwo) {
    int depthOne = getDepth(descendantOne, topAncestor);
    int depthTwo = getDepth(descendantTwo, topAncestor);

    if (depthOne > depthTwo) {
      return youngestCommonAncestor(descendantOne, descendantTwo, depthOne - depthTwo);
    } else {
      return youngestCommonAncestor(descendantTwo, descendantOne, depthTwo - depthOne);
    }
  }

  public static int getDepth(AncestralTree node, AncestralTree topAncestor) {
    int depth = 0;
    while (node != topAncestor) {
      depth++;
      node = node.ancestor;
    }

    return depth;
  }

  public static AncestralTree youngestCommonAncestor(AncestralTree lower, AncestralTree higher, int depth) {
    while (depth > 0) {
      lower = lower.ancestor;
      depth--;
    }

    while (lower != higher) {
      lower = lower.ancestor;
      higher = higher.ancestor;
    }

    return higher;
  }

  // O(h) time | O(h) space - h is the height of the tree.
  // public static AncestralTree getYoungestCommonAncestor(
  // AncestralTree topAncestor,
  // AncestralTree descendantOne,
  // AncestralTree descendantTwo) {
  // HashSet<Character> ancestors = new HashSet<>();
  // AncestralTree node = descendantOne;
  // while (node != null) {
  // ancestors.add(node.name);
  // node = node.ancestor;
  // }

  // node = descendantTwo;
  // while (node != null) {
  // if (ancestors.contains(node.name))
  // return node;

  // node = node.ancestor;
  // }

  // return null;
  // }

  static class AncestralTree {
    public char name;
    public AncestralTree ancestor;

    AncestralTree(char name) {
      this.name = name;
      this.ancestor = null;
    }

    // This method is for testing only.
    void addAsAncestor(AncestralTree[] descendants) {
      for (AncestralTree descendant : descendants) {
        descendant.ancestor = this;
      }
    }
  }
}
