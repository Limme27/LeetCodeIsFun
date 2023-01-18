package matrix.binarySearch;

public class Search2DMatrix_74 {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    int rowL = 0, rowR = m-1;
    while (rowL <= rowR) {
      int rowM = rowL + (rowR-rowL)/2;
      if (target < matrix[rowM][0]) rowR = rowM - 1;
      else if (target > matrix[rowM][n-1]) rowL = rowM + 1;
      else {
        if (target == matrix[rowM][0] || target == matrix[rowM][n-1]) return true;
        int l = 0, r = n-1;
        while (l <= r) {
          int colM = l + (r-l)/2;
          if (target < matrix[rowM][colM]) r = colM - 1;
          else if (target > matrix[rowM][colM]) l = colM + 1;
          else return true;
        }
        return false;
      }
    }    
    return false;
  }
}