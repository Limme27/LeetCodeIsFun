package binarySearch.array;

public class KokoEatingBananas_875 {
  public int minEatingSpeed(int[] piles, int h) {
    int max = Integer.MIN_VALUE;
    for (int i : piles) {
      max = Math.max(max, i);
    }

    int l = 1, r = max;
    int res = max;
    while (l <= r) {
      int v = l + (r-l) / 2;
      
      int sumHours = 0;
      for (int pile : piles) {
        sumHours += Math.ceil((double)pile / v);
      }
      
      if (sumHours <= h) {
        res = Math.min(res, v);
        r = v - 1;
      }  
      else l = v + 1;
    }
    return res;
  }
}