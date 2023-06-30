// In every scenerio, O(n^2) time | O(1) space - n is the length of the input
function selectionSort(array) {
  for (let i = 0; i < array.length - 1; i++) {
    let minIdx = i;
    for (let j = i + 1; j < array.length; j++) {
      if (array[j] < array[minIdx]) minIdx = j;
    }

    swap(array, i, minIdx);
  }

  return array;
}

function swap(array, i, minIdx) {
  const temp = array[i];
  array[i] = array[minIdx];
  array[minIdx] = temp;
}

console.log(selectionSort([8, 5, 2, 9, 5, 6, 3]));
