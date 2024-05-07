import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the length of the nums
  public boolean zeroSumSubarray(int[] nums) {
    HashSet<Integer> sums = new HashSet<>();
    sums.add(0);
    int currentSum = 0;
    for (int num : nums) {
      currentSum += num;
      if (sums.contains(currentSum))
        return true;

      sums.add(currentSum);
    }

    return false;
  }

  // O(n^2) time | O(1) space
  // public boolean zeroSumSubarray(int[] nums) {
  // for (int i = 0; i < nums.length; i++) {
  // int sum = 0;
  // for (int j = i; j < nums.length; j++) {
  // sum += nums[j];
  // if (sum == 0) {
  // return true;
  // }
  // }
  // }

  // return false;
  // }
}
