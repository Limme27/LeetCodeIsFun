package binarySearch.twoPointerNotBS;
// this is not a binary search question, just a 2-pointer question
public class SumofSquareNumbers_633 {
  public boolean judgeSquareSum(int c) {
    int l = 0, r = (int)Math.sqrt(c);
    while (l <= r) {
      if (r * r + l * l < c) l++;
      else if (r * r + l * l > c) r--;
      else return true;
    }
    return false;
  }

  public static void main(String[] args) {
     System.out.println((int)Math.sqrt(8));
  }
}
