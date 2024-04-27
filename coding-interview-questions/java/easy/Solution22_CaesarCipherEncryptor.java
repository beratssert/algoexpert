class Program {
  // O(n) time | O(n) space
  // public static String caesarCypherEncryptor(String str, int key) {
  // String alphabet = "abcdefghijklmnopqrstuvwxyz";
  // char[] cypheredChars = new char[str.length()];
  // for (int i = 0; i < str.length(); i++) {
  // char character = str.charAt(i);
  // int idx = (alphabet.indexOf(character) + key) % alphabet.length();
  // cypheredChars[i] = alphabet.charAt(idx);
  // }
  // return new String(cypheredChars);
  // }

  // O(n) time | O(n) space
  public static String caesarCypherEncryptor(String str, int key) {
    char[] cypheredChars = new char[str.length()];
    for (int i = 0; i < str.length(); i++) {
      cypheredChars[i] = getNewLetter(str.charAt(i), key);
    }

    return new String(cypheredChars);
  }

  public static char getNewLetter(char letter, int key) {
    int newKey = letter + (key % 26);
    return newKey <= 122 ? (char) newKey : (char) (96 + newKey % 122);
  }
}
