import java.util.*;

class Program {
  // Average: O(nlogn time) | O(n) space
  // Worst: O(n^2) time | O(n) space - n is the length of the array.
  public static List<Integer> rightSmallerThan(List<Integer> array) {
    if (array.isEmpty())
      return new ArrayList<>();

    int lastIdx = array.size() - 1;
    SpecialBST bst = new SpecialBST(array.get(lastIdx));
    List<Integer> output = new ArrayList<>(array);
    output.set(lastIdx, 0);
    for (int i = array.size() - 2; i >= 0; i--) {
      bst.insert(array.get(i), i, 0, output);
    }

    return output;
  }

  static class SpecialBST {
    int value;
    protected int sizeOfLeftSubtree;
    protected SpecialBST left;
    protected SpecialBST right;

    public SpecialBST(int value) {
      this.value = value;
    }

    public void insert(int value, int idx, int numOfSmallerAtIdx, List<Integer> output) {
      if (value < this.value) {
        this.sizeOfLeftSubtree++;
        if (this.left == null) {
          this.left = new SpecialBST(value);
          output.set(idx, numOfSmallerAtIdx);
        } else
          this.left.insert(value, idx, numOfSmallerAtIdx, output);

      } else {
        numOfSmallerAtIdx += sizeOfLeftSubtree;
        if (value > this.value)
          numOfSmallerAtIdx++;

        if (right == null) {
          right = new SpecialBST(value);
          output.set(idx, numOfSmallerAtIdx);
        } else
          right.insert(value, idx, numOfSmallerAtIdx, output);
      }
    }
  }

  // Average: O(nlogn time) | O(n) space
  // Worst: O(n^2) time | O(n) space - n is the length of the array.
  // public static List<Integer> rightSmallerThan(List<Integer> array) {
  // List<Integer> output = new ArrayList<>();

  // if (array.isEmpty())
  // return output;

  // int lastIdx = array.size() - 1;
  // SpecialBST bst = new SpecialBST(array.get(lastIdx), lastIdx, 0);
  // for (int i = array.size() - 2; i >= 0; i--) {
  // bst.insert(array.get(i), i, 0);
  // }

  // Integer[] result = new Integer[array.size()];
  // getResult(bst, result);
  // return Arrays.asList(result);
  // }

  // public static void getResult(SpecialBST bst, Integer[] result) {
  // if (bst == null)
  // return;

  // result[bst.idx] = bst.numOfSmallerAtIdx;
  // getResult(bst.left, result);
  // getResult(bst.right, result);
  // }

  // static class SpecialBST {
  // int value;
  // protected int idx;
  // protected int numOfSmallerAtIdx;
  // protected int sizeOfLeftSubtree;
  // protected SpecialBST left;
  // protected SpecialBST right;

  // public SpecialBST(int value, int idx, int numOfSmallerAtIdx) {
  // this.value = value;
  // this.idx = idx;
  // this.numOfSmallerAtIdx = numOfSmallerAtIdx;
  // }

  // public void insert(int value, int idx, int numOfSmallerAtIdx) {
  // if (value < this.value) {
  // this.sizeOfLeftSubtree++;
  // if (this.left == null)
  // this.left = new SpecialBST(value, idx, numOfSmallerAtIdx);
  // else
  // this.left.insert(value, idx, numOfSmallerAtIdx);

  // } else {
  // numOfSmallerAtIdx += sizeOfLeftSubtree;
  // if (value > this.value)
  // numOfSmallerAtIdx++;

  // if (right == null)
  // right = new SpecialBST(value, idx, numOfSmallerAtIdx);
  // else
  // right.insert(value, idx, numOfSmallerAtIdx);
  // }
  // }
  // }

  // O(n^2) time | O(n) space - n is the length of the array.
  // public static List<Integer> rightSmallerThan(List<Integer> array) {
  // List<Integer> output = new ArrayList<>();
  // for (int i = 0; i < array.size(); i++) {
  // int leftNum = array.get(i);
  // int count = 0;
  // for (int j = i + 1; j < array.size(); j++) {
  // int rightNum = array.get(j);
  // if (rightNum < leftNum)
  // count++;
  // }

  // output.add(count);
  // }

  // return output;
  // }
}
