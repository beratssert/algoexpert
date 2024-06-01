import java.util.*;

class Program {
  // O(e * loge) time | O(v + e) space - e is the number of the edges, and v is
  // the number of the vertices
  public int[][][] primsAlgorithm(int[][][] edges) {
    List<Edge> edgeList = new ArrayList<>();
    for (int[] sibling : edges[0]) {
      Edge edge = new Edge(0, sibling[0], sibling[1]);
      edgeList.add(edge);
    }

    Queue<Edge> queue = new PriorityQueue<>(edgeList);

    List<List<int[]>> mstList = new ArrayList<>();
    for (int i = 0; i < edges.length; i++) {
      mstList.add(i, new ArrayList<>());
    }

    while (!queue.isEmpty()) {
      Edge edge = queue.poll();

      if (mstList.get(edge.destination).isEmpty()) {
        mstList.get(edge.destination).add(new int[] { edge.current, edge.distance });
        mstList.get(edge.current).add(new int[] { edge.destination, edge.distance });

        for (int[] sibling : edges[edge.destination]) {
          if (mstList.get(sibling[0]).isEmpty()) {
            Edge newEdge = new Edge(edge.destination, sibling[0], sibling[1]);
            queue.offer(newEdge);
          }
        }
      }
    }

    int[][][] result = new int[edges.length][][];
    for (int i = 0; i < edges.length; i++) {
      result[i] = new int[mstList.get(i).size()][];
      for (int j = 0; j < result[i].length; j++) {
        result[i][j] = mstList.get(i).get(j);
      }
    }

    return result;
  }

  class Edge implements Comparable<Edge> {
    int current;
    int destination;
    int distance;

    public Edge(int current, int destination, int distance) {
      this.current = current;
      this.destination = destination;
      this.distance = distance;
    }

    @Override
    public int compareTo(Edge o) {
      if (distance > o.distance)
        return 1;
      else if (distance < o.distance)
        return -1;
      return 0;
    }
  }

  // O(e * loge) time | O(v + e) space - e is the number of the edges, and v is
  // the number of the vertices
  // public int[][][] primsAlgorithm(int[][][] edges) {
  // List<Edge> edgeList = new ArrayList<>();
  // for (int[] sibling : edges[0]) {
  // Edge edge = new Edge(0, sibling[0], sibling[1]);
  // edgeList.add(edge);
  // }

  // MinHeap heap = new MinHeap(edgeList);

  // List<List<int[]>> mstList = new ArrayList<>();
  // for (int i = 0; i < edges.length; i++) {
  // mstList.add(i, new ArrayList<>());
  // }

  // while (!heap.isEmpty()) {
  // Edge edge = heap.remove();

  // if (mstList.get(edge.destination).isEmpty()) {
  // mstList.get(edge.destination).add(new int[] { edge.current, edge.distance });
  // mstList.get(edge.current).add(new int[] { edge.destination, edge.distance });

  // for (int[] sibling : edges[edge.destination]) {
  // if (mstList.get(sibling[0]).isEmpty()) {
  // Edge newEdge = new Edge(edge.destination, sibling[0], sibling[1]);
  // heap.insert(newEdge);
  // }
  // }
  // }
  // }

  // int[][][] result = new int[edges.length][][];
  // for (int i = 0; i < edges.length; i++) {
  // result[i] = new int[mstList.get(i).size()][];
  // for (int j = 0; j < result[i].length; j++) {
  // result[i][j] = mstList.get(i).get(j);
  // }
  // }

  // return result;
  // }

  // class MinHeap {
  // List<Edge> heap = new ArrayList<>();

  // public MinHeap(List<Edge> array) {
  // heap = buildHeap(array);
  // }

  // public boolean isEmpty() {
  // return heap.size() == 0;
  // }

  // // O(n) time | O(1) space - n is the number of elements in the array.
  // public List<Edge> buildHeap(List<Edge> array) {
  // int lastParentIdx = (array.size() - 2) / 2;
  // for (int i = lastParentIdx; i >= 0; i--) {
  // siftDown(i, array.size() - 1, array);
  // }

  // return array;
  // }

  // // O(logn) time | O(1) space - n is the number of elements in the array.
  // public void siftDown(int currentIdx, int endIdx, List<Edge> heap) {
  // int childOne = currentIdx * 2 + 1;
  // while (childOne <= endIdx) {
  // int childTwo = currentIdx * 2 + 2;
  // int idxToSwap;
  // if (childTwo <= endIdx && heap.get(childTwo).distance <
  // heap.get(childOne).distance) {
  // idxToSwap = childTwo;
  // } else {
  // idxToSwap = childOne;
  // }

  // if (heap.get(idxToSwap).distance < heap.get(currentIdx).distance) {
  // swap(currentIdx, idxToSwap, heap);
  // currentIdx = idxToSwap;
  // childOne = currentIdx * 2 + 1;
  // } else {
  // return;
  // }
  // }
  // }

  // // O(logn) time | O(1) space - n is the number of elements in the array.
  // public void siftUp(int currentIdx, List<Edge> heap) {
  // int parentIdx = (currentIdx - 1) / 2;
  // while (currentIdx > 0 && heap.get(currentIdx).distance <
  // heap.get(parentIdx).distance) {
  // swap(currentIdx, parentIdx, heap);
  // currentIdx = parentIdx;
  // parentIdx = (currentIdx - 1) / 2;
  // }
  // }

  // public Edge remove() {
  // swap(0, heap.size() - 1, heap);
  // Edge removedElement = heap.remove(heap.size() - 1);
  // siftDown(0, heap.size() - 1, heap);
  // return removedElement;
  // }

  // public void insert(Edge edge) {
  // heap.add(edge);
  // siftUp(heap.size() - 1, heap);
  // }

  // public void swap(int i, int j, List<Edge> heap) {
  // Edge temp = heap.get(i);
  // heap.set(i, heap.get(j));
  // heap.set(j, temp);
  // }
  // }

  // class Edge {
  // int current;
  // int destination;
  // int distance;

  // public Edge(int current, int destination, int distance) {
  // this.current = current;
  // this.destination = destination;
  // this.distance = distance;
  // }
  // }
}