package matrix.binarySearch;
// 240 -> 378 -> 373
public class KthSmlstElementInSortedMatrix_378 {
  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    int l = matrix[0][0], r = matrix[n-1][n-1];
    while (l < r) {
      int m = l + (r-l)/2;
      int count = numElementsLessOrEqualTarget(matrix, m);
      if (count < k) l = m+1;
      else r = m;
    }
    return r;
  }

  public int numElementsLessOrEqualTarget(int[][] matrix, int target) {
    int count = 0;
    
    int m = matrix.length;
    int n = matrix[0].length;
    int row = 0, col = n-1;
    while (row < m && col >= 0) {
      if (target >= matrix[row][col]) {
        count += (col+1);
        row++;  
      }
      // target < matrix[row][col] 
      else col--;
    }
    return count;
  }

  public static void main(String[] args) {
    KthSmlstElementInSortedMatrix_378 k = new KthSmlstElementInSortedMatrix_378();
    int[][] a = {{1,5,9}, {10,11,13}, {12,13,15}};
    System.out.println(k.kthSmallest(a, 8));
  }
}
