// O(n) time | O(n) space
function isMonotonic(array) {
  let isNonDecreasing = true;
  let isNonIncreasing = true;

  for (let i = 0; i < array.length - 1; i++) {
    if (array[i] > array[i + 1]) isNonDecreasing = false;
    if (array[i] < array[i + 1]) isNonIncreasing = false;
  }

  return isNonDecreasing || isNonIncreasing;
}

// function isMonotonic(array) {
//   let isDecreasing;
//   for (let i = 0; i < array.length - 1; i++) {
//     if (array[i] < array[i + 1]) {
//       if (isDecreasing === true) return false;
//       isDecreasing = false;
//     } else if (array[i] > array[i + 1]) {
//       if (isDecreasing === false) return false;
//       isDecreasing = true;
//     }
//   }

//   return true;
// }

console.log(isMonotonic([1, 5, 10, 1100, 1101, 1102, 9001]));
