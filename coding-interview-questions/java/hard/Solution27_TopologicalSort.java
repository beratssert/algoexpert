import java.util.*;

class Program {
  // O(j + d) time | O(j + d) space - j is the number of the jobs, and d is the
  // number of the deps
  public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
    JobGraph jobGraph = createJobGraph(jobs, deps);
    return topologicalSort(jobGraph);
  }

  public static List<Integer> topologicalSort(JobGraph jobGraph) {
    List<Integer> orderedJobs = new ArrayList<>();
    Stack<JobNode> jobs = jobGraph.jobs;
    while (!jobs.isEmpty()) {
      JobNode job = jobs.pop();
      boolean containsCycle = depthFirstTraverse(job, orderedJobs);
      if (containsCycle)
        return new ArrayList<>();
    }

    return orderedJobs;
  }

  public static boolean depthFirstTraverse(JobNode job, List<Integer> orderedJobs) {
    if (job.visited)
      return false;

    if (job.visiting)
      return true;

    job.visiting = true;
    for (JobNode prereq : job.prereq) {
      boolean containsCycle = depthFirstTraverse(prereq, orderedJobs);
      if (containsCycle)
        return true;
    }

    orderedJobs.add(job.job);
    job.visited = true;
    job.visiting = false;

    return false;
  }

  public static JobGraph createJobGraph(List<Integer> jobs, List<Integer[]> deps) {
    JobGraph jobGraph = new JobGraph(jobs);
    for (Integer[] dep : deps) {
      jobGraph.addPrereq(dep[0], dep[1]);
    }

    return jobGraph;
  }
}

class JobGraph {
  protected Stack<JobNode> jobs = new Stack<>();
  protected HashMap<Integer, JobNode> graph = new HashMap<>();

  public JobGraph(List<Integer> jobs) {
    for (Integer job : jobs) {
      addJob(job);
    }
  }

  public void addJob(int job) {
    JobNode jobNode = new JobNode(job);
    graph.put(job, jobNode);
    jobs.add(jobNode);
  }

  public void addPrereq(int preq, int job) {
    JobNode preqNode = getNode(preq);
    JobNode jobNode = getNode(job);
    jobNode.prereq.add(preqNode);
  }

  public JobNode getNode(int job) {
    if (!graph.containsKey(job)) {
      addJob(job);
    }

    return graph.get(job);
  }
}

class JobNode {
  protected int job;
  protected List<JobNode> prereq = new ArrayList<>();
  protected boolean visited = false;
  protected boolean visiting = false;

  public JobNode(int job) {
    this.job = job;
  }
}