import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the length of the array.
  public int[] nextGreaterElement(int[] array) {
    Stack<Integer> indices = new Stack<>();

    int[] result = new int[array.length];
    Arrays.fill(result, -1);

    for (int i = 0; i < array.length * 2; i++) {
      int idx = i % array.length;
      int currentNum = array[idx];
      while (!indices.isEmpty() && currentNum > array[indices.peek()]) {
        int prevIdx = indices.pop();
        result[prevIdx] = currentNum;
      }

      indices.push(idx);
    }

    return result;
  }

  // O(n) time | O(n) space - n is the length of the array.
  // public int[] nextGreaterElement(int[] array) {
  // Stack<Integer> indices = new Stack<>();

  // int[] result = new int[array.length];
  // Arrays.fill(result, -1);

  // for (int i = array.length * 2 - 1; i >= 0; i--) {
  // int idx = i % array.length;
  // while (!indices.isEmpty()) {
  // if (indices.peek() <= array[idx]) {
  // indices.pop();
  // } else {
  // result[idx] = indices.peek();
  // break;
  // }
  // }

  // indices.push(array[idx]);
  // }

  // return result;
  // }
}
