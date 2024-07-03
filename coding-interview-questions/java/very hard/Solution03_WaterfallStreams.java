import java.util.*;

class Program {
  // O(w^2 * h) time | O(w) space - w is the width, and h is the height of the
  // input array.
  public double[] waterfallStreams(double[][] array, int source) {
    double[] rowAbove = array[0].clone();
    rowAbove[source] = 100;

    for (int row = 1; row < array.length; row++) {
      double[] currentRow = array[row].clone();
      for (int i = 0; i < currentRow.length; i++) {
        double valueAbove = rowAbove[i];

        boolean hasWaterAbove = valueAbove > 0 && valueAbove != 1;
        boolean isBlock = currentRow[i] == 1.0;

        if (!hasWaterAbove)
          continue;

        if (!isBlock) {
          currentRow[i] += valueAbove;
          continue;
        }

        double splitWater = valueAbove / 2;

        int left = i;
        while (left - 1 >= 0) {
          left--;
          if (rowAbove[left] == 1)
            break;

          if (currentRow[left] != 1) {
            currentRow[left] += splitWater;
            break;
          }
        }

        int right = i;
        while (right + 1 < rowAbove.length) {
          right++;
          if (rowAbove[right] == 1)
            break;

          if (currentRow[right] != 1) {
            currentRow[right] += splitWater;
            break;
          }
        }
      }

      rowAbove = currentRow;
    }

    return rowAbove;
  }
}
