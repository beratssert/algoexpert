// Average and worst scenerio, O(n^2) time | O(1) space - n is the length of the input
// Best: If input is sorted -  O(n) time | O(1) space
function insertionSort(array) {
  for (let i = 1; i < array.length; i++) {
    let j = i;
    while (j > 0 && array[j - 1] > array[j]) {
      swap(array, j - 1);
      j--;
    }
  }

  return array;
}

function swap(array, idx) {
  const temp = array[idx];
  array[idx] = array[idx + 1];
  array[idx + 1] = temp;
}

console.log(insertionSort([8, 5, 2, 9, 5, 6, 3]));
