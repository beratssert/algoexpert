class Program {
  // O(n) time | O(1) space
  public static int kadanesAlgorithm(int[] array) {
    int maxSum = array[0];
    int currentSum = array[0];

    for (int i = 1; i < array.length; i++) {
      int num = array[i];
      currentSum = Math.max(currentSum + num, num);
      if (currentSum > maxSum)
        maxSum = currentSum;
    }

    return maxSum;
  }
}
