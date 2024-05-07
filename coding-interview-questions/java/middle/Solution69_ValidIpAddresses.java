import java.util.*;

class Program {
  // O(1) time | O(1) space
  public ArrayList<String> validIPAddresses(String string) {
    ArrayList<String> validIps = new ArrayList<String>();
    for (int i = 1; i < Math.min(string.length(), 4); i++) {
      String[] ipParts = new String[4];
      ipParts[0] = string.substring(0, i);
      if (!isValidPart(ipParts[0]))
        continue;

      for (int j = i + 1; j < i + Math.min(string.length() - i, 4); j++) {
        ipParts[1] = string.substring(i, j);
        if (!isValidPart(ipParts[1]))
          continue;

        for (int k = j + 1; k < j + Math.min(string.length() - j, 4); k++) {
          ipParts[2] = string.substring(j, k);
          ipParts[3] = string.substring(k);
          if (isValidPart(ipParts[2]) && isValidPart(ipParts[3])) {
            String validIp = String.join(".", ipParts);
            validIps.add(validIp);
          }
        }
      }
    }

    return validIps;
  }

  public boolean isValidPart(String part) {
    int partAsInt = Integer.parseInt(part);
    if (partAsInt > 255 || partAsInt < 0)
      return false;

    return part.length() == (partAsInt + "").length();
  }
}
