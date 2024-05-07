import java.util.*;

// Do not edit the class below except for the buildHeap,
// siftDown, siftUp, peek, remove, and insert methods.
// Feel free to add new properties and methods to the class.
class Program {
  static class MinHeap {
    List<Integer> heap = new ArrayList<Integer>();

    public MinHeap(List<Integer> array) {
      heap = buildHeap(array);
    }

    // O(n) time | O(1) space - n is the number of elements in the array.
    public List<Integer> buildHeap(List<Integer> array) {
      int lastParentIdx = (array.size() - 2) / 2;
      for (int i = lastParentIdx; i >= 0; i--) {
        siftDown(i, array.size() - 1, array);
      }

      return array;
    }

    // O(logn) time | O(1) space - n is the number of elements in the array.
    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
      int childOne = currentIdx * 2 + 1;
      while (childOne <= endIdx) {
        int childTwo = currentIdx * 2 + 2;
        int idxToSwap;
        if (childTwo <= endIdx && heap.get(childTwo) < heap.get(childOne)) {
          idxToSwap = childTwo;
        } else {
          idxToSwap = childOne;
        }

        if (heap.get(idxToSwap) < heap.get(currentIdx)) {
          swap(currentIdx, idxToSwap, heap);
          currentIdx = idxToSwap;
          childOne = currentIdx * 2 + 1;
        } else {
          return;
        }
      }
    }

    // O(logn) time | O(1) space - n is the number of elements in the array.
    public void siftUp(int currentIdx, List<Integer> heap) {
      int parentIdx = (currentIdx - 1) / 2;
      while (currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
        swap(currentIdx, parentIdx, heap);
        currentIdx = parentIdx;
        parentIdx = (currentIdx - 1) / 2;
      }
    }

    public int peek() {
      return heap.get(0);
    }

    public int remove() {
      swap(0, heap.size() - 1, heap);
      int removedElement = heap.remove(heap.size() - 1);
      siftDown(0, heap.size() - 1, heap);
      return removedElement;
    }

    public void insert(int value) {
      heap.add(value);
      siftUp(heap.size() - 1, heap);
    }

    public void swap(int i, int j, List<Integer> heap) {
      int temp = heap.get(i);
      heap.set(i, heap.get(j));
      heap.set(j, temp);
    }
  }
}
