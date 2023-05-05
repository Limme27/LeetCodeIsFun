package design;

import java.util.*;

public class LRUCache_m146 {
  private Map<Integer, Integer> kv;
  private static Map<Integer, Integer> kc;
  private static TreeMap<Integer, Integer> ck;
  private int cap;
  private static int count;
  
  public LRUCache_m146(int capacity) {
    kv = new HashMap<>();
    kc = new HashMap<>();
    ck = new TreeMap<>();
    cap = capacity;
    count = 0;
  }
  
  public int get(int key) {
    if (!kv.containsKey(key)) return -1;
    canUpdateKCandCK(key);
    return kv.get(key);
  }
  
  public void put(int key, int value) {
    if (kv.containsKey(key)) {
      canUpdateKCandCK(key);
    } else if (kv.size() < cap) {
      updateKCandCK(key);
    } else {
      // Delete least recent
      Map.Entry<Integer, Integer> least = ck.pollFirstEntry();
      kv.remove(least.getValue());
      kc.remove(least.getValue());
      // Add new
      updateKCandCK(key);
    }
    kv.put(key, value);
  }
  
  private static void canUpdateKCandCK(int key) {
    int currCount = kc.get(key);
    if (ck.lastKey() != currCount) {
      ck.remove(currCount);
      updateKCandCK(key);
    }
  }

  private static void updateKCandCK(int key) {
    int newCount = count++;
    kc.put(key, newCount);
    ck.put(newCount, key);
  }
}
