// O(nlogn + mlogm) time | O(1) space
function smallestDifference(arrayOne, arrayTwo) {
  arrayOne.sort((a, b) => a - b);
  arrayTwo.sort((a, b) => a - b);

  let idx1 = 0;
  let idx2 = 0;

  let smallestDifference = Infinity;
  let pair = [];
  while (idx1 < arrayOne.length && idx2 < arrayTwo.length) {
    const num1 = arrayOne[idx1];
    const num2 = arrayTwo[idx2];
    let currentDifference;

    if (num1 < num2) {
      currentDifference = num2 - num1;
      idx1++;
    } else if (num2 < num1) {
      currentDifference = num1 - num2;
      idx2++;
    } else {
      return [num1, num2];
    }

    if (currentDifference < smallestDifference) {
      smallestDifference = currentDifference;
      pair = [num1, num2];
    }
  }

  return pair;
}

console.log(smallestDifference([-1, 5, 10, 20, 28, 3], [26, 134, 135, 15, 17]));
