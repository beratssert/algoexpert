import java.util.*;

class Program {
  // O(n) time | O(1) space - n is the length of the array.
  public static int waterArea(int[] heights) {
    if (heights.length == 0)
      return 0;

    int leftIdx = 0;
    int rightIdx = heights.length - 1;
    int leftMax = heights[leftIdx];
    int rightMax = heights[rightIdx];
    int totalSurfaceArea = 0;

    while (leftIdx < rightIdx) {
      if (heights[rightIdx] < heights[leftIdx]) {
        rightIdx--;
        rightMax = Math.max(rightMax, heights[rightIdx]);
        totalSurfaceArea += rightMax - heights[rightIdx];
      } else {
        leftIdx++;
        leftMax = Math.max(leftMax, heights[leftIdx]);
        totalSurfaceArea += leftMax - heights[leftIdx];
      }
    }

    return totalSurfaceArea;
  }

  // O(n) time | O(n) space - n is the length of the heights array.
  // public static int waterArea(int[] heights) {
  // int[] maxes = new int[heights.length];
  // int leftMax = 0;
  // for (int i = 0; i < heights.length; i++) {
  // int height = heights[i];
  // maxes[i] = leftMax;
  // leftMax = Math.max(leftMax, height);
  // }

  // int rightMax = 0;
  // for (int i = heights.length - 1; i >= 0; i--) {
  // int height = heights[i];
  // int minHeight = Math.min(rightMax, maxes[i]);
  // if (minHeight > height)
  // maxes[i] = minHeight - height;
  // else
  // maxes[i] = 0;

  // rightMax = Math.max(rightMax, height);
  // }

  // return sum(maxes);
  // }

  // public static int sum(int[] array) {
  // int sum = 0;
  // for (int num : array) {
  // sum += num;
  // }

  // return sum;
  // }
}
