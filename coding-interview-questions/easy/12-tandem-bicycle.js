// O(nlogn) time | O(1) space - where n is the number of the tandem bicycles
function tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest) {
  redShirtSpeeds.sort((a, b) => a - b);

  if (fastest) {
    blueShirtSpeeds.sort((a, b) => b - a);
  } else {
    blueShirtSpeeds.sort((a, b) => a - b);
  }

  let totalSpeed = 0;
  for (let i = 0; i < redShirtSpeeds.length; i++) {
    totalSpeed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
  }

  return totalSpeed;
}

// function tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest) {
//   redShirtSpeeds.sort((a, b) => a - b);
//   blueShirtSpeeds.sort((a, b) => (fastest ? b - a : a - b));

//   let totalSpeed = 0;
//   for (let i = 0; i < redShirtSpeeds.length; i++) {
//     totalSpeed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
//   }

//   return totalSpeed;
// }

console.log(tandemBicycle([5, 5, 3, 9, 2], [3, 6, 7, 2, 1], true));
