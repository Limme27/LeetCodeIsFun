package greedy;

public class JumpGame1_55 {
  // optimal
  public boolean canJump(int[] nums) {
    int len = nums.length;
    int furthestIndexCanJump = 0;
    for (int i = 0; i < len; i++) {
      if (i > furthestIndexCanJump) return false;
      furthestIndexCanJump = Math.max(furthestIndexCanJump, i + nums[i]);
    }
    return true;
  }

  // less efficient
  public boolean canJumpReverse(int[] nums) {
    int len = nums.length;
    int goal = len - 1;
    for (int i = len - 2; i >= 0; i--) {
      if (i + nums[i] >= goal) goal = i;
    }
    return goal == 0 ? true : false;
  }
}
