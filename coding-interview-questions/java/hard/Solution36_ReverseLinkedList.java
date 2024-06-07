import java.util.*;

class Program {
  // O(n) time | O(1) space - n is the number of the nodes in the linked list.
  public static LinkedList reverseLinkedList(LinkedList head) {
    LinkedList prevNode = null;
    LinkedList currentNode = head;
    while (currentNode != null) {
      LinkedList nextNode = currentNode.next;
      currentNode.next = prevNode;
      prevNode = currentNode;
      currentNode = nextNode;
    }

    return prevNode;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
