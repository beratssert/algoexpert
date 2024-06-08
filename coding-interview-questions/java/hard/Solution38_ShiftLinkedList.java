import java.util.*;

class Program {
  // O(n) time | O(1) space - n is the number of the nodes in the linked list.
  public static LinkedList shiftLinkedList(LinkedList head, int k) {
    int size = 1;
    LinkedList tail = head;
    while (tail.next != null) {
      size++;
      tail = tail.next;
    }

    int offset = Math.abs(k) % size;
    if (offset == 0)
      return head;

    offset = k < 0 ? offset : size - offset;

    LinkedList newTail = head;
    for (int i = 1; i < offset; i++) {
      newTail = newTail.next;
    }

    LinkedList newHead = newTail.next;
    newTail.next = null;
    tail.next = head;

    return newHead;
  }

  static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      next = null;
    }
  }
}
