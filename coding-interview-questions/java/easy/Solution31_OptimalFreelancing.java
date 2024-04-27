import java.util.*;

class Program {
  // O(nlogn) time | O(1) space - n is the number of the jobs.
  public int optimalFreelancing(Map<String, Integer>[] jobs) {
    // Sort by payment
    Arrays.sort(jobs, new Comparator<Map<String, Integer>>() {
      public int compare(final Map<String, Integer> jobOne, final Map<String, Integer> jobTwo) {
        return jobTwo.get("payment").compareTo(jobOne.get("payment"));
      }
    });

    final int weekDays = 7;
    boolean[] timeline = new boolean[weekDays]; // a week timeline
    int profit = 0;
    for (Map<String, Integer> job : jobs) {
      int maxTime = Math.min(job.get("deadline"), weekDays);
      for (int i = maxTime - 1; i >= 0; i--) {
        if (timeline[i] == false) {
          timeline[i] = true;
          profit += job.get("payment");
          break;
        }
      }
    }

    return profit;
  }
}
