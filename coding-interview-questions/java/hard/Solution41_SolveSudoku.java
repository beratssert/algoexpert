import java.util.*;

class Program {
  // O(1) time | O(1) space - assume that board is a 9x9 grid
  public ArrayList<ArrayList<Integer>> solveSudoku(
      ArrayList<ArrayList<Integer>> board) {
    solveSudokuPartially(0, 0, board);
    return board;
  }

  public boolean solveSudokuPartially(int row, int col, ArrayList<ArrayList<Integer>> board) {
    int currentRow = row;
    int currentCol = col;

    if (currentCol == board.get(0).size()) {
      currentRow++;
      currentCol = 0;
      if (currentRow == board.size())
        return true;
    }

    if (board.get(currentRow).get(currentCol) == 0)
      return tryDigitAtPosition(currentRow, currentCol, board);

    return solveSudokuPartially(currentRow, currentCol + 1, board);
  }

  public boolean tryDigitAtPosition(int row, int col, ArrayList<ArrayList<Integer>> board) {
    for (int digit = 1; digit < 10; digit++) {
      if (isValidDigit(digit, row, col, board)) {
        board.get(row).set(col, digit);
        if (solveSudokuPartially(row, col + 1, board))
          return true;
      }
    }

    board.get(row).set(col, 0);
    return false;
  }

  public boolean isValidDigit(int digit, int row, int col, ArrayList<ArrayList<Integer>> board) {
    boolean isRowNotValid = board.get(row).contains(digit);
    boolean isColNotValid = false;
    for (int i = 0; i < board.size(); i++) {
      if (board.get(i).get(col) == digit)
        isColNotValid = true;
    }

    if (isColNotValid || isRowNotValid)
      return false;

    int rowOfSubGrid = row / 3;
    int colOfSubGrid = col / 3;
    for (int subRow = 0; subRow < 3; subRow++) {
      int currentRow = rowOfSubGrid * 3 + subRow;
      for (int subCol = 0; subCol < 3; subCol++) {
        int currentCol = colOfSubGrid * 3 + subCol;
        if (board.get(currentRow).get(currentCol) == digit)
          return false;
      }
    }

    return true;
  }
}