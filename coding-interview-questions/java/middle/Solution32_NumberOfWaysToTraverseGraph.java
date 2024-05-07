class Program {
  // O(wh) time | O(wh) space - w is the width, and h is the height inputs.
  public int numberOfWaysToTraverseGraph(int width, int height) {
    int[][] board = new int[height][width];
    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        if (h == 0 || w == 0) {
          board[h][w] = 1;
        } else {
          board[h][w] = board[h][w - 1] + board[h - 1][w];
        }
      }
    }

    return board[height - 1][width - 1];
  }

  // O(w + h) time | O(1) space - w is the width, h is the height
  // public int numberOfWaysToTraverseGraph(int width, int height) {
  // int right = width - 1;
  // int down = height - 1;

  // int num = factorial(right + down);
  // int dom = factorial(right) * factorial(down);

  // return num / dom;
  // }

  // public int factorial(int num) {
  // int fact = 1;
  // for (int i = 2; i <= num; i++) {
  // fact *= i;
  // }

  // return fact;
  // }

  // O(2 ^ (w + h)) time | O(w + h) space - w is the width, and h is the height.
  // public int numberOfWaysToTraverseGraph(int width, int height) {
  // if (width == 1 || height == 1)
  // return 1;

  // return numberOfWaysToTraverseGraph(width - 1, height) +
  // numberOfWaysToTraverseGraph(width, height - 1);
  // }

}
