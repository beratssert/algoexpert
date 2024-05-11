import java.util.*;

class Program {
  // O(n) time | O(1) space - n is the lenght of the array
  public int[] longestSubarrayWithSum(int[] array, int targetSum) {
    int[] indices = new int[0];

    int start = 0;
    int end = 0;
    int sum = 0;
    while (end < array.length) {
      sum += array[end];
      while (start < end && sum > targetSum) {
        sum -= array[start];
        start++;
      }

      if (sum == targetSum) {
        if (indices.length == 0 || indices[1] - indices[0] < end - start)
          indices = new int[] { start, end };
      }

      end++;
    }

    return indices;
  }

  // O(n^2) time | O(1) space - n is the length of the array
  // public int[] longestSubarrayWithSum(int[] array, int targetSum) {
  // int[] indices = new int[0];

  // for (int i = 0; i < array.length; i++) {
  // int sum = 0;
  // for (int j = i; j < array.length; j++) {
  // sum += array[j];
  // if (sum == targetSum) {
  // if (indices.length == 0 || indices[1] - indices[0] < j - i)
  // indices = new int[] { i, j };
  // }
  // }
  // }

  // return indices;
  // }
}
