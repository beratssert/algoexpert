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

  // O(max(n, m)) time | O(max(n, m)) space - n and m is the lengths of the linked
  // lists.
  public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
    LinkedList head = new LinkedList(0);
    LinkedList currentNode = head;

    LinkedList node1 = linkedListOne;
    LinkedList node2 = linkedListTwo;
    int carry = 0;
    while (node1 != null || node2 != null || carry != 0) {
      int value1 = node1 == null ? 0 : node1.value;
      int value2 = node2 == null ? 0 : node2.value;
      int sum = value1 + value2 + carry;

      LinkedList newNode = new LinkedList(sum % 10);
      currentNode.next = newNode;
      currentNode = newNode;

      carry = sum / 10;

      if (node1 != null)
        node1 = node1.next;

      if (node2 != null)
        node2 = node2.next;

    }

    return head.next;
  }
}
