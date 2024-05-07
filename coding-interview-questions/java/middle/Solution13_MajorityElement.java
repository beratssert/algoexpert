class Program {
  // O(n) time | O(1) space - n is the length of the array
  public int majorityElement(int[] array) {
    int majority = array[0];
    int count = 0;

    for (int num : array) {
      if (count == 0)
        majority = num;

      if (num == majority) {
        count++;
      } else {
        count--;
      }
    }

    return majority;
  }
}
