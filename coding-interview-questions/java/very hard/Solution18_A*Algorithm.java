import java.util.*;

class Program {
  // O(nlogn) time | O(n) space - n is the total number of the nodes in the
  // input graph.
  public int[][] aStarAlgorithm(
      int startRow, int startCol, int endRow, int endCol, int[][] graph) {
    List<List<Node>> nodes = initializeNodes(graph);
    Node startNode = nodes.get(startRow).get(startCol);
    Node endNode = nodes.get(endRow).get(endCol);

    startNode.distanceFromStart = 0;
    startNode.estimatedDistanceToEnd = calculateManhattanDistance(startNode, endNode);

    List<Node> nodesToVisitList = new ArrayList<>();
    nodesToVisitList.add(startNode);
    MinHeap nodesToVisit = new MinHeap(nodesToVisitList);

    while (!nodesToVisit.isEmpty()) {
      Node currentMinDistanceNode = nodesToVisit.remove();

      if (currentMinDistanceNode == endNode)
        break;

      List<Node> neighbours = getNeighbours(currentMinDistanceNode, nodes);
      for (Node neighbour : neighbours) {
        if (neighbour.value == 1)
          continue;

        int tentativeDistanceToNeighbour = currentMinDistanceNode.distanceFromStart + 1;
        if (tentativeDistanceToNeighbour >= neighbour.distanceFromStart)
          continue;

        neighbour.cameFrom = currentMinDistanceNode;
        neighbour.distanceFromStart = tentativeDistanceToNeighbour;
        neighbour.estimatedDistanceToEnd = tentativeDistanceToNeighbour
            + calculateManhattanDistance(neighbour, endNode);

        if (!nodesToVisit.containsNode(neighbour))
          nodesToVisit.insert(neighbour);
        else
          nodesToVisit.update(neighbour);
      }
    }
    return reconstructPath(endNode);
  }

  private List<List<Node>> initializeNodes(int[][] graph) {
    List<List<Node>> nodes = new ArrayList<>();
    for (int i = 0; i < graph.length; i++) {
      List<Node> nodeList = new ArrayList<>();
      nodes.add(nodeList);
      for (int j = 0; j < graph[i].length; j++) {
        nodes.get(i).add(new Node(i, j, graph[i][j]));
      }
    }

    return nodes;
  }

  private int calculateManhattanDistance(Node start, Node end) {
    int currentRow = start.row;
    int currentCol = start.col;
    int endRow = end.row;
    int endCol = end.col;

    return Math.abs(currentRow - endRow) + Math.abs(currentCol - endCol);
  }

  private List<Node> getNeighbours(Node node, List<List<Node>> nodes) {
    List<Node> neighbours = new ArrayList<>();
    int row = node.row;
    int col = node.col;

    if (row < nodes.size() - 1)
      neighbours.add(nodes.get(row + 1).get(col));

    if (row > 0)
      neighbours.add(nodes.get(row - 1).get(col));

    if (col < nodes.get(0).size() - 1)
      neighbours.add(nodes.get(row).get(col + 1));

    if (col > 0)
      neighbours.add(nodes.get(row).get(col - 1));

    return neighbours;
  }

  private int[][] reconstructPath(Node endNode) {
    if (endNode.cameFrom == null)
      return new int[][] {};

    Node currentNode = endNode;
    List<List<Integer>> pathList = new ArrayList<>();
    while (currentNode != null) {
      List<Integer> data = new ArrayList<>();
      data.add(currentNode.row);
      data.add(currentNode.col);
      pathList.add(data);
      currentNode = currentNode.cameFrom;
    }

    int[][] path = new int[pathList.size()][2];
    for (int i = 0; i < path.length; i++) {
      path[i][0] = pathList.get(path.length - 1 - i).get(0);
      path[i][1] = pathList.get(path.length - 1 - i).get(1);
    }

    return path;
  }

  class Node {
    protected String id;
    protected int row;
    protected int col;
    protected int value;
    protected int distanceFromStart;
    protected int estimatedDistanceToEnd;
    protected Node cameFrom;

    public Node(int row, int col, int value) {
      this.id = row + "-" + col;
      this.row = row;
      this.col = col;
      this.value = value;
      this.distanceFromStart = Integer.MAX_VALUE;
      this.estimatedDistanceToEnd = Integer.MAX_VALUE;
      this.cameFrom = null;
    }
  }

  class MinHeap {
    protected List<Node> heap = new ArrayList<>();
    protected Map<String, Integer> nodePositionsInHeap = new HashMap<>();

    public MinHeap(List<Node> array) {
      for (int i = 0; i < array.size(); i++) {
        Node node = array.get(i);
        nodePositionsInHeap.put(node.id, i);
      }

      heap = buildHeap(array);
    }

    public boolean containsNode(Node node) {
      return nodePositionsInHeap.containsKey(node.id);
    }

    public void update(Node node) {
      siftUp(nodePositionsInHeap.get(node.id));
    }

    public boolean isEmpty() {
      return heap.size() == 0;
    }

    public Node remove() {
      if (isEmpty())
        return null;

      swap(0, heap.size() - 1);
      Node node = heap.get(heap.size() - 1);
      heap.remove(heap.size() - 1);
      nodePositionsInHeap.remove(node.id);
      siftDown(0, heap.size() - 1, heap);
      return node;
    }

    public void insert(Node node) {
      heap.add(node);
      nodePositionsInHeap.put(node.id, heap.size() - 1);
      siftUp(heap.size() - 1);
    }

    private List<Node> buildHeap(List<Node> array) {
      int firstParentIdx = (array.size() / 2) - 1;
      for (int currentIdx = firstParentIdx + 1; currentIdx >= 0; currentIdx--) {
        siftDown(currentIdx, array.size() - 1, array);
      }

      return array;
    }

    private void siftDown(int currentIdx, int endIdx, List<Node> array) {
      int childOneIdx = currentIdx * 2 + 1;
      while (childOneIdx <= endIdx) {
        int possibleChildTwoIdx = currentIdx * 2 + 2;
        int childTwoIdx = possibleChildTwoIdx <= endIdx
            ? possibleChildTwoIdx
            : -1;

        int idxToSwap;
        if (childTwoIdx != -1
            && array.get(childTwoIdx).estimatedDistanceToEnd < heap.get(childOneIdx).estimatedDistanceToEnd)
          idxToSwap = childTwoIdx;
        else
          idxToSwap = childOneIdx;

        if (array.get(idxToSwap).estimatedDistanceToEnd < array.get(currentIdx).estimatedDistanceToEnd) {
          swap(currentIdx, idxToSwap);
          currentIdx = idxToSwap;
          childOneIdx = currentIdx * 2 + 1;
        } else
          return;
      }
    }

    private void siftUp(int currentIdx) {
      int parentIdx = (currentIdx - 1) / 2;
      while (currentIdx > 0
          && heap.get(currentIdx).estimatedDistanceToEnd < heap.get(parentIdx).estimatedDistanceToEnd) {
        swap(currentIdx, parentIdx);
        currentIdx = parentIdx;
        parentIdx = (currentIdx - 1) / 2;
      }
    }

    private void swap(int i, int j) {
      nodePositionsInHeap.put(heap.get(i).id, j);
      nodePositionsInHeap.put(heap.get(j).id, i);

      Node temp = heap.get(i);
      heap.set(i, heap.get(j));
      heap.set(j, temp);
    }

  }
}
