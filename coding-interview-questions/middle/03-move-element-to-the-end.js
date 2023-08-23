// O(n) time | O(1) space
function moveElementToEnd(array, toMove) {
  let leftIdx = 0;
  let rightIdx = array.length - 1;

  while (leftIdx < rightIdx) {
    while (leftIdx < rightIdx && array[rightIdx] === toMove) rightIdx--;
    if (array[leftIdx] === toMove) swap(array, leftIdx, rightIdx);
    leftIdx++;
  }

  return array;
}

function swap(array, left, right) {
  const temp = array[left];
  array[left] = array[right];
  array[right] = temp;
}

// function moveElementToEnd(array, toMove) {
//   let i = 0;
//   counter = 0;
//   while (counter < array.length) {
//     const num = array[i];
//     if (num === toMove) {
//       shift(array, i);
//     } else {
//       i++;
//     }
//     counter++;
//   }

//   return array;
// }

// function shift(array, idx) {
//   let temp = array[idx];
//   for (let i = idx; i < array.length - 1; i++) {
//     array[i] = array[i + 1];
//   }

//   array[array.length - 1] = temp;
// }

console.log(moveElementToEnd([2, 1, 2, 2, 2, 3, 4, 2], 2));
