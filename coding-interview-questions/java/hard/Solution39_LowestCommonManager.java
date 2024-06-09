import java.util.*;

class Program {
  // O(n) time | O(d) space - n is the number of people int Org, d is the depth of
  // the Org Chart.
  public static OrgChart getLowestCommonManager(
      OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
    return getOrgInfo(topManager, reportOne, reportTwo).lowestCommonManager;
  }

  public static OrgInfo getOrgInfo(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
    int numImportantReports = 0;
    for (OrgChart report : manager.directReports) {
      OrgInfo orgInfo = getOrgInfo(report, reportOne, reportTwo);
      if (orgInfo.lowestCommonManager != null)
        return orgInfo;

      numImportantReports += orgInfo.numImportantReports;
    }

    if (manager == reportOne || manager == reportTwo)
      numImportantReports++;

    OrgChart lowestCommonManager = numImportantReports == 2 ? manager : null;
    return new OrgInfo(lowestCommonManager, numImportantReports);
  }

  static class OrgInfo {
    OrgChart lowestCommonManager;
    int numImportantReports;

    public OrgInfo(OrgChart lowestCommonManager, int numImportantReports) {
      this.lowestCommonManager = lowestCommonManager;
      this.numImportantReports = numImportantReports;
    }
  }

  static class OrgChart {
    public char name;
    public List<OrgChart> directReports;

    OrgChart(char name) {
      this.name = name;
      this.directReports = new ArrayList<OrgChart>();
    }

    // This method is for testing only.
    public void addDirectReports(OrgChart[] directReports) {
      for (OrgChart directReport : directReports) {
        this.directReports.add(directReport);
      }
    }
  }
}
