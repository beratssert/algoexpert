import java.util.*;

class Program {
  // O(n^2) time | O(n) space - n is the length of the stack
  public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
    if (stack.size() == 0)
      return stack;

    int top = stack.remove(stack.size() - 1);
    sortStack(stack);
    insertDecreasingly(stack, top);

    return stack;
  }

  public void insertDecreasingly(ArrayList<Integer> stack, int value) {
    if (stack.size() == 0 || value >= stack.get(stack.size() - 1)) {
      stack.add(value);
      return;
    }

    int top = stack.remove(stack.size() - 1);
    insertDecreasingly(stack, value);
    stack.add(top);
  }
}
