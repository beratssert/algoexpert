import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the length of the scores
  public static int minRewards(int[] scores) {
    int[] rewards = new int[scores.length];
    Arrays.fill(rewards, 1);

    for (int i = 1; i < scores.length; i++) {
      if (scores[i] > scores[i - 1])
        rewards[i] = rewards[i - 1] + 1;
    }

    for (int i = scores.length - 2; i >= 0; i--) {
      if (scores[i] > scores[i + 1])
        rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
    }

    int sum = 0;
    for (Integer reward : rewards) {
      sum += reward;
    }

    return sum;
  }

  // O(n) time | O(n) space - n is the length of the scores
  // public static int minRewards(int[] scores) {
  // int[] rewards = new int[scores.length];
  // Arrays.fill(rewards, 1);
  // List<Integer> localMinIndices = getLocalMins(scores);
  // for (Integer idx : localMinIndices) {
  // expandFromLocalMin(idx, rewards, scores);
  // }

  // int sum = 0;
  // for (Integer reward : rewards) {
  // sum += reward;
  // }

  // return sum;
  // }

  // public static void expandFromLocalMin(int idx, int[] rewards, int[] scores) {
  // int left = idx - 1;
  // while (left >= 0 && scores[left] > scores[left + 1]) {
  // rewards[left] = Math.max(rewards[left], rewards[left + 1] + 1);
  // left--;
  // }

  // int right = idx + 1;
  // while (right < scores.length && scores[right] > scores[right - 1]) {
  // rewards[right] = rewards[right - 1] + 1;
  // right++;
  // }
  // }

  // public static List<Integer> getLocalMins(int[] array) {
  // List<Integer> localMins = new ArrayList<>();
  // if (array.length == 1) {
  // localMins.add(0);
  // return localMins;
  // }
  // for (int i = 0; i < array.length; i++) {
  // if (i == 0 && array[i] < array[i + 1])
  // localMins.add(i);
  // if (i == array.length - 1 && array[i] < array[i - 1])
  // localMins.add(i);
  // if (i == 0 || i == array.length - 1)
  // continue;
  // if (array[i] < array[i - 1] && array[i] < array[i + 1])
  // localMins.add(i);

  // }

  // return localMins;
  // }

  // O(n^2) time | O(n) space - n is the number of the scores
  // public static int minRewards(int[] scores) {
  // int[] rewards = new int[scores.length];
  // Arrays.fill(rewards, 1);
  // for (int i = 1; i < rewards.length; i++) {
  // if (scores[i] > scores[i - 1]) {
  // rewards[i] = rewards[i - 1] + 1;
  // } else {
  // int j = i - 1;
  // while (j >= 0 && scores[j] > scores[j + 1]) {
  // rewards[j] = Math.max(rewards[j], rewards[j + 1] + 1);
  // j--;
  // }
  // }
  // }

  // int sum = 0;
  // for (int reward : rewards) {
  // sum += reward;
  // }

  // return sum;
  // }
}
