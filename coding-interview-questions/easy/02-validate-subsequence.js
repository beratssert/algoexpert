// O(n) time | O(1) space - where n is the length of the array
function isValidSubsequence(array, sequence) {
  let idx = 0;
  for (let num of array) {
    if (num === sequence[idx]) idx++;
  }

  return idx === sequence.length;
}

console.log(isValidSubsequence([5, 1, 22, 25, 6, -1, 8, 10], [1, 6, -1, 10]));
