// O(n) time | O(n) space - where n is the length of the input array
function sortedSquaredArray(array) {
  const squaredArr = new Array(array.length).fill(0);
  let firstIdx = 0;
  let lastIdx = array.length - 1;

  for (let i = squaredArr.length - 1; i >= 0; i--) {
    const prevNum = array[firstIdx];
    const backNum = array[lastIdx];

    if (Math.abs(backNum) > Math.abs(prevNum)) {
      squaredArr[i] = backNum * backNum;
      lastIdx--;
    } else {
      squaredArr[i] = prevNum * prevNum;
      firstIdx++;
    }
  }

  return squaredArr;
}

console.log(sortedSquaredArray([-5, -2, 1, 2, 3, 4, 5, 6]));
