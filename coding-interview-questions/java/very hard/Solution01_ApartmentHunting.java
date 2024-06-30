import java.util.*;

class Program {
  // O(br) time | O(br) space - b is the number of blocks, and r is the number of
  // requirements.
  public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
    int[][] minDistancesFromBlocks = new int[reqs.length][blocks.size()];
    for (int i = 0; i < reqs.length; i++) {
      minDistancesFromBlocks[i] = getMinDistancesFromBlocks(blocks, reqs[i]);
    }

    int[] maxDistances = new int[blocks.size()];
    for (int i = 0; i < blocks.size(); i++) {
      int max = 0;
      for (int j = 0; j < reqs.length; j++) {
        max = Math.max(max, minDistancesFromBlocks[j][i]);
      }

      maxDistances[i] = max;
    }

    return getMinIdx(maxDistances);
  }

  public static int[] getMinDistancesFromBlocks(List<Map<String, Boolean>> blocks, String req) {
    int[] minDistances = new int[blocks.size()];

    int closestReqIdx = Integer.MAX_VALUE;
    for (int i = 0; i < blocks.size(); i++) {
      if (blocks.get(i).get(req))
        closestReqIdx = i;

      minDistances[i] = Math.abs(closestReqIdx - i);
    }

    closestReqIdx = Integer.MAX_VALUE;
    for (int i = blocks.size() - 1; i >= 0; i--) {
      if (blocks.get(i).get(req))
        closestReqIdx = i;

      minDistances[i] = Math.min(minDistances[i], Math.abs(closestReqIdx - i));
    }

    return minDistances;
  }

  public static int getMinIdx(int[] maxDistances) {
    int minIdx = 0;
    for (int i = 1; i < maxDistances.length; i++) {
      if (maxDistances[i] < maxDistances[minIdx])
        minIdx = i;
    }

    return minIdx;
  }

  // O(b^2 * r) time | O(b) space - b is the number of blocks, and r is the number
  // of requirements.
  // public static int apartmentHunting(List<Map<String, Boolean>> blocks,
  // String[] reqs) {
  // int[] maxDistances = new int[blocks.size()];
  // for (int i = 0; i < blocks.size(); i++) {
  // for (String req : reqs) {
  // int minDistance = Integer.MAX_VALUE;
  // for (int j = 0; j < blocks.size(); j++) {
  // if (blocks.get(j).get(req)) {
  // minDistance = Math.min(minDistance, Math.abs(j - i));
  // }
  // }

  // maxDistances[i] = Math.max(maxDistances[i], minDistance);
  // }
  // }

  // return getMinIdx(maxDistances);
  // }

  // public static int getMinIdx(int[] maxDistances) {
  // int minIdx = 0;
  // for (int i = 1; i < maxDistances.length; i++) {
  // if (maxDistances[i] < maxDistances[minIdx])
  // minIdx = i;
  // }

  // return minIdx;
  // }
}
