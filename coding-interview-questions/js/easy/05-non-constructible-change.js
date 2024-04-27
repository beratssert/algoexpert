// O(nlog(n)) time | O(1) space - where n is the number of coins
function nonConstructibleChange(coins) {
  let minSum = 1;
  coins.sort((a, b) => a - b);
  for (let value of coins) {
    if (minSum < value) return minSum;
    minSum += value;
  }

  return minSum;
}

console.log(nonConstructibleChange([5, 7, 1, 1, 2, 3, 22]));
