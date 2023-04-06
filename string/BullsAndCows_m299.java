package string;

import java.util.*;

public class BullsAndCows_m299 {
  // int[] as recorder
  public String getHint(String secret, String guess) {
    int[] recorder = new int[10];
    int bull = 0;
    int cow = 0;
    int len = secret.length();
    for (int i = 0; i < len; i++) {
      if (secret.charAt(i) == guess.charAt(i)) bull++;
      else {
        if (recorder[secret.charAt(i) - '0']++ < 0) cow++;
        if (recorder[guess.charAt(i) - '0']-- > 0) cow++;
      }
    }
    return bull+"A"+cow+"B";
  }
  
  // HashTable as recorder
  public String getHintHashTable(String secret, String guess) {
    Map<Character, Integer> mapS = new HashMap<>();
    Map<Character, Integer> mapG = new HashMap<>();
    int bull = 0;
    int len = secret.length();
    for (int i = 0; i < len; i++) {
      mapS.put(secret.charAt(i), mapS.getOrDefault(secret.charAt(i), 0) + 1);
      mapG.put(guess.charAt(i), mapG.getOrDefault(guess.charAt(i), 0) + 1);
      if (secret.charAt(i) == guess.charAt(i)) bull++;
    }
    int cow = 0;
    for (Character c : mapS.keySet()) {
      if (mapG.containsKey(c)) cow += Math.min(mapG.get(c), mapS.get(c));
    }
    return bull+"A"+(cow-bull)+"B";
  }
}
