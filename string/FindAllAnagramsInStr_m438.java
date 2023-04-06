package string;

import java.util.*;

public class FindAllAnagramsInStr_m438 {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> ans = new ArrayList<>();
    int lenp = p.length();
    int lens = s.length();
    if (lenp > lens) return ans;
    // int[] as Recorder same as Q.299
    int[] curr = new int[26];
    int[] patn = new int[26];
    
    for (int i = 0; i < lens; i++) {
      curr[s.charAt(i) - 'a']++;
      if (i < lenp) {
        patn[p.charAt(i) - 'a']++;
        if (i == lenp - 1 && isSameArr(curr, patn)) ans.add(0);
      } else {
        curr[s.charAt(i-lenp) - 'a']--;
        if (isSameArr(curr, patn)) ans.add(i-lenp+1);
      }
    }
    return ans;
  }
  public static boolean isSameArr(int[] curr, int[] patn) {
    for (int i = 0; i < 26; i++)
      if (curr[i] != patn[i]) return false;
    return true;
  }
}
