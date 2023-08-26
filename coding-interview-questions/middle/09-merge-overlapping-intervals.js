// O(nlogn) time | O(n) space - n is the total number of the array
function mergeOverlappingIntervals(array) {
  const intervals = [];
  array.sort((a, b) => a[0] - b[0]);

  let firstInterval = array[0][0];
  let secondInterval = array[0][1];
  for (let i = 0; i < array.length - 1; i++) {
    let nextFirst = array[i + 1][0];
    let nextSecond = array[i + 1][1];

    if (nextFirst <= secondInterval) {
      secondInterval = Math.max(secondInterval, nextSecond);
    } else {
      intervals.push([firstInterval, secondInterval]);
      firstInterval = nextFirst;
      secondInterval = nextSecond;
    }
  }

  intervals.push([firstInterval, secondInterval]);
  return intervals;
}

console.log(
  mergeOverlappingIntervals([
    [1, 2],
    [3, 5],
    [4, 7],
    [6, 8],
    [9, 10],
  ])
);
