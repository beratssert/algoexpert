class Program {
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  // O(n) time | O(1) space - n is the number of nodes.
  public LinkedList middleNode(LinkedList linkedList) {
    LinkedList slowNode = linkedList;
    LinkedList fastNode = linkedList;
    while (fastNode != null && fastNode.next != null) {
      slowNode = slowNode.next;
      fastNode = fastNode.next.next;
    }

    return slowNode;
  }

  // O(n) time | O(1) space - n is the number of the nodes.
  // public LinkedList middleNode(LinkedList linkedList) {
  // int size = 1;
  // LinkedList node = linkedList;
  // while (node.next != null) {
  // size++;
  // node = node.next;
  // }

  // node = linkedList;
  // for (int i = 0; i < size / 2; i++) {
  // node = node.next;
  // }

  // return node;
  // }
}
