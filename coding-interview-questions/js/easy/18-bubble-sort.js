// Avarege and worst: O(n^2) time | O(1) space - n is the length of the input
// Best: if input is sorted - O(n) time | O(1) space
function bubbleSort(array) {
  let condition = true;
  let counter = 0;
  while (condition) {
    condition = false;
    for (let i = 0; i < array.length - 1 - counter; i++) {
      if (array[i] > array[i + 1]) {
        swap(array, i);
        condition = true;
      }
    }

    counter++;
  }

  return array;
}

function swap(array, idx) {
  const valueStorage = array[idx];
  array[idx] = array[idx + 1];
  array[idx + 1] = valueStorage;
}

console.log(bubbleSort([8, 5, 2, 9, 5, 6, 3]));
