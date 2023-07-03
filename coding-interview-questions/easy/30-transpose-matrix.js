// O(w * h) time | O(w * h) space
// w is the width and h is the heigth of the matrix.
function transposeMatrix(matrix) {
  const row = matrix.length;
  const column = matrix[0].length;
  const transposedMatrix = [];

  for (let i = 0; i < column; i++) {
    let columnArr = [];
    for (let j = 0; j < row; j++) {
      columnArr.push(matrix[j][i]);
    }

    transposedMatrix.push(columnArr);
  }

  return transposedMatrix;
}

console.log(transposeMatrix([[1, 2, 3]]));
