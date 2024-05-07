import java.util.*;

class Program {
  // O(n) time | O(1) space - n is the length of the array
  public int[] threeNumberSort(int[] array, int[] order) {
    int firstValue = order[0];
    int secondValue = order[1];

    int firstIdx = 0;
    int secondIdx = 0;
    int thirdIdx = array.length - 1;
    while (secondIdx <= thirdIdx) {
      int value = array[secondIdx];
      if (value == firstValue) {
        swap(array, firstIdx, secondIdx);
        firstIdx++;
        secondIdx++;
      } else if (value == secondValue) {
        secondIdx++;
      } else {
        swap(array, thirdIdx, secondIdx);
        thirdIdx--;
      }
    }

    return array;
  }

  // O(n) time | O(1) space - n is the length of the array
  // public int[] threeNumberSort(int[] array, int[] order) {
  // int firstValue = order[0];
  // int thirdValue = order[2];

  // int firstIdx = 0;
  // for (int i = 0; i < array.length; i++) {
  // if (array[i] == firstValue) {
  // swap(array, i, firstIdx);
  // firstIdx++;
  // }
  // }

  // int thirdIdx = array.length - 1;
  // for (int i = array.length - 1; i >= firstIdx; i--) {
  // if (array[i] == thirdValue) {
  // swap(array, thirdIdx, i);
  // thirdIdx--;
  // }
  // }

  // return array;
  // }

  public void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  // O(n) time | O(1) space - n is the length of the array
  // public int[] threeNumberSort(int[] array, int[] order) {
  // int[] counts = new int[3];
  // for (int i = 0; i < array.length; i++) {
  // int value = array[i];
  // if (value == order[0])
  // counts[0]++;
  // else if (value == order[1])
  // counts[1]++;
  // else
  // counts[2]++;
  // }

  // int idx = 0;
  // for (int i = 0; i < counts.length; i++) {
  // for (int j = 0; j < counts[i]; j++) {
  // array[idx] = order[i];
  // idx++;
  // }
  // }

  // return array;
  // }

}
