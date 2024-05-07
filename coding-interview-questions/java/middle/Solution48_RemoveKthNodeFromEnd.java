class Program {
  // O(n) time | O(1) space - n is the number of the nodes
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
    LinkedList first = head;
    LinkedList second = head;
    for (int i = 0; i < k; i++) {
      second = second.next;
    }

    if (second == null) {
      head.value = head.next.value;
      head.next = head.next.next;
      return;
    }

    while (second.next != null) {
      first = first.next;
      second = second.next;
    }

    first.next = first.next.next;
  }

  // O(n) time | O(1) space - n is the number of the nodes
  // public static void removeKthNodeFromEnd(LinkedList head, int k) {
  // int nodeIdxToChangeBindes = size(head) - k;

  // if (nodeIdxToChangeBindes == 0) {
  // head.value = head.next.value;
  // head.next = head.next.next;
  // return;
  // }

  // LinkedList node = head;
  // for (int i = 1; i < nodeIdxToChangeBindes; i++) {
  // node = node.next;
  // }

  // node.next = node.next.next;
  // }

  // public static int size(LinkedList head) {
  // LinkedList node = head;
  // int size = 0;
  // while (node != null) {
  // size++;
  // node = node.next;
  // }

  // return size;
  // }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
