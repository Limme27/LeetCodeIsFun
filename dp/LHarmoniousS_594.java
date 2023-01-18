package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LHarmoniousS_594 {
	public int findLHS(int[] nums) {
		// map the value to its counter
		Map<Integer, Integer> dict = new HashMap<>();
		for (int e : nums) {
			dict.put(e, dict.getOrDefault(e, 0) + 1);
		}
		
		// inti dp[][]
		int len = dict.keySet().size();
		int[] dp = new int[len];
		for (int i = 0; i < len; i++) dp[i] = 0;
		
		// get the sorted key array of the map O(nlogn)
		Integer[] temp = dict.keySet().toArray(new Integer[len]);
		List<Integer> newNums = new ArrayList<>();
		for (int e : temp) newNums.add(e);
		Collections.sort(newNums);

		int[] keys = new int[len];
		int index = 0;
		for(Integer element : newNums) keys[index++] = element.intValue();

		for (int i = 0; i < len - 1; i++) {
			if (keys[i] == keys[i+1] - 1) dp[i] = dict.get(keys[i]) + dict.get(keys[i+1]);
		}

		return Arrays.stream(dp).max().getAsInt();        
	}
}
