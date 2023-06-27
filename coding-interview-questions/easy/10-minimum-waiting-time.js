// O(nlogn) time | O(1) space - where n is the number of the queries
function minimumWaitingTime(queries) {
  queries.sort((a, b) => a - b);
  let waitingTime = 0;
  for (let i = 0; i < queries.length; i++) {
    const duration = queries[i];
    const queriesLeft = queries.length - (i + 1);
    waitingTime += duration * queriesLeft;
  }

  return waitingTime;
}

// function minimumWaitingTime(queries) {
//   queries.sort((a, b) => a - b);
//   let waitingTime = 0;
//   let totalWaitingTimes = 0;
//   for (let i = 1; i < queries.length; i++) {
//     waitingTime += queries[i - 1];
//     totalWaitingTimes += waitingTime;
//   }

//   return totalWaitingTimes;
// }

console.log(minimumWaitingTime([3, 2, 1, 2, 6]));
