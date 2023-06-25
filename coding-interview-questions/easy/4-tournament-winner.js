// O(n) time | O(k) space - where n is the number of competitions and k is the number of teams
function tournamentWinner(competitions, results) {
  let champion = "";
  const scores = { [champion]: 0 };

  for (let i = 0; i < results.length; i++) {
    const result = results[i];
    const [homeTeam, awayTeam] = competitions[i];
    const winner = result === 1 ? homeTeam : awayTeam;
    updateScore(winner, scores);
    if (scores[winner] > scores[champion]) champion = winner;
  }

  return champion;
}

function updateScore(winner, scores) {
  if (!scores[winner]) scores[winner] = 0;
  scores[winner] += 3;
}

console.log(
  tournamentWinner(
    [
      ["HTML", "C#"],
      ["C#", "Python"],
      ["Python", "HTML"],
    ],
    [0, 0, 1]
  )
);
