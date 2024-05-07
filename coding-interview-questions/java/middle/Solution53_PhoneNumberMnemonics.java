import java.util.*;

class Program {
  public static HashMap<String, String[]> DIGIT_LETTERS = new HashMap<>();

  static {
    DIGIT_LETTERS.put("0", new String[] { "0" });
    DIGIT_LETTERS.put("1", new String[] { "1" });
    DIGIT_LETTERS.put("2", new String[] { "a", "b", "c" });
    DIGIT_LETTERS.put("3", new String[] { "d", "e", "f" });
    DIGIT_LETTERS.put("4", new String[] { "g", "h", "i" });
    DIGIT_LETTERS.put("5", new String[] { "j", "k", "l" });
    DIGIT_LETTERS.put("6", new String[] { "m", "n", "o" });
    DIGIT_LETTERS.put("7", new String[] { "p", "q", "r", "s" });
    DIGIT_LETTERS.put("8", new String[] { "t", "u", "v" });
    DIGIT_LETTERS.put("9", new String[] { "w", "x", "y", "z" });
  }

  // O(n*4^n) time | O(n*4^n) space - n is the length of the phone number
  public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
    ArrayList<String> mnemonics = new ArrayList<>();
    String[] currentMnemonic = new String[phoneNumber.length()];
    phoneNumberMnemonics(0, phoneNumber, currentMnemonic, mnemonics);
    return mnemonics;
  }

  public void phoneNumberMnemonics(int idx, String phoneNumber, String[] currentMnemonic, ArrayList<String> mnemonics) {
    if (idx == phoneNumber.length()) {
      String mnemonic = String.join("", currentMnemonic);
      mnemonics.add(mnemonic);
    } else {
      String digit = String.valueOf(phoneNumber.charAt(idx));
      String[] letters = DIGIT_LETTERS.get(digit);
      for (String letter : letters) {
        currentMnemonic[idx] = letter;
        phoneNumberMnemonics(idx + 1, phoneNumber, currentMnemonic, mnemonics);
      }
    }
  }
}
