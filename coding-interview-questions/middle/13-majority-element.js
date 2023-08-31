// O(n) time | O(1) space - n is the total number of the array.
function majorityElement(array) {
  let majorityNum = null;
  let count = 0;

  for (const num of array) {
    if (count === 0) majorityNum = num;

    if (num === majorityNum) {
      count++;
    } else {
      count--;
    }
  }

  return majorityNum;
}

console.log(majorityElement([2, 2, 1, 1, 1]));
