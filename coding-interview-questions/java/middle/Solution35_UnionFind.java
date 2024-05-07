import java.util.*;

// Do not edit the class below except for
// the constructor and the createSet, find,
// and union methods. Feel free to add new
// properties and methods to the class.
class Program {
  static class UnionFind {
    private HashMap<Integer, Integer> parents = new HashMap<>();
    private HashMap<Integer, Integer> rank = new HashMap<>();

    // O(1) time | O(1) space
    public void createSet(int value) {
      parents.put(value, value);
      rank.put(value, 0);
    }

    // O(α(n)), approximately O(1) time | O(α(n)), approximately O(1) space - n is
    // the total number of the values
    public Integer find(int value) {
      if (!parents.containsKey(value))
        return null;

      int currentValue = value;
      if (currentValue != parents.get(currentValue))
        parents.put(currentValue, find(parents.get(currentValue)));

      return parents.get(currentValue);
    }

    // O(α(n)), approximately O(1) time | O(α(n)), approximately O(1) space - n is
    // the total number of the values
    public void union(int valueOne, int valueTwo) {
      if (!parents.containsKey(valueOne) || !parents.containsKey(valueTwo))
        return;

      int valueOneRoot = find(valueOne);
      int valueTwoRoot = find(valueTwo);
      if (rank.get(valueOneRoot) < rank.get(valueTwoRoot)) {
        parents.put(valueOneRoot, valueTwoRoot);
      } else if (rank.get(valueOneRoot) > rank.get(valueTwoRoot)) {
        parents.put(valueTwoRoot, valueOneRoot);
      } else {
        parents.put(valueTwoRoot, valueOneRoot);
        rank.put(valueOneRoot, rank.get(valueOneRoot) + 1);
      }
    }
  }
}

// class Program {
// static class UnionFind {
// private HashMap<Integer, Integer> parents = new HashMap<>();

// // O(1) time | O(1) space
// public void createSet(int value) {
// parents.put(value, value);
// }

// // O(n) time | O(1) space - n is the total number of the values
// public Integer find(int value) {
// if (!parents.containsKey(value))
// return null;

// int currentValue = value;
// while (currentValue != parents.get(currentValue)) {
// currentValue = parents.get(currentValue);
// }

// return currentValue;
// }

// // O(n) time | O(1) space - n is the total number of the values
// public void union(int valueOne, int valueTwo) {
// if (!parents.containsKey(valueOne) || !parents.containsKey(valueTwo))
// return;

// int valueOneRoot = find(valueOne);
// int valueTwoRoot = find(valueTwo);
// parents.put(valueOneRoot, valueTwoRoot);
// }
// }
// }

// class Program {
// static class UnionFind {
// private HashMap<Integer, Integer> parents = new HashMap<>();
// private HashMap<Integer, Integer> rank = new HashMap<>();

// // O(1) time | O(1) space
// public void createSet(int value) {
// parents.put(value, value);
// rank.put(value, 0);
// }

// // O(logn) time | O(1) space - n is the total number of the values
// public Integer find(int value) {
// if (!parents.containsKey(value))
// return null;

// int currentValue = value;
// while (currentValue != parents.get(currentValue)) {
// currentValue = parents.get(currentValue);
// }

// return currentValue;
// }

// // O(logn) time | O(1) space - n is the total number of the values
// public void union(int valueOne, int valueTwo) {
// if (!parents.containsKey(valueOne) || !parents.containsKey(valueTwo))
// return;

// int valueOneRoot = find(valueOne);
// int valueTwoRoot = find(valueTwo);
// if (rank.get(valueOneRoot) < rank.get(valueTwoRoot)) {
// parents.put(valueOneRoot, valueTwoRoot);
// } else if (rank.get(valueOneRoot) > rank.get(valueTwoRoot)) {
// parents.put(valueTwoRoot, valueOneRoot);
// } else {
// parents.put(valueTwoRoot, valueOneRoot);
// rank.put(valueOneRoot, rank.get(valueOneRoot) + 1);
// }
// }
// }
// }
