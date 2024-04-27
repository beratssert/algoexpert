// O(n) time | O(n) space - n is the total number of the array.
function spiralTraverse(array) {
  let startingColumn = 0;
  let endingColumn = array[0].length - 1;
  let startingRow = 0;
  let endingRow = array.length - 1;
  const traversedArray = [];

  while (startingColumn <= endingColumn && startingRow <= endingRow) {
    for (let row = startingColumn; row <= endingColumn; row++) {
      traversedArray.push(array[startingRow][row]);
    }

    for (let column = startingRow + 1; column <= endingRow; column++) {
      traversedArray.push(array[column][endingColumn]);
    }

    for (let row = endingColumn - 1; row >= startingColumn; row--) {
      if (startingRow === endingRow) break;
      traversedArray.push(array[endingRow][row]);
    }

    for (let column = endingRow - 1; column > startingRow; column--) {
      if (startingColumn === endingColumn) break;
      traversedArray.push(array[column][startingColumn]);
    }

    startingColumn++;
    endingColumn--;
    startingRow++;
    endingRow--;
  }

  return traversedArray;
}

// O(n) time | O(n) space - n is the total number of the array.
// function spiralTraverse(array) {
//   const traversedArray = [];
//   getSpiralValues(
//     array,
//     0,
//     array[0].length - 1,
//     0,
//     array.length - 1,
//     traversedArray
//   );
//   return traversedArray;
// }

// function getSpiralValues(
//   array,
//   startingColumn,
//   endingColumn,
//   startingRow,
//   endingRow,
//   traversedArray
// ) {
//   if (startingRow > endingRow || startingColumn > endingColumn) return;

//   for (let row = startingColumn; row <= endingColumn; row++) {
//     traversedArray.push(array[startingRow][row]);
//   }

//   for (let column = startingRow + 1; column <= endingRow; column++) {
//     traversedArray.push(array[column][endingColumn]);
//   }

//   for (let row = endingColumn - 1; row >= startingColumn; row--) {
//     if (startingRow === endingRow) break;
//     traversedArray.push(array[endingRow][row]);
//   }

//   for (let column = endingRow - 1; column > startingRow; column--) {
//     if (startingColumn === endingColumn) break;
//     traversedArray.push(array[column][startingColumn]);
//   }

//   getSpiralValues(
//     array,
//     startingColumn + 1,
//     endingColumn - 1,
//     startingRow + 1,
//     endingRow - 1,
//     traversedArray
//   );
// }

console.log(
  spiralTraverse([
    [1, 2, 3, 4],
    [12, 13, 14, 5],
    [11, 16, 15, 6],
    [10, 9, 8, 7],
  ])
);
