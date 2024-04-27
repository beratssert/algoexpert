import java.util.*;

class Program {
  // O(n) time | O(k) space - n is the number of the competitions, k is the number
  // of the teams.
  public String tournamentWinner(
      ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
    String winner = "";
    HashMap<String, Integer> scores = new HashMap<String, Integer>();
    scores.put(winner, 0);

    for (int i = 0; i < competitions.size(); i++) {
      ArrayList<String> competition = competitions.get(i);
      int result = results.get(i);

      String home = competition.get(0);
      String away = competition.get(1);

      String winnerSide = (result == 1) ? home : away;
      updateScore(winnerSide, scores);

      if (scores.get(winnerSide) > scores.get(winner)) {
        winner = winnerSide;
      }
    }

    return winner;
  }

  public void updateScore(String winnerSide, HashMap<String, Integer> scores) {
    if (!scores.containsKey(winnerSide)) {
      scores.put(winnerSide, 0);
    }

    scores.put(winnerSide, 3 + scores.get(winnerSide));
  }
}
