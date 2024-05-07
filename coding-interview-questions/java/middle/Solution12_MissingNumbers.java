import java.util.*;

class Program {
  // O(n) time | O(1) space
  public int[] missingNumbers(int[] nums) {
    int total = sum(1, nums.length + 3);

    int numsSum = 0;
    for (int num : nums) {
      numsSum += num;
    }

    int averageMissingNums = (total - numsSum) / 2;
    int sumFirstHalf = 0;
    int sumSecondHalf = 0;
    for (int num : nums) {
      if (num <= averageMissingNums) {
        sumFirstHalf += num;
      } else {
        sumSecondHalf += num;
      }
    }

    int expectedFirstHalf = sum(1, averageMissingNums + 1);
    int expectedSecondHalf = sum(averageMissingNums + 1, nums.length + 3);

    return new int[] { expectedFirstHalf - sumFirstHalf, expectedSecondHalf - sumSecondHalf };
  }

  public int sum(int start, int end) {
    int sum = 0;
    for (int i = start; i < end; i++) {
      sum += i;
    }

    return sum;
  }

  // O(n) time | O(n) space - n is the length of the nums.
  // public int[] missingNumbers(int[] nums) {
  // HashSet<Integer> setNums = new HashSet<>();
  // for (int num : nums) {
  // setNums.add(num);
  // }

  // int[] missingNums = new int[2];
  // int idx = 0;
  // for (int i = 1; i <= nums.length + 2; i++) {
  // if (!setNums.contains(i)) {
  // missingNums[idx] = i;
  // idx++;
  // }
  // }

  // return missingNums;
  // }
}
