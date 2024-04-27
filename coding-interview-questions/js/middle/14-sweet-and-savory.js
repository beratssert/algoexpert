// O(nlogn) time | O(n) space
function sweetAndSavory(dishes, target) {
  const sweetDishes = dishes.filter((dish) => dish < 0).sort((a, b) => a - b);
  const savoryDishes = dishes.filter((dish) => dish > 0).sort((a, b) => b - a);

  let bestDish = [0, 0];
  let distance = Infinity;
  let sweetIdx = 0;
  let savoryIdx = 0;

  while (sweetIdx < sweetDishes.length && savoryIdx < savoryDishes.length) {
    const total = sweetDishes[sweetIdx] + savoryDishes[savoryIdx];

    if (total <= target) {
      const currentDistance = target - total;
      if (currentDistance < distance) {
        bestDish = [sweetDishes[sweetIdx], savoryDishes[savoryIdx]];
        distance = currentDistance;
      }
      sweetIdx++;
    } else {
      savoryIdx++;
    }
  }

  return bestDish;
}

console.log(sweetAndSavory([-3, -5, 1, 7], 8));
console.log(sweetAndSavory([-20, -12, -5, -1, 12, 14], 6));
