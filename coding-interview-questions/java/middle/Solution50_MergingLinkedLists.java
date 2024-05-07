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

  // O(n + m) time | O(1) space - n and m are the lengths of the linked lists.
  public LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
    int size1 = size(linkedListOne);
    int size2 = size(linkedListTwo);

    int difference = Math.abs(size2 - size1);
    LinkedList bigger = size1 > size2 ? linkedListOne : linkedListTwo;
    LinkedList smaller = size1 <= size2 ? linkedListOne : linkedListTwo;

    for (int i = 0; i < difference; i++) {
      bigger = bigger.next;
    }

    while (bigger != smaller) {
      bigger = bigger.next;
      smaller = smaller.next;
    }

    return bigger;
  }

  public int size(LinkedList node) {
    int size = 0;

    LinkedList head = node;
    while (head != null) {
      size++;
      head = head.next;
    }

    return size;
  }

  // O(n + m) time | O(1) space - n and m are the lengths of the linked lists.
  // public LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList
  // linkedListTwo) {
  // LinkedList node1 = linkedListOne;
  // LinkedList node2 = linkedListTwo;
  // while (node1 != node2) {
  // if (node1 == null) {
  // node1 = linkedListTwo;
  // } else {
  // node1 = node1.next;
  // }

  // if (node2 == null) {
  // node2 = linkedListOne;
  // } else {
  // node2 = node2.next;
  // }
  // }

  // return node1;
  // }

  // O(n + m) time | O(n) space - n is the linkedListOne's length, and m is the
  // other linkedListTwo's length
  // public LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList
  // linkedListTwo) {
  // HashSet<LinkedList> storage = new HashSet<>();

  // LinkedList node1 = linkedListOne;
  // while (node1 != null) {
  // storage.add(node1);
  // node1 = node1.next;
  // }

  // LinkedList node2 = linkedListTwo;
  // while (node2 != null) {
  // if (storage.contains(node2))
  // return node2;

  // node2 = node2.next;
  // }

  // return null;
  // }

  // O(n*m) time | O(1) space - n, and m are the lenghts of the linked lists
  // public LinkedList mergingLinkedLists(LinkedList linkedListOne, LinkedList
  // linkedListTwo) {
  // LinkedList node1 = linkedListOne;
  // while (node1 != null) {
  // LinkedList node2 = linkedListTwo;
  // while (node2 != null) {
  // if (node1 == node2)
  // return node1;

  // node2 = node2.next;
  // }

  // node1 = node1.next;
  // }

  // return null;
  // }
}
