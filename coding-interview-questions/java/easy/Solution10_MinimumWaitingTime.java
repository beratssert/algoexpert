import java.util.*;

class Program {
  // O(nlogn) time | O(1) space - n is the number of the queries.
  public int minimumWaitingTime(int[] queries) {
    Arrays.sort(queries);

    int waitingTime = 0;
    for (int i = 0; i < queries.length; i++) {
      int duration = queries[i];
      int queriesLeft = queries.length - (i + 1);
      waitingTime += duration * queriesLeft;
    }

    return waitingTime;
  }

  // O(nlogn) time | O(1) space - n is the number of the queries.
  // public int minimumWaitingTime(int[] queries) {
  // Arrays.sort(queries);
  // int waitingTime = 0;
  // int sum = 0;
  // for (int query : queries) {
  // sum += waitingTime;
  // waitingTime += query;
  // }
  // return sum;
  // }
}
