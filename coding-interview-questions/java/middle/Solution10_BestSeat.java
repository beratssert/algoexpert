class Program {
  // O(n) time | O(1) space - n is the length of the seats.
  public int bestSeat(int[] seats) {
    int bestSeat = -1;
    int numberOfSpace = 0;

    int left = 0;
    while (left < seats.length - 1) {
      int right = left + 1;
      while (seats[right] == 0) {
        right++;
      }

      int availableSpace = right - left - 1;
      if (availableSpace > numberOfSpace) {
        bestSeat = (left + right) / 2;
        numberOfSpace = availableSpace;
      }

      left = right;
    }

    return bestSeat;
  }
}
