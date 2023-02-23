package string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrs_205 {
  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> dict = new HashMap<Character, Character>();
    Map<Character, Character> dict1 = new HashMap<Character, Character>();
    int len  = s.length();
    for (int i = 0; i < len; i++) {
      if (dict.containsKey(s.charAt(i)) && dict.get(s.charAt(i)) != t.charAt(i))
        return false;
      else dict.put(s.charAt(i), t.charAt(i));
      if (dict1.containsKey(t.charAt(i)) && dict1.get(t.charAt(i)) != s.charAt(i))
        return false;
      else dict1.put(t.charAt(i), s.charAt(i));
    }
    return true;
  }
}
