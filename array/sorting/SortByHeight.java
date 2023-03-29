package array.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByHeight {
  public static int[] sortHeight(int[] nums) {
    List<Integer> l = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) if (nums[i] != -1) l.add(nums[i]);
    Collections.sort(l);
    for (int i = 0; i < nums.length; i++) if (nums[i] != -1) nums[i] = l.remove(0);
    return nums;
  }
  public static void main(String[] args) {
    int[] a = {-1, 150, 190, 170, -1, -1, 180, 160};
    a = sortHeight(a);
    for (Integer i : a) System.out.println(i);
  }
  
}
