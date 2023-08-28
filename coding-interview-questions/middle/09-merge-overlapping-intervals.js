// O(nlogn) time | O(n) space - n is the total number of the array
function mergeOverlappingIntervals(array) {
  const intervals = [];
  array.sort((a, b) => a[0] - b[0]);

  let currentInterval = array[0];
  intervals.push(currentInterval);

  for (const interval of array) {
    [_, currentEnd] = currentInterval;
    [nextFirst, secondFirst] = interval;

    if (nextFirst <= currentEnd) {
      currentInterval[1] = Math.max(secondFirst, currentEnd);
    } else {
      currentInterval = interval;
      intervals.push(currentInterval);
    }
  }

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
