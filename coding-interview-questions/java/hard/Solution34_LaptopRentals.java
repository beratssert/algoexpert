import java.util.*;

class Program {
  // O(nlogn) time | O(n) space - n is the length of the times
  public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
    int[] startTimes = new int[times.size()];
    int[] endTimes = new int[times.size()];
    for (int i = 0; i < endTimes.length; i++) {
      ArrayList<Integer> interval = times.get(i);
      startTimes[i] = interval.get(0);
      endTimes[i] = interval.get(1);
    }

    Arrays.sort(startTimes);
    Arrays.sort(endTimes);

    int start = 0;
    int end = 0;
    int usedLaptops = 0;
    while (start < startTimes.length) {
      if (startTimes[start] >= endTimes[end]) {
        usedLaptops--;
        end++;
      }

      usedLaptops++;
      start++;
    }

    return usedLaptops;
  }

  // O(nlogn) time | O(n) space - n is the length of the times
  // public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
  // if (times.isEmpty())
  // return 0;

  // times.sort((a, b) -> a.get(0) - b.get(0));
  // ArrayList<Integer> list = new
  // ArrayList<>(Arrays.asList(times.get(0).get(1)));
  // MinHeap heap = new MinHeap(list);

  // for (int i = 1; i < times.size(); i++) {
  // ArrayList<Integer> interval = times.get(i);
  // if (interval.get(0) >= heap.peek()) {
  // heap.remove();
  // }

  // heap.insert(interval.get(1));
  // }

  // return heap.size();
  // }

  // static class MinHeap {
  // List<Integer> heap = new ArrayList<Integer>();

  // public MinHeap(List<Integer> array) {
  // heap = buildHeap(array);
  // }

  // // O(n) time | O(1) space - n is the number of elements in the array.
  // private List<Integer> buildHeap(List<Integer> array) {
  // int lastParentIdx = (array.size() - 2) / 2;
  // for (int i = lastParentIdx; i >= 0; i--) {
  // siftDown(i, array.size() - 1, array);
  // }

  // return array;
  // }

  // // O(logn) time | O(1) space - n is the number of elements in the array.
  // private void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
  // int childOne = currentIdx * 2 + 1;
  // while (childOne <= endIdx) {
  // int childTwo = currentIdx * 2 + 2;
  // int idxToSwap;
  // if (childTwo <= endIdx && heap.get(childTwo) < heap.get(childOne)) {
  // idxToSwap = childTwo;
  // } else {
  // idxToSwap = childOne;
  // }

  // if (heap.get(idxToSwap) < heap.get(currentIdx)) {
  // swap(currentIdx, idxToSwap, heap);
  // currentIdx = idxToSwap;
  // childOne = currentIdx * 2 + 1;
  // } else {
  // return;
  // }
  // }
  // }

  // // O(logn) time | O(1) space - n is the number of elements in the array.
  // private void siftUp(int currentIdx, List<Integer> heap) {
  // int parentIdx = (currentIdx - 1) / 2;
  // while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
  // swap(currentIdx, parentIdx, heap);
  // currentIdx = parentIdx;
  // parentIdx = (currentIdx - 1) / 2;
  // }
  // }

  // public int peek() {
  // return heap.get(0);
  // }

  // public int size() {
  // return heap.size();
  // }

  // public int remove() {
  // swap(0, heap.size() - 1, heap);
  // int removedElement = heap.remove(heap.size() - 1);
  // siftDown(0, heap.size() - 1, heap);
  // return removedElement;
  // }

  // public void insert(int value) {
  // heap.add(value);
  // siftUp(heap.size() - 1, heap);
  // }

  // private void swap(int i, int j, List<Integer> heap) {
  // int temp = heap.get(i);
  // heap.set(i, heap.get(j));
  // heap.set(j, temp);
  // }
  // }
}
