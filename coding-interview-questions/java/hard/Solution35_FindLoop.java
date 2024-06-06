import java.util.*;

class Program {
  // O(n) time | O(1) space - n is the number of the nodes in the linked list.
  public static LinkedList findLoop(LinkedList head) {
    LinkedList first = head.next;
    LinkedList second = head.next.next;
    while (first != second) {
      first = first.next;
      second = second.next.next;
    }

    first = head;
    while (first != second) {
      first = first.next;
      second = second.next;
    }

    return first;
  }

  // O(n) time | O(n) space - n is the number of the nodes in the linked list.
  // public static LinkedList findLoop(LinkedList head) {
  // HashSet<LinkedList> visited = new HashSet<>();
  // LinkedList node = head;
  // while (!visited.contains(node)) {
  // visited.add(node);
  // node = node.next;
  // }

  // return node;
  // }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
