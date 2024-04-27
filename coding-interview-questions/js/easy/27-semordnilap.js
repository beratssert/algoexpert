// O(n * m) time
// n is the length of the input, m is the length of the longest word.
function semordnilap(words) {
  const pairs = [];
  const storage = {};

  for (let word of words) {
    if (word in storage) {
      pairs.push([word, storage[word]]);
    } else {
      const reversedWord = word.split("").reverse().join("");
      storage[reversedWord] = word;
    }
  }

  return pairs;
}

console.log(semordnilap(["diaper", "abc", "test", "cba", "repaid"]));
