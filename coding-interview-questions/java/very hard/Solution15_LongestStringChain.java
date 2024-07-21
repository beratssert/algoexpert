import java.util.*;

class Program {
  // O(nlogn + n * m^2) time | O(n * m) space - n is the number of the strings and
  // m is the length of the longest string.
  public static List<String> longestStringChain(List<String> strings) {
    HashMap<String, StringChain> stringChains = new HashMap<>();
    for (String string : strings) {
      StringChain chain = new StringChain("", 1);
      stringChains.put(string, chain);
    }

    List<String> sortedStrings = new ArrayList<>(strings);
    sortedStrings.sort((a, b) -> a.length() - b.length());

    for (String string : sortedStrings) {
      findLongestStringChain(string, stringChains);
    }

    return buildChain(strings, stringChains);
  }

  public static void findLongestStringChain(String string, HashMap<String, StringChain> stringChains) {
    for (int i = 0; i < string.length(); i++) {
      String smallerString = string.substring(0, i) + string.substring(i + 1);
      if (!stringChains.containsKey(smallerString))
        continue;

      StringChain currentChain = stringChains.get(string);
      if (stringChains.get(smallerString).length + 1 > currentChain.length) {
        currentChain.length = stringChains.get(smallerString).length + 1;
        currentChain.nextStr = smallerString;
      }
    }
  }

  public static List<String> buildChain(List<String> strings, HashMap<String, StringChain> stringChains) {
    int length = 1;
    String str = "";
    for (String string : strings) {
      if (stringChains.get(string).length > length) {
        length = stringChains.get(string).length;
        str = string;
      }
    }

    List<String> chain = new ArrayList<>();
    while (str != "") {
      chain.add(str);
      str = stringChains.get(str).nextStr;
    }

    return chain;
  }

  static class StringChain {
    protected String nextStr;
    protected int length;

    public StringChain(String nextStr, int length) {
      this.nextStr = nextStr;
      this.length = length;
    }
  }
}
