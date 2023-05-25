package greedy;

import java.util.Stack;

class Solution {
	public boolean find132pattern(int[] nums) {
		int len = nums.length;
		int[] mins = new int[len];
		int min = nums[0];
		for (int j = 1; j < len-1; j++) {
			if (min > nums[j-1]) min = nums[j-1];
			mins[j] = min;
		}
		Stack<Integer> s = new Stack<>();
		s.push(nums[len-1]);
			
		for (int j = len-2; j > 0; j--) {
			int k = Integer.MIN_VALUE;
			while (!s.isEmpty() && nums[j] > s.peek()) k = s.pop(); // Monotonic stack
			s.push(nums[j]);
			if (k > mins[j]) return true;
		}
		return false;
	}
}
