import java.util.*;

class Program {
  // O( (2n)! / (n! * (n + 1)!) ) time | O( (2n)! / (n! * (n + 1)!) ) space - n is
  // the number of the tags
  public ArrayList<String> generateDivTags(int numberOfTags) {
    ArrayList<String> matchedDivTags = new ArrayList<>();
    generateDivTags(matchedDivTags, numberOfTags, numberOfTags, "");
    return matchedDivTags;
  }

  public void generateDivTags(ArrayList<String> result, int openingTagsNeeded, int closingTagsNeeded, String prefix) {
    if (openingTagsNeeded > 0)
      generateDivTags(result, openingTagsNeeded - 1, closingTagsNeeded, prefix + "<div>");

    if (openingTagsNeeded < closingTagsNeeded)
      generateDivTags(result, openingTagsNeeded, closingTagsNeeded - 1, prefix + "</div>");

    if (closingTagsNeeded == 0)
      result.add(prefix);
  }
}
