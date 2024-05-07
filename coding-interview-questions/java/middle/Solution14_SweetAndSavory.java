import java.util.*;

class Program {
  // O(nlogn) time | O(n) space - n is the number of the dishes
  public int[] sweetAndSavory(int[] dishes, int target) {
    ArrayList<Integer> sweetDishes = new ArrayList<>();
    ArrayList<Integer> savoryDishes = new ArrayList<>();

    for (int dish : dishes) {
      if (dish < 0) {
        sweetDishes.add(dish);
      } else {
        savoryDishes.add(dish);
      }
    }

    sweetDishes.sort(Comparator.comparingInt(Math::abs));
    savoryDishes.sort(Comparator.naturalOrder());

    int[] bestPair = new int[2];
    int bestDifference = Integer.MAX_VALUE;
    int sweetIdx = 0;
    int savoryIdx = 0;
    while (sweetIdx < sweetDishes.size() && savoryIdx < savoryDishes.size()) {
      int currentSum = sweetDishes.get(sweetIdx) + savoryDishes.get(savoryIdx);
      if (currentSum <= target) {
        int currentDifference = target - currentSum;
        if (currentDifference < bestDifference) {
          bestPair[0] = sweetDishes.get(sweetIdx);
          bestPair[1] = savoryDishes.get(savoryIdx);
          bestDifference = currentDifference;
        }

        savoryIdx++;
      } else {
        sweetIdx++;
      }
    }

    return bestPair;
  }

  // O(nlogn) time | O(1) space
  // public int[] sweetAndSavory(int[] dishes, int target) {
  // Arrays.sort(dishes);

  // int[] bestPair = new int[2];
  // int bestDifference = Integer.MAX_VALUE;

  // int sweet = 0;
  // int savory = dishes.length - 1;
  // while (sweet < savory && dishes[sweet] < 0 && dishes[savory] > 0) {
  // int currentSum = dishes[sweet] + dishes[savory];
  // if (currentSum <= target) {
  // int difference = target - currentSum;
  // if (difference < bestDifference) {
  // bestPair = new int[] { dishes[sweet], dishes[savory] };
  // bestDifference = difference;
  // }
  // sweet++;
  // } else {
  // savory--;
  // }
  // }

  // return bestPair;
  // }
}
