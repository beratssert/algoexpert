import java.util.*;

class Program {
  // O(n^2) time | O(n) space - n is the total number of the disks.
  public static List<Integer[]> diskStacking(List<Integer[]> disks) {
    disks.sort((disk1, disk2) -> disk1[2].compareTo(disk2[2]));

    int[] heights = new int[disks.size()];
    for (int i = 0; i < heights.length; i++) {
      heights[i] = disks.get(i)[2];
    }

    int[] sequence = new int[disks.size()];
    Arrays.fill(sequence, -1);

    int maxStackIdx = 0;
    for (int i = 1; i < disks.size(); i++) {
      Integer[] currentDisk = disks.get(i);
      for (int j = 0; j < i; j++) {
        Integer[] otherDisk = disks.get(j);
        if (isValidDimensions(currentDisk, otherDisk)) {
          if (heights[i] < heights[j] + currentDisk[2]) {
            heights[i] = heights[j] + currentDisk[2];
            sequence[i] = j;
          }
        }
      }

      if (heights[i] > heights[maxStackIdx])
        maxStackIdx = i;
    }

    return buildSequence(disks, sequence, maxStackIdx);
  }

  public static boolean isValidDimensions(Integer[] currentDisk, Integer[] otherDisk) {
    boolean isValidWidth = currentDisk[0] > otherDisk[0];
    boolean isValidDepth = currentDisk[1] > otherDisk[1];
    boolean isValidHeight = currentDisk[2] > otherDisk[2];
    return isValidDepth && isValidHeight && isValidWidth;
  }

  public static List<Integer[]> buildSequence(List<Integer[]> disks, int[] sequence, int maxStackIdx) {
    List<Integer[]> diskStack = new ArrayList<>();
    while (maxStackIdx != -1) {
      diskStack.add(disks.get(maxStackIdx));
      maxStackIdx = sequence[maxStackIdx];
    }

    Collections.reverse(diskStack);
    return diskStack;
  }
}
