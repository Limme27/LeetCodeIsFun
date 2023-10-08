package array.specialAlgo;

// O(1) space
public class MajorityElement_e169 {
  public static int majorityElement(int[] nums) {
    int ans = nums[0];
    int count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == ans) count++;
      else {
        if (count > 0) count--;
        else {
          ans = nums[i];
          count++;
        }
      }
    }
    return ans;  
  }
  public static void main(String[] args) {
    int[] a = {3,2,3};
    System.out.println(majorityElement(a));
  }
}
