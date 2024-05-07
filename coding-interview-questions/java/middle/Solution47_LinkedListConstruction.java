// Feel free to add new properties and methods to the class.
class Program {
  static class DoublyLinkedList {
    public Node head;
    public Node tail;

    // O(1) time | O(1) space
    public void setHead(Node node) {
      if (head == null) {
        head = node;
        tail = node;
        return;
      }
      insertBefore(head, node);
    }

    // O(1) time | O(1) space
    public void setTail(Node node) {
      if (tail == null)
        setHead(node);
      insertAfter(tail, node);
    }

    // O(1) time | O(1) space
    public void insertBefore(Node node, Node nodeToInsert) {
      if (nodeToInsert == head && nodeToInsert == tail)
        return;

      remove(nodeToInsert);
      if (node.prev == null) {
        head = nodeToInsert;
      } else {
        node.prev.next = nodeToInsert;
      }

      nodeToInsert.next = node;
      nodeToInsert.prev = node.prev;
      node.prev = nodeToInsert;
    }

    // O(1) time | O(1) space
    public void insertAfter(Node node, Node nodeToInsert) {
      if (nodeToInsert == head && nodeToInsert == tail)
        return;

      remove(nodeToInsert);
      if (node.next == null) {
        tail = nodeToInsert;
      } else {
        node.next.prev = nodeToInsert;
      }

      nodeToInsert.next = node.next;
      nodeToInsert.prev = node;
      node.next = nodeToInsert;
    }

    // O(p) time | O(1) space - p is the position
    public void insertAtPosition(int position, Node nodeToInsert) {
      if (position == 1) {
        setHead(nodeToInsert);
        return;
      }

      int currentPosition = 1;
      Node node = head;
      while (node != null && currentPosition != position) {
        node = node.next;
        currentPosition++;
      }

      if (node != null) {
        insertBefore(node, nodeToInsert);
      } else {
        setTail(nodeToInsert);
      }
    }

    // O(n) time | O(1) space - n is the number of the nodes.
    public void removeNodesWithValue(int value) {
      Node node = head;
      while (node != null) {
        Node nodeToRemove = node;
        node = node.next;
        if (nodeToRemove.value == value) {
          remove(nodeToRemove);
        }
      }
    }

    // O(1) time | O(1) space
    public void remove(Node node) {
      if (node == head)
        head = head.next;
      if (node == tail)
        tail = tail.prev;
      removeNodeBindings(node);
    }

    // O(n) time | O(1) space - n is the number of the nodes
    public boolean containsNodeWithValue(int value) {
      Node node = head;
      while (node != null) {
        if (node.value == value)
          return true;

        node = node.next;
      }

      return false;
    }

    /* Helper method */
    public void removeNodeBindings(Node node) {
      if (node.prev != null)
        node.prev.next = node.next;
      if (node.next != null)
        node.next.prev = node.prev;
      node.prev = null;
      node.next = null;
    }
  }

  // Do not edit the class below.
  static class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}
