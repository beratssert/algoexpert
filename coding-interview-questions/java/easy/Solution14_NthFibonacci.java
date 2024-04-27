import java.util.*;

class Program {
  // O(n) time | O(1) space
  // public static int getNthFib(int n) {
  // int[] lastTwo = { 0, 1 };
  // int counter = 2;
  // while (counter < n) {
  // int fib = lastTwo[0] + lastTwo[1];
  // lastTwo[0] = lastTwo[1];
  // lastTwo[1] = fib;
  // counter++;
  // }

  // return n > 1 ? lastTwo[1] : lastTwo[0];
  // }

  // O(2^n) time | O(n) space
  // public static int getNthFib(int n) {
  // if (n == 1)
  // return 0;
  // if (n == 2)
  // return 1;
  // return getNthFib(n - 1) + getNthFib(n - 2);
  // }

  // O(n) time | O(n) space
  public static int getNthFib(int n) {
    Map<Integer, Integer> fibonacci = new HashMap<Integer, Integer>();
    fibonacci.put(1, 0);
    fibonacci.put(2, 1);
    return getNthFib(n, fibonacci);
  }

  public static int getNthFib(int n, Map<Integer, Integer> fibonacci) {
    if (fibonacci.containsKey(n)) {
      return fibonacci.get(n);
    } else {
      fibonacci.put(n, getNthFib(n - 1, fibonacci) + getNthFib(n - 2, fibonacci));
      return fibonacci.get(n);
    }
  }
}
