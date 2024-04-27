// O(n) time | O(1) space
function threeNumberSort(array, order) {
  let idx = 0;
  for (let i = 0; i < order.length - 1; i++) {
    for (let j = 0; j < array.length; j++) {
      if (array[j] === order[i]) {
        const temp = array[idx];
        array[idx] = array[j];
        array[j] = temp;
        idx++;
      }
    }
  }

  return array;
}

console.log(threeNumberSort([1, 0, 0, -1, -1, 0, 1, 1], [0, 1, -1]));
