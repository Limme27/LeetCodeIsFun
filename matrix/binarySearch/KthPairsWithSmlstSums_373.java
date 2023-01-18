package matrix.binarySearch;
import java.util.ArrayList;
import java.util.List;

// 240 -> 378 -> 373
public class KthPairsWithSmlstSums_373 {
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    int len1 = nums1.length, len2 = nums2.length;
    int l = nums1[0]+nums2[0], r = nums1[len1-1]+nums2[len2-1];
    while (l < r) {
      int m = l + (r-l)/2;
      int count = numElementsLessOrEqualTarget(nums1, nums2, m);
      if (count < k) l = m+1;
      else r = m;
    }
    return getPairs(nums1, nums2, r, k);
  }

  public int numElementsLessOrEqualTarget(int[] nums1, int[] nums2, int target) {
    int count = 0;
    for (int i = 0; i < nums1.length; i++) {
      int j = nums2.length-1;
      while (j >= 0) {
        if (nums1[i]+nums2[j] <= target) break;
        j--;
      }
      if (j < 0) break;
      else count += (j+1);
    }
    return count;
  }

  public List<List<Integer>> getPairs(int[] nums1, int[] nums2, int target, int numPairs) {
    List<List<Integer>> ans = new ArrayList<>();
    
    for (int i = 0; i < nums1.length; i++) {
      int j = nums2.length-1;
      while (j >= 0 && nums1[i]+nums2[j] >= target) j--;
      if (j >= 0) {
        for (int k = 0; k <= j && ans.size() < numPairs; k++) {
          List<Integer> pair = new ArrayList<>();
          pair.add(nums1[i]);
          pair.add(nums2[k]);
          ans.add(pair);
        }
      }
      else break;
    }
    
    for (int i = 0; i < nums1.length; i++) {
      int j = nums2.length-1;
      while (j >= 0 && nums1[i]+nums2[j] > target) j--;
      if (j >= 0) {
        for (int k = 0; k <= j && ans.size() < numPairs; k++) {
          if (nums1[i]+nums2[k] == target) {
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[i]);
            pair.add(nums2[k]);
            ans.add(pair);
          }
        }
      }
      else break;
    }
    return ans;
  }
  
  
  public static void main(String[] args) {
    KthPairsWithSmlstSums_373 k = new KthPairsWithSmlstSums_373();
    int[] a = {0,0,0,0,0};
    int[] b = {-3,22,35,56,76};
    System.out.println(k.kSmallestPairs(a, b, 22));
  }
  
}
