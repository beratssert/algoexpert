import java.util.*;

class Program {
  // O(d * t * s) time | O(t) space - d is the number of the dice, t is the
  // target, and s is the number of the sides.
  public int diceThrows(int numDice, int numSides, int target) {
    int[][] permutationsNumberStorage = new int[2][target + 1];
    permutationsNumberStorage[0][0] = 1;

    int prev = 0;
    int current = 1;
    for (int currentDice = 1; currentDice < numDice + 1; currentDice++) {
      for (int currentTarget = 0; currentTarget < target + 1; currentTarget++) {
        int permutationNumber = 0;
        for (int currentNumSide = 1; currentNumSide < Math.min(currentTarget, numSides) + 1; currentNumSide++) {
          permutationNumber += permutationsNumberStorage[prev][currentTarget - currentNumSide];
        }

        permutationsNumberStorage[current][currentTarget] = permutationNumber;
      }

      int temp = prev;
      prev = current;
      current = temp;
    }

    return permutationsNumberStorage[prev][target];
  }

  // O(d * t * s) time | O(d * t) space - d is the number of the dice, t is the
  // target, and s is the number of the sides.
  // public int diceThrows(int numDice, int numSides, int target) {
  // int[][] permutationsNumberStorage = new int[numDice + 1][target + 1];
  // permutationsNumberStorage[0][0] = 1;

  // for (int currentDice = 1; currentDice < numDice + 1; currentDice++) {
  // for (int currentTarget = 0; currentTarget < target + 1; currentTarget++) {
  // int permutationNumber = 0;
  // for (int currentNumSide = 1; currentNumSide < Math.min(currentTarget,
  // numSides) + 1; currentNumSide++) {
  // permutationNumber += permutationsNumberStorage[currentDice - 1][currentTarget
  // - currentNumSide];
  // }
  // permutationsNumberStorage[currentDice][currentTarget] = permutationNumber;
  // }
  // }

  // return permutationsNumberStorage[numDice][target];
  // }

  // O(d * t * s) time | O(d * t) space - d is the number of the dice, t is the
  // target, and s is the number of the sides.
  // public int diceThrows(int numDice, int numSides, int target) {
  // Integer[][] permutationsNumberStorage = new Integer[numDice + 1][target + 1];
  // return diceThrows(numDice, numSides, target, permutationsNumberStorage);
  // }

  // public int diceThrows(int numDice, int numSides, int target, Integer[][]
  // permutationsNumberStorage) {
  // if (numDice == 0)
  // return target == 0 ? 1 : 0;

  // if (numDice > target)
  // return 0;

  // if (permutationsNumberStorage[numDice][target] != null)
  // return permutationsNumberStorage[numDice][target];

  // int permutationNumber = 0;
  // for (int currentSide = 1; currentSide < Math.min(numSides, target) + 1;
  // currentSide++) {
  // permutationNumber += diceThrows(numDice - 1, numSides, target - currentSide,
  // permutationsNumberStorage);
  // }
  // permutationsNumberStorage[numDice][target] = permutationNumber;

  // return permutationNumber;
  // }
}
