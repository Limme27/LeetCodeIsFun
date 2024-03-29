package binarySearch.bsAlike2Pointers;

// 167 -> 15
public class TwoSum2_m167 {
  public int[] twoSum(int[] numbers, int target) {
    int[] res = new int[2];
    int l = 0, r = numbers.length-1;
    while (l < r) {
      if (numbers[l] + numbers[r] > target) r--;
      else if (numbers[l] + numbers[r] < target) l++;
      else {
        res[0] = l+1;
        res[1] = r+1;
        break;
      }
    }
    return res;
  }
}
