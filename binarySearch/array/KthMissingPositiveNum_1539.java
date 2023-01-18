package binarySearch.array;

public class KthMissingPositiveNum_1539 {
  // O(logN)
  public int findKthPositive(int[] arr, int k) {
    int l = 0, r = arr.length-1;
    while (l <= r) {
      int m = l + (r-l)/2;
      if (arr[m] - (m + 1) < k)
        l = m + 1;
      else
        r = m - 1;
    }
    return l + k;
  }
  // O(N)
  public int findKthPositiveLinear(int[] arr, int k) {
    int len = arr.length;
    int upperBond = arr[len-1];
    int[] tmp = new int[upperBond];

    for (int i = 0; i < tmp.length; i++) {
      tmp[i] = i + 1;
    }
    int counter = 0;
    int i = 0, j = 0;
    while (i < len) {
      while (j < tmp.length) {
        if (tmp[j] != arr[i]) {
          counter++;
          if (counter == k) return tmp[j];
          j++;
        } else {
          j++;
          break;  
        }
      }
      i++;
    }
    return upperBond + k - counter;
  }
}
