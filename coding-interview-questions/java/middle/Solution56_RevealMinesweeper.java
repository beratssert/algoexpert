import java.util.*;

class Program {
  // O(w * h) time | O(w * h) space - w is the width, and h is the height of the
  // board
  public String[][] revealMinesweeper(String[][] board, int row, int column) {
    String selected = board[row][column];
    if (selected.equals("M")) {
      board[row][column] = "X";
      return board;
    }

    ArrayList<Integer[]> neighbours = getNeighbours(board, row, column);

    int minesNumber = 0;
    for (Integer[] neighbour : neighbours) {
      int neighbourRow = neighbour[0];
      int neighbourCol = neighbour[1];

      if (board[neighbourRow][neighbourCol].equals("M"))
        minesNumber++;
    }

    if (minesNumber > 0) {
      board[row][column] = minesNumber + "";
    } else {
      board[row][column] = 0 + "";
      for (Integer[] neighbour : neighbours) {
        int neighbourRow = neighbour[0];
        int neighbourCol = neighbour[1];

        if (board[neighbourRow][neighbourCol].equals("H"))
          revealMinesweeper(board, neighbourRow, neighbourCol);
      }
    }

    return board;
  }

  public ArrayList<Integer[]> getNeighbours(String[][] board, int row, int column) {
    ArrayList<Integer[]> neighbours = new ArrayList<>();
    int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { -1, -1 },
        { -1, 1 }, { 1, -1 }, { 1, 1 }, { 0, -1 }, { 0, 1 } };

    for (int[] direction : directions) {
      int newRow = row + direction[0];
      int newColumn = column + direction[1];
      if (newRow >= 0 && newRow < board.length && newColumn >= 0 && newColumn < board[0].length)
        neighbours.add(new Integer[] { newRow, newColumn });
    }

    return neighbours;
  }
}
