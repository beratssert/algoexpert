import java.util.*;

class Program {
  // O(n) time | O(n) space
  public static int[] twoNumberSum(int[] array, int targetSum) {
    Set<Integer> nums = new HashSet<>();
    for (int num : array) {
      int potentialMatch = targetSum - num;
      if (nums.contains(num)) {
        return new int[] { num, potentialMatch };
      }

      nums.add(potentialMatch);
    }

    return new int[0];
  }

  // O(n^2) time | O(1) space
  // public static int[] twoNumberSum(int[] array, int targetSum) {
  // for (int i = 0; i < array.length - 1; i++) {
  // int num1 = array[i];
  // for (int j = i + 1; j < array.length; j++) {
  // int num2 = array[j];

  // if (num1 + num2 == targetSum) {
  // return new int[] { num1, num2 };
  // }
  // }
  // }

  // return new int[0];
  // }

  // O(nlogn) time | O(1) space
  // public static int[] twoNumberSum(int[] array, int targetSum) {
  // Arrays.sort(array);

  // int leftIdx = 0;
  // int rightIdx = array.length - 1;
  // while (leftIdx < rightIdx) {
  // int firstNum = array[leftIdx];
  // int secondNum = array[rightIdx];

  // if (firstNum + secondNum == targetSum) {
  // return new int[] { firstNum, secondNum };
  // } else if (firstNum + secondNum < targetSum) {
  // leftIdx++;
  // } else {
  // rightIdx--;
  // }
  // }
  // return new int[0];
  // }
}
