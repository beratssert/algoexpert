// O(n) time | O(1) space - n is the total number of the seats
function bestSeat(seats) {
  let bestSeatIdx = -1;
  let maxSpace = 0;

  let idx = 0;
  while (idx < seats.length - 1) {
    let nextSeat = idx + 1;
    while (seats[nextSeat] === 0) {
      nextSeat++;
    }

    const availableSpace = nextSeat - idx - 1;
    if (availableSpace > maxSpace) {
      bestSeatIdx = Math.floor((nextSeat + idx) / 2);
      maxSpace = availableSpace;
    }

    idx = nextSeat;
  }

  return bestSeatIdx;
}

console.log(bestSeat([1, 0, 0, 1, 0, 0, 1]));
