import java.util.*;

class Program {
  // O(n*n!) time | O(n*n!) space - n is the length of the aaray.
  public static List<List<Integer>> getPermutations(List<Integer> array) {
    List<List<Integer>> permutations = new ArrayList<>();
    getPermutations(0, array, permutations);
    return permutations;
  }

  public static void getPermutations(int i, List<Integer> array, List<List<Integer>> permutations) {
    if (i == array.size() - 1) {
      permutations.add(new ArrayList<>(array));
    } else {
      for (int j = i; j < array.size(); j++) {
        swap(i, j, array);
        getPermutations(i + 1, array, permutations);
        swap(i, j, array);
      }
    }
  }

  public static void swap(int i, int j, List<Integer> array) {
    int temp = array.get(i);
    array.set(i, array.get(j));
    array.set(j, temp);
  }

  // Upper bound: O(n^2*n!) time | O(n*n!) space - n is the length of the array.
  // Roughly : O(n*n!) time | O(n*n!) space - n is the length of the array.
  // public static List<List<Integer>> getPermutations(List<Integer> array) {
  // ArrayList<List<Integer>> permutations = new ArrayList<>();
  // getPermutations(array, new ArrayList<Integer>(), permutations);
  // return permutations;
  // }

  // public static void getPermutations(List<Integer> array, List<Integer>
  // currentPermutation,
  // ArrayList<List<Integer>> permutations) {

  // if (array.size() == 0 && currentPermutation.size() > 0) {
  // permutations.add(currentPermutation);
  // } else {
  // for (int i = 0; i < array.size(); i++) {
  // List<Integer> newArr = new ArrayList<>();
  // for (int j = 0; j < array.size(); j++) {
  // if (i == j)
  // continue;

  // newArr.add(array.get(j));
  // }

  // List<Integer> newPermutation = new ArrayList<>(currentPermutation);
  // newPermutation.add(array.get(i));
  // getPermutations(newArr, newPermutation, permutations);
  // }
  // }
  // }
}
