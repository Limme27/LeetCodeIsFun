package array;

public class ThirdMaxNum_414 {
  public int thirdMax(int[] nums) {
    long firstMax = Long.MIN_VALUE;
    long secondMax = Long.MIN_VALUE;
    long thirdMax = Long.MIN_VALUE;
    for (int i : nums) {
      if (i == firstMax || i == secondMax || i == thirdMax) continue;
      if (i > firstMax) {
        thirdMax = secondMax;
        secondMax = firstMax;
        firstMax = i;
      }
      else if (i > secondMax) {
        thirdMax = secondMax;
        secondMax = i;
      }
      else if (i > thirdMax) thirdMax = i;
    }
    return (thirdMax == Long.MIN_VALUE) ? (int)firstMax : (int)thirdMax;
  }
}
