function findThreeLargestNumbers(array) {
  const threeLargestNums = [null, null, null];
  for (let i = 0; i < array.length; i++) {
    const num = array[i];
    updateNum(num, threeLargestNums);
  }

  return threeLargestNums;
}

function updateNum(num, threeLargestNums) {
  if (threeLargestNums[2] === null || num > threeLargestNums[2]) {
    updateAndShiftNum(num, 2, threeLargestNums);
  } else if (threeLargestNums[1] === null || num > threeLargestNums[1]) {
    updateAndShiftNum(num, 1, threeLargestNums);
  } else if (threeLargestNums[0] === null || num > threeLargestNums[0]) {
    updateAndShiftNum(num, 0, threeLargestNums);
  }
}

function updateAndShiftNum(num, idx, threeLargestNums) {
  for (let i = 0; i <= idx; i++) {
    if (i === idx) {
      threeLargestNums[i] = num;
    } else {
      threeLargestNums[i] = threeLargestNums[i + 1];
    }
  }
}

// function findThreeLargestNumbers(array) {
//   const threeLargestNums = array.slice(0, 3);
//   for (let i = 3; i < array.length; i++) {
//     const num = array[i];
//     if (num > Math.min(...threeLargestNums)) {
//       addNum(num, threeLargestNums);
//     }
//   }

//   threeLargestNums.sort((a, b) => a - b);
//   return threeLargestNums;
// }

// function addNum(num, threeLargestNums) {
//   let min = threeLargestNums[0];
//   let minIdx = 0;
//   for (let i = 0; i < threeLargestNums.length; i++) {
//     if (threeLargestNums[i] < min) {
//       min = threeLargestNums[i];
//       minIdx = i;
//     }
//   }

//   threeLargestNums[minIdx] = num;
// }

console.log(
  findThreeLargestNumbers([141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7])
);
