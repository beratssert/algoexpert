class Program {
  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }

    // Average: O(logn) time | O(1) space
    // Worst: O(n) time | O(1) space - n is the number of the nodes
    public BST insert(int value) {
      BST node = this;
      while (true) {
        if (value >= node.value) {
          if (node.right == null) {
            BST newNode = new BST(value);
            node.right = newNode;
            break;
          } else {
            node = node.right;
          }
        } else {
          if (node.left == null) {
            node.left = new BST(value);
            break;
          } else {
            node = node.left;
          }
        }
      }

      return this;
    }

    // Average: O(logn) time | O(1) space
    // Worst: O(n) time | O(1) space - n is the number of the nodes
    public boolean contains(int value) {
      BST node = this;
      while (node != null) {
        if (node.value == value)
          return true;
        if (value > node.value) {
          node = node.right;
        } else {
          node = node.left;
        }
      }
      return false;
    }

    // Average: O(logn) time | O(1) space
    // Worst: O(n) time | O(1) space - n is the number of the nodes
    public BST remove(int value) {
      remove(value, null);
      return this;
    }

    public void remove(int value, BST parentNode) {
      BST node = this;
      while (node != null) {
        if (value > node.value) {
          parentNode = node;
          node = node.right;
        } else if (value < node.value) {
          parentNode = node;
          node = node.left;
        } else {
          if (node.left != null && node.right != null) {
            node.value = node.right.getMinValue();
            node.right.remove(node.value, node);
          } else if (parentNode == null) {
            if (node.left != null) {
              node.value = node.left.value;
              node.right = node.left.right;
              node.left = node.left.left;
            } else if (node.right != null) {
              node.value = node.right.value;
              node.left = node.right.left;
              node.right = node.right.right;
            } else {
              // one node
            }
          } else if (node == parentNode.left) {
            parentNode.left = node.left != null ? node.left : node.right;
          } else if (node == parentNode.right) {
            parentNode.right = node.left != null ? node.left : node.right;
          }

          break;
        }
      }
    }

    public int getMinValue() {
      BST node = this;
      while (node.left != null) {
        node = node.left;
      }

      return node.value;
    }
  }
}
