// O(n) time | O(1) space - where n is the input :)
// function getNthFib(n) {
//   const lastTwo = [0, 1];
//   for (let i = 2; i < n; i++) {
//     const fib = lastTwo[0] + lastTwo[1];
//     lastTwo[0] = lastTwo[1];
//     lastTwo[1] = fib;
//   }

//   return n > 1 ? lastTwo[1] : lastTwo[0];
// }

// O(2^n) time | O(n) space
// function getNthFib(n) {
//   if (n === 2) {
//     return 1;
//   } else if (n === 1) {
//     return 0;
//   } else {
//     return getNthFib(n - 1) + getNthFib(n - 2);
//   }
// }

// O(n) time | O(n) space
function getNthFib(n, memory = { 1: 0, 2: 1 }) {
  if (n in memory) return memory[n];
  memory[n] = getNthFib(n - 1, memory) + getNthFib(n - 2, memory);
  return memory[n];
}

console.log(getNthFib(6));
