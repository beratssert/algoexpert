import java.util.*;

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

  // O(n) time | O(1) space - n is the number of nodes in the LinkedList.
  public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
    LinkedList head = linkedList;
    while (head != null) {
      LinkedList next = head.next;
      while (next != null && next.value == head.value) {
        next = next.next;
      }
      head.next = next;
      head = next;
    }
    return linkedList;
  }
}
