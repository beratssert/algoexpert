// O(nlogn) time | O(1) space - n is the number of the jobs
function optimalFreelancing(jobs) {
  const lengthOfTheWeek = 7;
  let profit = 0;
  const timeline = new Array(lengthOfTheWeek).fill(false);
  jobs.sort((a, b) => b.payment - a.payment);

  for (const job of jobs) {
    const maxTime = Math.min(job.deadline, lengthOfTheWeek);
    for (let time = maxTime - 1; time >= 0; time--) {
      if (timeline[time] === false) {
        timeline[time] = true;
        profit += job.payment;
        break;
      }
    }
  }

  return profit;
}

console.log(
  optimalFreelancing([
    {
      deadline: 1,
      payment: 1,
    },
    {
      deadline: 2,
      payment: 1,
    },
    {
      deadline: 3,
      payment: 1,
    },
    {
      deadline: 4,
      payment: 1,
    },
    {
      deadline: 5,
      payment: 1,
    },
    {
      deadline: 6,
      payment: 1,
    },
    {
      deadline: 7,
      payment: 1,
    },
    {
      deadline: 8,
      payment: 1,
    },
    {
      deadline: 9,
      payment: 1,
    },
    {
      deadline: 10,
      payment: 1,
    },
  ])
);
