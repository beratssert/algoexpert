// O(n) time | O(d) space - where n is the total numbers in the input,
//                        - d is the greatest depth of the input
function productSum(array, depth = 1) {
  let sum = 0;
  for (let value of array) {
    if (Array.isArray(value)) {
      sum += depth * productSum(value, depth + 1);
    } else {
      sum += depth * value;
    }
  }

  return sum;
}

console.log(productSum([5, 2, [7, -1], 3, [6, [-13, 8], 4]]));
