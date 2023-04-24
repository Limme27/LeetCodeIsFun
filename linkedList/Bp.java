package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */
public class Bp {
  // Floyd's cycle detection algorithm
  public static boolean hasCycle(Map<String, String> linkedList) {
    String slow = linkedList.keySet().iterator().next();
    String fast = slow;
    while (fast != null && linkedList.containsKey(fast)) {
      slow = linkedList.get(slow);
      fast = linkedList.get(fast);
      if (fast != null && linkedList.containsKey(fast)) fast = linkedList.get(fast); 
      else break;
      if (slow.equals(fast)) return true;
    }
    return false;
  }
  
  public static boolean DoLinkedListsIntersect(String[] lists, Map<String, String> map) {
    Set<String> set = new HashSet<>();
    for (String node : lists) {
      if (!set.add(node)) return true;
      String next = map.get(node);
      while (map.containsKey(next)) {
        if (!set.add(next)) return true;
        next = map.get(next);
      }
      if (!set.add(next)) return true;
    }
    return false;
  }
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    Map<String, String> map = new HashMap<>();
    while ((line = in.readLine()) != null) {
      if (line.contains("->")) {
        String[] parts = line.split("->");
        map.put(parts[0], parts[1]);
      } else {
        String[] parts = line.split(",");
        if (hasCycle(map)) throw new IllegalArgumentException();
        if (DoLinkedListsIntersect(parts, map)) System.out.println("True");
        else System.out.println("False");
      }
    }
  }
}