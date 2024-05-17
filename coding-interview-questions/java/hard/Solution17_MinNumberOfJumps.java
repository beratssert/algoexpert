import java.util.*;

class Program {
  // O(n) time | O(1) space - n is the length of the array
  public static int minNumberOfJumps(int[] array) {
    if (array.length == 1)
      return 0;

    int maxReach = array[0];
    int steps = array[0];
    int jumps = 0;
    for (int i = 1; i < array.length - 1; i++) {
      maxReach = Math.max(maxReach, array[i] + i);
      steps--;
      if (steps == 0) {
        jumps++;
        steps = maxReach - i;
      }
    }

    return jumps + 1;
  }

  // O(n^2) time | O(n) space - n is the length of the array
  // public static int minNumberOfJumps(int[] array) {
  // int[] jumps = new int[array.length];
  // Arrays.fill(jumps, Integer.MAX_VALUE);
  // jumps[0] = 0;

  // for (int i = 1; i < array.length; i++) {
  // for (int j = 0; j < i; j++) {
  // if (j + array[j] >= i) {
  // jumps[i] = Math.min(jumps[i], jumps[j] + 1);
  // }
  // }
  // }

  // return jumps[jumps.length - 1];
  // }
}
