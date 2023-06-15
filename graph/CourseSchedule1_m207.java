package graph;

import java.util.*;

public class CourseSchedule1_m207 {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> map = new HashMap<>();

    int len = prerequisites.length;
    for (int i = 0; i < len; i++) {
      int course = prerequisites[i][0];
      int prereq = prerequisites[i][1];
      if (course == prereq) return false;
      if (map.containsKey(course)) map.get(course).add(prereq);
      else {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(prereq);
        map.put(course, tmp);
      }
    }
    return !graphHasCycle(map);    
  }

  private boolean graphHasCycle(Map<Integer, List<Integer>> map) {
    for (int course : map.keySet()) {
      if (pathHasCycle(map, new HashSet<>(), course)) return true;
    }
    return false;
  }
	
  private boolean pathHasCycle(Map<Integer, List<Integer>> map, Set<Integer> visited, int course) {
    if (visited.contains(course)) return true;
    if (!map.containsKey(course)) return false;
    visited.add(course);
    for (int prereq : map.get(course)) {
      if (pathHasCycle(map, visited, prereq)) return true;
    }
    visited.remove(course);
    map.get(course).clear();
    return false;
  }
}
