package matrix;

public class MatrixMulti {
  public static int[][] multiplication(int[][] m1, int[][] m2) {
    int[][] ans = new int[m1.length][m2[0].length];
    for (int i = 0; i < m1.length; i++) {
      for (int j = 0; j < m2[0].length; j++) {
        for (int k = 0; k < m2.length; k++)
          ans[i][j] += m1[i][k] * m2[k][j];
      }
    }
    return ans;
  }
  public static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
  public static void main(String[] args) { 
    int[][] a = {{1, 2}, {3, 4}};
    int[][] b = {{5, 6}, {7, 8}};
    printMatrix(multiplication(a, b)); // {19, 22}, {43, 50}
    int[][] c = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] d = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
    printMatrix(multiplication(c, d)); // {{30, 24, 18}, {84, 69, 54}, {138, 114, 90}}
    int[][] e = {{1, 2, 3}, {4, 5, 6}};
    int[][] f = {{7, 8}, {9, 10}, {11, 12}};
    printMatrix(multiplication(e, f)); // {58, 64}, {139, 154}
  }
}