// O(nlogn) time | O(1) space - where n is the number of the students
function classPhotos(redShirtHeights, blueShirtHeights) {
  redShirtHeights.sort((a, b) => a - b);
  blueShirtHeights.sort((a, b) => a - b);

  const frontRow = redShirtHeights[0] < blueShirtHeights[0] ? "RED" : "BLUE";

  for (let i = 0; i < redShirtHeights.length; i++) {
    const redStudent = redShirtHeights[i];
    const blueStudent = blueShirtHeights[i];

    if (frontRow === "RED") {
      if (redStudent >= blueStudent) return false;
    } else if (blueStudent >= redStudent) return false;
  }

  return true;
}

console.log(classPhotos([5, 8, 1, 3, 4], [6, 9, 2, 4, 5]));
// [1, 3, 4, 5, 8]
// [2, 4, 5, 6, 9]
