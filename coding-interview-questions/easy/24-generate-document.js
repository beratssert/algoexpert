// O(n + m) time - n is the length of the characters, m is the length of the document.
// O(c) space - c is the number of the unique chars od the characters
function generateDocument(characters, document) {
  const characterChars = {};

  for (let char of characters) {
    if (!(char in characterChars)) characterChars[char] = 0;
    characterChars[char] += 1;
  }

  for (let char of document) {
    if (!(char in characterChars) || characterChars[char] === 0) return false;
    characterChars[char] -= 1;
  }

  return true;
}

// O(n * (n + m)) time - n is the length of the characters, m is the length of the document.
// O(1) space
// function generateDocument(characters, document) {
//   for (let char of document) {
//     const charFrequency = getFrequency(char, characters);
//     const docFrequency = getFrequency(char, document);
//     if (charFrequency < docFrequency) return false;
//   }

//   return true;
// }

// function getFrequency(char, string) {
//   let frequency = 0;
//   for (let value of string) {
//     if (value === char) frequency++;
//   }

//   return frequency;
// }

console.log(
  generateDocument("Bste!hetsi ogEAxpelrt x ", "AlgoExpert is the Best!")
); // true
