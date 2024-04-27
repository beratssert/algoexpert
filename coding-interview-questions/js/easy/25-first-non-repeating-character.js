// O(n) time | O(1) space - n is the length of the string.
// O(1) space because the input is only english lower case alphabet.
function firstNonRepeatingCharacter(string) {
  const numberOfChars = {};
  for (let char of string) {
    if (!(char in numberOfChars)) numberOfChars[char] = 0;
    numberOfChars[char] += 1;
  }

  for (let i = 0; i < string.length; i++) {
    const char = string[i];
    if (numberOfChars[char] === 1) return i;
  }

  return -1;
}

console.log(firstNonRepeatingCharacter("abcdcaf"));
