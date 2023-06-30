// O(n) time | O(1) space - n is the length of the input
function isPalindrome(string) {
  let leftIdx = 0;
  let rightIdx = string.length - 1;
  while (leftIdx < rightIdx) {
    if (string[leftIdx] !== string[rightIdx]) return false;
    leftIdx++;
    rightIdx--;
  }

  return true;
}

// O(n^2) time | O(n) space
// function isPalindrome(string) {
//   let reversedString = "";
//   for (let i = string.length - 1; i >= 0; i--) {
//     reversedString += string[i];
//   }

//   return reversedString === string;
// }

// O(n) time | O(n) space
// function isPalindrome(string) {
//   let reversedChars = [];
//   for (let i = string.length - 1; i >= 0; i--) {
//     reversedChars.push(string[i]);
//   }

//   return string === reversedChars.join("");
// }

console.log(isPalindrome("abccbaa"));
