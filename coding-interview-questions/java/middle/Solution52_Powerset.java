import java.util.*;

class Program {
  // O(n*2^n) time | O(n*2^n) space - n is the length of the array.
  public static List<List<Integer>> powerset(List<Integer> array) {
    List<List<Integer>> subsets = new ArrayList<>();
    subsets.add(new ArrayList<>());

    for (Integer num : array) {
      int size = subsets.size();
      for (int i = 0; i < size; i++) {
        List<Integer> currentSubset = subsets.get(i);
        List<Integer> newSubset = new ArrayList<>(currentSubset);
        newSubset.add(num);
        subsets.add(newSubset);
      }
    }

    return subsets;
  }

  // O(n*2^n) time | O(n*2^n) space - n is the length of the array.
  // public static List<List<Integer>> powerset(List<Integer> array) {
  // List<List<Integer>> subsets = powerset(array, array.size() - 1);
  // return subsets;
  // }

  // public static List<List<Integer>> powerset(List<Integer> array, int idx) {
  // if (idx < 0) {
  // List<List<Integer>> subsets = new ArrayList<>();
  // subsets.add(new ArrayList<>());
  // return subsets;
  // }

  // Integer num = array.get(idx);
  // List<List<Integer>> subsets = powerset(array, idx - 1);

  // int size = subsets.size();
  // for (int i = 0; i < size; i++) {
  // List<Integer> newSubset = new ArrayList<>(subsets.get(i));
  // newSubset.add(num);
  // subsets.add(newSubset);
  // }

  // return subsets;
  // }
}
