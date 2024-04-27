// O(n) time | O(n) space - n is the length of the string
function runLengthEncoding(string) {
  const encodedChars = [];
  let counter = 1;
  for (let i = 0; i < string.length; i++) {
    const currentChar = string[i];
    const nextChar = string[i + 1];

    if (currentChar !== nextChar || counter === 9) {
      encodedChars.push(`${counter}${currentChar}`);
      counter = 0;
    }

    counter++;
  }

  return encodedChars.join("");
}

console.log(runLengthEncoding("aA"));
