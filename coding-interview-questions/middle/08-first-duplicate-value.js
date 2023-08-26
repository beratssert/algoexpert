// O(n) time | O(1) space
function firstDuplicateValue(array) {
  for (let num of array) {
    let value = Math.abs(num);
    if (array[value - 1] < 0) return value;
    array[value - 1] *= -1;
  }

  return -1;
}

// O(nxm) time | O (m) space - n is the total number of the array, m is the total number of the storage.
// Worst - O(n^2) time | O(n) space
// function firstDuplicateValue(array) {
//   const storage = [];

//   for (let num of array) {
//     for (let i = storage.length - 1; i >= 0; i--) {
//       if (num === storage[i]) return num;
//     }

//     storage.push(num);
//   }

//   return -1;
// }

// O(n^2) time | O(1) space
// function firstDuplicateValue(array) {
//   let minSecondIndex = array.length;
//   for (let i = 0; i < array.length - 1; i++) {
//     for (let j = i + 1; j < array.length; j++) {
//       if (array[i] === array[j]) minSecondIndex = Math.min(minSecondIndex, j);
//     }
//   }

//   return minSecondIndex === array.length ? -1 : array[minSecondIndex];
// }

// O(n) time | O(n) space
// function firstDuplicateValue(array) {
//   const seen = new Set();
//   for (let num of array) {
//     if (seen.has(num)) return num;
//     seen.add(num);
//   }

//   return -1;
// }

console.log(firstDuplicateValue([2, 1, 5, 3, 3, 2, 4]));
