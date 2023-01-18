package greedy;

public class JumpGame2_45 {
  public int jump(int[] nums) {
    int len = nums.length;
    if (len == 1) return 0;

    int counter = 1;
    int i = 0;
    while (i < len - 1) {
      if (i + nums[i] >= len - 1) return counter;
      int furthestIndexCanJumpFromJ = i + 1;
      int nextI = i + 1;
      for (int j = i + 1; j <= i + nums[i]; j++) {
        if (j >= len - 1) return counter;
        if (j + nums[j] >= furthestIndexCanJumpFromJ) {
          furthestIndexCanJumpFromJ = j + nums[j];
          nextI = j;
        }
        if (furthestIndexCanJumpFromJ >= len - 1) return counter + 1;
      }
      i = nextI;
      counter++;
    }
    return counter;
  }

  public int jumpOptimal(int[] nums) {
    int len = nums.length;
    int l = 0, r = 0, counter = 0;
    // if r == len - 1, the code should stop
    while (r < len - 1) {
      int furthestIndexCanJump = 0;
      for (int i = l; i <= r; i++) furthestIndexCanJump = Math.max(furthestIndexCanJump, i + nums[i]);
      l = r + 1;
      r = furthestIndexCanJump;
      counter++;
    }
    return counter;
  }

  public static void main(String[] args) {
    JumpGame2_45 j = new JumpGame2_45();
    int[] a = {2,3,1,1,4};
    int[] b = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
    System.out.println(j.jumpOptimal(a));
    System.out.println(j.jumpOptimal(b));
  }
}
