import java.util.*;

class Program {
  // O(d * (n + b)) time | O(n + b) space - d is the max number of digits, n is
  // the length of the input array, and b is the base of the numbering system. b
  // is 10 for this question.
  public ArrayList<Integer> radixSort(ArrayList<Integer> array) {
    if (array.isEmpty())
      return array;

    Integer maxNumber = Collections.max(array);

    int digitCount = 0;
    while ((maxNumber / Math.pow(10, digitCount)) > 0) {
      countingSort(array, digitCount);
      digitCount++;
    }

    return array;
  }

  public void countingSort(ArrayList<Integer> array, int digit) {
    int[] countsOfDigits = new int[10]; // base is 10
    int[] sortedByDigits = new int[array.size()];

    int divisor = (int) Math.pow(10, digit);

    for (int num : array) {
      int digitOfNum = (num / divisor) % 10;
      countsOfDigits[digitOfNum]++;
    }

    for (int i = 1; i < countsOfDigits.length; i++) {
      countsOfDigits[i] += countsOfDigits[i - 1];
    }

    for (int i = array.size() - 1; i >= 0; i--) {
      int num = array.get(i);
      int digitOfNum = (num / divisor) % 10;
      int sortedIdx = --countsOfDigits[digitOfNum];
      sortedByDigits[sortedIdx] = num;
    }

    for (int i = 0; i < array.size(); i++) {
      array.set(i, sortedByDigits[i]);
    }
  }
}
