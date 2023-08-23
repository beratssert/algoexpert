// O(n^2) time | O(n) space - n is the length of the input array
function threeNumberSum(array, targetSum) {
  const triplets = [];
  array.sort((a, b) => a - b);

  for (let i = 0; i < array.length - 2; i++) {
    let leftPointer = i + 1;
    let rightPointer = array.length - 1;

    while (leftPointer < rightPointer) {
      const currentSum = array[i] + array[leftPointer] + array[rightPointer];
      if (currentSum === targetSum) {
        triplets.push([array[i], array[leftPointer], array[rightPointer]]);
        leftPointer++;
        rightPointer--;
      } else if (currentSum < targetSum) {
        leftPointer++;
      } else if (currentSum > targetSum) {
        rightPointer--;
      }
    }
  }

  return triplets;
}

console.log(threeNumberSum([12, 3, 1, 2, -6, 5, -8, 6], 0));
