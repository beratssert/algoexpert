import java.util.*;

class Program {
  // Feel free to add new properties and methods to the class.
  static class MinMaxStack {
    private ArrayList<Integer> stack = new ArrayList<>();
    private ArrayList<HashMap<String, Integer>> minMaxStack = new ArrayList<>();

    // O(1) time | O(1) space
    public int peek() {
      return stack.get(stack.size() - 1);
    }

    // O(1) time | O(1) space
    public int pop() {
      minMaxStack.remove(minMaxStack.size() - 1);
      return stack.remove(stack.size() - 1);
    }

    // O(1) time | O(1) space
    public void push(Integer number) {
      HashMap<String, Integer> newMinMax = new HashMap<>();
      newMinMax.put("min", number);
      newMinMax.put("max", number);
      if (!minMaxStack.isEmpty()) {
        HashMap<String, Integer> lastMinMax = minMaxStack.get(minMaxStack.size() - 1);
        newMinMax.put("min", Math.min(lastMinMax.get("min"), newMinMax.get("min")));
        newMinMax.put("max", Math.max(lastMinMax.get("max"), newMinMax.get("max")));
      }

      minMaxStack.add(newMinMax);
      stack.add(number);
    }

    // O(1) time | O(1) space
    public int getMin() {
      return minMaxStack.get(minMaxStack.size() - 1).get("min");
    }

    // O(1) time | O(1) space
    public int getMax() {
      return minMaxStack.get(minMaxStack.size() - 1).get("max");
    }
  }
}
