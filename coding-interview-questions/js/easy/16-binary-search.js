function binarySearch(array, target) {
  let lowestIdx = 0;
  let highestIdx = array.length - 1;
  while (lowestIdx <= highestIdx) {
    const midIdx = Math.floor((lowestIdx + highestIdx) / 2);
    const value = array[midIdx];
    if (value === target) return midIdx;
    if (value > target) {
      highestIdx = midIdx - 1;
    } else {
      lowestIdx = midIdx + 1;
    }
  }

  return -1;
}

console.log(binarySearch([0, 1, 21, 33, 45, 45, 61, 71, 72, 73], 33));
