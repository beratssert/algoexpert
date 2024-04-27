// O(n) time | O(n) space
function missingNumbers(nums) {
  const includedNums = new Set(nums);
  const missNums = [];
  for (let num = 1; num <= nums.length + 2; num++) {
    if (!includedNums.has(num)) missNums.push(num);
  }

  return missNums;
}

// O(n) time | O(1) space
// function missingNumbers(nums) {
//   const sumOfTheAllNums = ((nums.length + 3) * (nums.length + 2)) / 2;
//   const sumOfTheNums = nums.reduce((acc, num) => acc + num, 0);
//   const average = (sumOfTheAllNums - sumOfTheNums) / 2;

//   let leftSum = 0;
//   let rightSum = 0;
//   for (let num of nums) {
//     if (num <= average) {
//       leftSum += num;
//     } else {
//       rightSum += num;
//     }
//   }

//   let leftSumOfAllNums = 0;
//   let rightSumOfAllNums = 0;
//   for (let num = 1; num <= nums.length + 2; num++) {
//     if (num <= average) {
//       leftSumOfAllNums += num;
//     } else {
//       rightSumOfAllNums += num;
//     }
//   }

//   return [leftSumOfAllNums - leftSum, rightSumOfAllNums - rightSum];
// }

console.log(missingNumbers([]));
// console.log(missingNumbers([1, 4, 3]));
