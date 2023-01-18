package array.prefixSum;

public class ProductOfArrayExceptSelf_238 {
  public int[] productExceptSelf(int[] nums) {
    int prefix = nums[0];
    int product = 1;
    int suffix = 1;
    boolean zero = false;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        prefix = product;
        zero = true;
        product *= nums[i];
        continue;
      }
      else {
        if (zero) suffix *= nums[i];
        product *= nums[i];
      }
    }

    int[] result = new int[nums.length];
    for (int i = 0; i < result.length; i++) {
      if (nums[i] == 0) result[i] = prefix * suffix;
      else result[i] = product / nums[i];
    }
    return result;
  }
}
