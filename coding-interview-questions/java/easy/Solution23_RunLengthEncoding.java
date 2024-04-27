class Program {
  // O(n) time | O(n) space
  public String runLengthEncoding(String string) {
    int counter = 1;
    StringBuilder encodedStr = new StringBuilder();
    for (int i = 1; i < string.length(); i++) {
      char letter = string.charAt(i);
      char prevLetter = string.charAt(i - 1);
      if (prevLetter != letter || counter == 9) {
        encodedStr.append(Integer.toString(counter));
        encodedStr.append(prevLetter);
        counter = 0;
      }
      counter++;
    }

    encodedStr.append(Integer.toString(counter));
    encodedStr.append(string.charAt(string.length() - 1));

    return encodedStr.toString();
  }
}
