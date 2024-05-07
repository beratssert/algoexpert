import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the number of the asteroids.
  public int[] collidingAsteroids(int[] asteroids) {
    Stack<Integer> astroidStack = new Stack<>();
    for (int i = 0; i < asteroids.length; i++) {
      int astreoid = asteroids[i];
      if (astreoid > 0) {
        astroidStack.push(astreoid);
        continue;
      }

      while (true) {
        if (astroidStack.isEmpty() || astroidStack.peek() < 0) {
          astroidStack.push(astreoid);
          break;
        }

        int astreoidSize = Math.abs(astreoid);
        if (astreoidSize < astroidStack.peek())
          break;
        if (astreoidSize == astroidStack.peek()) {
          astroidStack.pop();
          break;
        }
        astroidStack.pop();
      }
    }

    int[] result = new int[astroidStack.size()];
    int i = 0;
    for (Integer astreoid : astroidStack) {
      result[i] = astreoid;
      i++;
    }

    return result;
  }
}
