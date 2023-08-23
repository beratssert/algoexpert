// O(n) time | O(n) space
function twoNumberSum(array, targetSum) {
  const difference = {};

  for (let num of array) {
    const diff = targetSum - num;
    if (difference[num]) return [num, diff];
    difference[diff] = true;
  }

  return [];
}

console.log(twoNumberSum([3, 5, -4, 8, 11, 1, -1, 6], 10));
