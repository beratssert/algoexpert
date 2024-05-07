import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the number of the tokens
  public int reversePolishNotation(String[] tokens) {
    Stack<Integer> operands = new Stack<>();

    for (String token : tokens) {
      if (token.equals("+"))
        operands.push(operands.pop() + operands.pop());
      else if (token.equals("*"))
        operands.push(operands.pop() * operands.pop());
      else if (token.equals("-")) {
        int firstNum = operands.pop();
        operands.push(operands.pop() - firstNum);
      } else if (token.equals("/")) {
        int firstNum = operands.pop();
        operands.push(operands.pop() / firstNum);
      } else
        operands.push(Integer.parseInt(token));
    }

    return operands.pop();
  }
}
