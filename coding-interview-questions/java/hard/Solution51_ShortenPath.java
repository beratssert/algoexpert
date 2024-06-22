import java.util.*;

class Program {
  // O(n) time | O(n) space - n is the length of the path.
  public static String shortenPath(String path) {
    Stack<String> dirs = new Stack<>();
    if (path.charAt(0) == '/')
      dirs.add("");

    String[] dirNames = path.split("/");
    for (String dir : dirNames) {
      if (dir.equals(".") || dir.length() == 0)
        continue;

      if (dir.equals("..")) {
        if (dirs.isEmpty() || dirs.peek().equals(".."))
          dirs.add(dir);
        else if (!dirs.peek().equals(""))
          dirs.pop();
      } else {
        dirs.add(dir);
      }
    }

    if (dirs.size() == 1 && dirs.peek() == "")
      return "/";

    return String.join("/", dirs);
  }
}
