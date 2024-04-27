import java.util.*;

class Program {
  // O(nlogn) time | O(1) space - n is the number of the tandem bicycles
  public int tandemBicycle(
      int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
    Arrays.sort(redShirtSpeeds);
    Arrays.sort(blueShirtSpeeds);

    if (fastest) {
      reverseOrderInPlace(blueShirtSpeeds);
    }

    int totalSpeed = 0;
    for (int i = 0; i < redShirtSpeeds.length; i++) {
      int redSpeed = redShirtSpeeds[i];
      int blueSpeed = blueShirtSpeeds[i];
      totalSpeed += Math.max(redSpeed, blueSpeed);
    }

    return totalSpeed;
  }

  public void reverseOrderInPlace(int[] array) {
    int startIdx = 0;
    int endIdx = array.length - 1;
    while (startIdx < endIdx) {
      int temp = array[startIdx];
      array[startIdx] = array[endIdx];
      array[endIdx] = temp;
      startIdx++;
      endIdx--;
    }
  }

  // O(nlogn) time | O(1) space - n is the number of the tandem bicycles
  // public int tandemBicycle(
  // int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
  // Arrays.sort(redShirtSpeeds);
  // Arrays.sort(blueShirtSpeeds);

  // int totalSpeed = 0;
  // for (int i = 0; i < redShirtSpeeds.length; i++) {
  // int redSpeed = redShirtSpeeds[i];
  // int blueSpeed = fastest ? blueShirtSpeeds[blueShirtSpeeds.length - i - 1] :
  // blueShirtSpeeds[i];
  // totalSpeed += Math.max(redSpeed, blueSpeed);
  // }

  // return totalSpeed;
  // }
}
