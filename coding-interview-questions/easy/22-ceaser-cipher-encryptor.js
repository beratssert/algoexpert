// O(n) time | O(n) space - n is the length of the input
function caesarCipherEncryptor(string, key) {
  const alphabet = [..."abcdefghijklmnopqrstuvwxyz"];
  const cipheredChars = [];
  for (let char of string) {
    const charIdx = alphabet.indexOf(char);
    const newIdx = (charIdx + key) % alphabet.length;
    cipheredChars.push(alphabet[newIdx]);
  }

  return cipheredChars.join("");
}

console.log(caesarCipherEncryptor("xyz", 2));
