import java.util.*;

class Program {
  // O(n^2) time | O(n^2) space - n is the number of the interns and teams.
  public int[][] stableInternships(int[][] interns, int[][] teams) {
    int[] internChoices = new int[interns.length];
    HashMap<Integer, Integer> chosenInterns = new HashMap<>();
    List<HashMap<Integer, Integer>> teamsPreference = new ArrayList<>();
    Stack<Integer> freeInterns = new Stack<>();
    for (int i = 0; i < interns.length; i++) {
      freeInterns.push(i);
    }

    for (int i = 0; i < teams.length; i++) {
      HashMap<Integer, Integer> rank = new HashMap<>();
      for (int j = 0; j < teams[i].length; j++) {
        rank.put(teams[i][j], j);
      }
      teamsPreference.add(rank);
    }

    while (!freeInterns.isEmpty()) {
      int intern = freeInterns.pop();
      int internPref = interns[intern][internChoices[intern]];
      internChoices[intern] += 1;

      if (!chosenInterns.containsKey(internPref)) {
        chosenInterns.put(internPref, intern);
        continue;
      }

      int prevIntern = chosenInterns.get(internPref);
      if (teamsPreference.get(internPref).get(intern) < teamsPreference.get(internPref).get(prevIntern)) {
        chosenInterns.put(internPref, intern);
        freeInterns.push(prevIntern);
      } else {
        freeInterns.push(intern);
      }
    }

    int[][] pairs = new int[interns.length][2];
    for (int i = 0; i < pairs.length; i++) {
      pairs[i][0] = chosenInterns.get(i);
      pairs[i][1] = i;
    }

    return pairs;
  }
}
