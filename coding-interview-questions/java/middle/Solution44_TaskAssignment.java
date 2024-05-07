import java.util.*;

class Program {
  // O(nlogn) time | O(n) space - n is the number of the tasks
  public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
    ArrayList<ArrayList<Integer>> assignments = new ArrayList<>();
    HashMap<Integer, ArrayList<Integer>> indices = new HashMap<>();

    for (int i = 0; i < tasks.size(); i++) {
      int taskDuration = tasks.get(i);
      ArrayList<Integer> indicesList = indices.containsKey(taskDuration) ? indices.get(taskDuration)
          : new ArrayList<>();
      indicesList.add(i);
      indices.put(taskDuration, indicesList);
    }

    Collections.sort(tasks);

    int start = 0;
    int end = tasks.size() - 1;
    while (start < end) {
      ArrayList<Integer> pair = new ArrayList<>();

      ArrayList<Integer> indicesList = indices.get(tasks.get(start));
      int idx1 = indicesList.remove(indicesList.size() - 1);

      indicesList = indices.get(tasks.get(end));
      int idx2 = indicesList.remove(indicesList.size() - 1);
      pair.add(idx1);
      pair.add(idx2);

      assignments.add(pair);
      start++;
      end--;
    }

    return assignments;
  }
}
