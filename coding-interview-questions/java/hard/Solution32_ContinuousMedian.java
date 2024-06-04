import java.util.*;
import java.util.function.BiFunction;

// Do not edit the class below except for
// the insert method. Feel free to add new
// properties and methods to the class.
class Program {
  // O(logn) time | O(n) space - n is the all numbers inserted.
  static class ContinuousMedianHandler {
    double median = 0;
    private Heap greaters = new Heap(Heap::MIN_HEAP_FUNCTION, new ArrayList<>());
    private Heap lowers = new Heap(Heap::MAX_HEAP_FUNCTION, new ArrayList<>());

    public void insert(int number) {
      if (lowers.length == 0 || number < lowers.peek())
        lowers.insert(number);
      else
        greaters.insert(number);

      balanceHeap();
      updateMedian();
    }

    private void balanceHeap() {
      if (lowers.length - greaters.length == 2)
        greaters.insert(lowers.remove());
      else if (greaters.length - lowers.length == 2)
        lowers.insert(greaters.remove());
    }

    private void updateMedian() {
      if (lowers.length == greaters.length)
        median = (lowers.peek() + greaters.peek()) / 2.0;
      else if (lowers.length < greaters.length)
        median = greaters.peek();
      else
        median = lowers.peek();
    }

    public double getMedian() {
      return median;
    }

    static class Heap {
      List<Integer> heap = new ArrayList<Integer>();
      BiFunction<Integer, Integer, Boolean> comparisonFunc;
      int length;

      public Heap(BiFunction<Integer, Integer, Boolean> func, List<Integer> array) {
        heap = buildHeap(array);
        comparisonFunc = func;
        length = heap.size();
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
          if (childTwo <= endIdx && comparisonFunc.apply(heap.get(childTwo), heap.get(childOne))) {
            idxToSwap = childTwo;
          } else {
            idxToSwap = childOne;
          }

          if (comparisonFunc.apply(heap.get(idxToSwap), heap.get(currentIdx))) {
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
        while (currentIdx > 0 && comparisonFunc.apply(heap.get(currentIdx), heap.get(parentIdx))) {
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
        length--;
        return removedElement;
      }

      public void insert(int value) {
        heap.add(value);
        siftUp(heap.size() - 1, heap);
        length++;
      }

      public void swap(int i, int j, List<Integer> heap) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
      }

      public static boolean MAX_HEAP_FUNCTION(int a, int b) {
        return a > b;
      }

      public static boolean MIN_HEAP_FUNCTION(int a, int b) {
        return a < b;
      }
    }
  }

  // O(n) time | O(n) space - n is the all numbers inserted.
  // static class ContinuousMedianHandler {
  // double median = 0;
  // private int medianIdx = -1;
  // private List<Double> list = new ArrayList<>();

  // public void insert(int number) {
  // int idx = list.size();
  // for (int i = 0; i < list.size(); i++) {
  // if (list.get(i) > number) {
  // idx = i;
  // break;
  // }
  // }

  // list.add(idx, (double) number);

  // if (list.size() % 2 == 1) {
  // medianIdx++;
  // median = list.get(medianIdx);
  // } else {
  // median = (list.get(medianIdx) + list.get(medianIdx + 1)) / 2;
  // }
  // }

  // public double getMedian() {
  // return median;
  // }
  // }
}
