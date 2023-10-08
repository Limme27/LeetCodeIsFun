package graph;

import java.util.*;

public class CourseSchedule2_m210 {
  Set<Integer> ans;
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    ans = new LinkedHashSet<>();
    int len = prerequisites.length;
    for (int i = 0; i < len; i++) {
      int course = prerequisites[i][0];
      int prereq = prerequisites[i][1];
      if (map.containsKey(course)) map.get(course).add(prereq);
      else {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(prereq);
        map.put(course, tmp);
      }
    }
    if (graphHasCycle(map)) return new int[0];
    for (int i = 0; i < numCourses; i++) ans.add(i);
    return ans.stream().mapToInt(Integer::intValue).toArray();
  }
  
  private boolean graphHasCycle(Map<Integer, List<Integer>> map) {
    for (int course : map.keySet()) {
      if (vertexHasCycle(map, new HashSet<>(), course)) return true;
    }
    return false;
  }
	
  private boolean vertexHasCycle(Map<Integer, List<Integer>> map, Set<Integer> visited, int course) {
    if (visited.contains(course)) return true;
    if (!map.containsKey(course) || map.get(course).isEmpty()) {
      ans.add(course);
      return false;
    }  
    visited.add(course);
    for (int prereq : map.get(course)) {
      if (vertexHasCycle(map, visited, prereq)) return true;
    }
    visited.remove((Object)course);
    map.get(course).clear();
    ans.add(course);
    return false;
  }
}
