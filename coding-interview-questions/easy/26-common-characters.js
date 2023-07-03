// O (n * m) time | O(m) space
// n is the length of the input strings, m is the length of the longest string.
function commonCharacters(strings) {
  let commonCharsSet = new Set(strings[0]);
  for (let word of strings) {
    const tempSet = new Set();
    for (let char of word) {
      if (commonCharsSet.has(char)) {
        tempSet.add(char);
      }
    }

    commonCharsSet = tempSet;
  }

  return Array.from(commonCharsSet);
}

// console.log(commonCharacters(["aa", "aa"]));
console.log(commonCharacters(["abc", "bcd", "cbad"]));
