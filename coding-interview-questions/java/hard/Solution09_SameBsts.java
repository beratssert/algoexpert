import java.util.*;

class Program {
  // O(n^2) time | O(d) space - n is the number of the nodes in the each array,
  // and d is the depth of the BST that they represent
  public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
    return areSameBsts(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public static boolean areSameBsts(List<Integer> arrayOne, List<Integer> arrayTwo, int rootOneIdx, int rootTwoIdx,
      int minValue, int maxValue) {

    if (rootOneIdx == -1 || rootTwoIdx == -1)
      return rootOneIdx == rootTwoIdx;

    if (arrayOne.get(rootOneIdx) != arrayTwo.get(rootTwoIdx))
      return false;

    int leftOneRootIdx = getSmallerThanRoot(arrayOne, rootOneIdx, minValue);
    int leftTwoRootIdx = getSmallerThanRoot(arrayTwo, rootTwoIdx, minValue);
    int rightOneRootIdx = getBiggerOrEqualThanRoot(arrayOne, rootOneIdx, maxValue);
    int rightTwoRootIdx = getBiggerOrEqualThanRoot(arrayTwo, rootTwoIdx, maxValue);

    int currentValue = arrayOne.get(rootOneIdx);
    boolean isLeftSame = areSameBsts(arrayOne, arrayTwo, leftOneRootIdx, leftTwoRootIdx, minValue, currentValue);
    boolean isRightSame = areSameBsts(arrayOne, arrayTwo, rightOneRootIdx, rightTwoRootIdx, currentValue, maxValue);

    return isLeftSame && isRightSame;
  }

  public static int getSmallerThanRoot(List<Integer> array, int startingIdx, int minValue) {
    for (int i = startingIdx + 1; i < array.size(); i++) {
      if (array.get(i) < array.get(startingIdx) && array.get(i) >= minValue)
        return i;
    }
    return -1;
  }

  public static int getBiggerOrEqualThanRoot(List<Integer> array, int startingIdx, int maxValue) {
    for (int i = startingIdx + 1; i < array.size(); i++) {
      if (array.get(i) >= array.get(startingIdx) && array.get(i) < maxValue)
        return i;
    }
    return -1;
  }

  // O(n^2) time | O(n^2) space - n is the number of the nodes in each array,
  // respectively
  // public static boolean sameBsts(List<Integer> arrayOne, List<Integer>
  // arrayTwo) {
  // if (arrayOne.size() != arrayTwo.size())
  // return false;

  // if (arrayOne.size() == 0 && arrayTwo.size() == 0)
  // return true;

  // if (arrayOne.get(0) != arrayTwo.get(0))
  // return false;

  // List<Integer> leftOne = getSmallerThanRoot(arrayOne);
  // List<Integer> leftTwo = getSmallerThanRoot(arrayTwo);
  // List<Integer> rightOne = getBiggerOrEqualThanRoot(arrayOne);
  // List<Integer> rightTwo = getBiggerOrEqualThanRoot(arrayTwo);

  // return sameBsts(leftOne, leftTwo) && sameBsts(rightOne, rightTwo);
  // }

  // public static List<Integer> getSmallerThanRoot(List<Integer> array) {
  // List<Integer> smallNums = new ArrayList<>();
  // for (int i = 1; i < array.size(); i++) {
  // int num = array.get(i);
  // if (num < array.get(0))
  // smallNums.add(num);
  // }

  // return smallNums;
  // }

  // public static List<Integer> getBiggerOrEqualThanRoot(List<Integer> array) {
  // List<Integer> largerOrEqualNums = new ArrayList<>();
  // for (int i = 1; i < array.size(); i++) {
  // int num = array.get(i);
  // if (num >= array.get(0))
  // largerOrEqualNums.add(num);
  // }

  // return largerOrEqualNums;
  // }
}
